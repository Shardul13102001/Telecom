package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.ContactPayload;

@Epic("User Module")
@Feature("Add Contact Feature")
public class TC05_Add_Contact extends TestBase {
	
	@Test
	@Severity(SeverityLevel.CRITICAL)
	@Story("Add Contact")
    @Description("Verify add contact")
	public void addContact() throws IOException
	{
		
		System.out.println("Using Token2: " + TestBase.token2);
		System.out.println("Contact Email: " + UpdatedEmail);
		 
		ContactPayload payload = new ContactPayload();
		payload.setFirstName("NineTails");
		payload.setLastName("Beast");
		payload.setBirthdate("1970-01-01");
		payload.setEmail(UpdatedEmail);
		payload.setPhone("8005555555");
		payload.setStreet1("1 Main St.");
		payload.setStreet2("Apartment A");
		payload.setCity("Leaf");
		payload.setStateProvince("stateProvince");
		payload.setPostalCode("12345");
		payload.setCountry("Japan");
		
		Response res = RestAssured.given()
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.header("Authorization", "Bearer " + TestBase.token2)
						.body(payload)
						.when()
						.post(TestBase.addContact)
						.then()
						.statusCode(201)
						.log().all()
						.extract().response();
		
		//Validate status message
		String status = res.statusLine();
		Assert.assertTrue(status.contains("Created"));
		
		//store ID
		id = res.jsonPath().getString("_id");
						
	}

}

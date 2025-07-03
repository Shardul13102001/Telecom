package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import config.ConfigReader;
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
@Feature("Update Contact_PUT Feature")
public class TC08_Update_Contact_Put extends TestBase{
	
	@Test
	@Severity(SeverityLevel.CRITICAL)
	@Story("Update Contact (PUT)")
    @Description("Verify Update Contact_PUT")
	public void UpdateContact() throws IOException
	{
		prop = ConfigReader.getProperty();
		
		System.out.println(TestBase.id);
		
		ContactPayload payload = new ContactPayload();
		payload.setFirstName("Chris");
		payload.setLastName("Gardner");
		payload.setBirthdate("1970-02-02");
		payload.setEmail(prop.getProperty("UpdateContactEmail"));
		payload.setPhone("1234567890");
		payload.setStreet1("2 Main St.");
		payload.setStreet2("Apartment b");
		payload.setCity("Konoha");
		payload.setStateProvince("stateProvince108");
		payload.setPostalCode("54321");
		payload.setCountry("USA");
		
		Response res = RestAssured.given()
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.header("Authorization", "Bearer " + TestBase.token2)
						.body(payload)
						.when()
						.put(TestBase.getContact + TestBase.id)
						.then()
						.statusCode(200)
						.log().all()
						.extract().response();
		
		//Validate status message
		String status = res.statusLine();
		Assert.assertTrue(status.contains("OK"));
	}

}

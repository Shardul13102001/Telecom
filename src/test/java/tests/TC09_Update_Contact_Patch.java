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
import payloads.UpdateContactPatchPayload;

@Epic("User Module")
@Feature("Update Contact_PATCH Feature")
public class TC09_Update_Contact_Patch extends TestBase {

	@Test
	@Severity(SeverityLevel.CRITICAL)
	@Story("Update Contact (PATCH)")
    @Description("Verify Update Contact_PATCH")
	public void UpdateContactPatch() throws IOException
	{
		prop = ConfigReader.getProperty();
		
		System.out.println(TestBase.id);
		
		UpdateContactPatchPayload payload = new UpdateContactPatchPayload();
		payload.setFirstName("Achary");
		payload.setLastName("Chanakya");
		
		Response res = RestAssured.given()
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.header("Authorization", "Bearer " + TestBase.token2)
						.body(payload)
						.when()
						.patch(TestBase.getContact + TestBase.id)
						.then()
						.statusCode(200)
						.log().all()
						.extract().response();
		
		//Validate status message
		String status = res.statusLine();
		Assert.assertTrue(status.contains("OK"));
	}
}

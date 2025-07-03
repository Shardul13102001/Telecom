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
import payloads.UpdateUserPayload;

@Epic("User Module")
@Feature("Update New User Feature")
public class TC03_Update_User extends TestBase {
	
	@Test 
	@Severity(SeverityLevel.CRITICAL)
	@Story("Update User")
    @Description("Verify update user profile")
	public void UpdateUser() throws IOException
	{
		
		prop = ConfigReader.getProperty();
		
		UpdateUserPayload payload = new UpdateUserPayload();
		payload.setFirstName("Naruto");
		payload.setLastName("Uzumaki");
		payload.setEmail(UpdatedEmail);
		payload.setPassword(prop.getProperty("newPassword"));
		
		Response res = RestAssured.given()
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.header("Authorization", "Bearer " + token1)
						.body(payload)
						.log().body()
						.when()
						.patch(updateUser)
						.then()
						.statusCode(200)
						.log().all()
						.extract().response();
		
		//validate status message
		String status = res.getStatusLine();
		Assert.assertTrue(status.contains("OK"));
		
	}

}

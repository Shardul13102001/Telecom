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

@Epic("User Module")
@Feature("Get New User Feature")
public class TC02_Get_User_Profile extends TestBase {
	
	@Test
	@Severity(SeverityLevel.CRITICAL)
	@Story("Get User")
    @Description("Verify get user profile")
	public void GetUser() throws IOException 
	{
		baseSetup();
		Response res = RestAssured.given()
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.header("Authorization", "Bearer " + token1)
						.when()
						.get(getUser)
						.then()
						.statusCode(200)
						.log().all()
						.extract().response();
		
		//validate status message
		String status = res.getStatusLine();
		Assert.assertTrue(status.contains("OK"));

	}
}

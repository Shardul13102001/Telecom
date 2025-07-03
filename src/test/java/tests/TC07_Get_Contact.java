package tests;

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
@Feature("Get Contact Feature")
public class TC07_Get_Contact {
	
	@Test
	@Severity(SeverityLevel.CRITICAL)
	@Story("Get Contact")
    @Description("Verify get contact")
	public void getContact()
	{
		Response res = RestAssured.given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.header("Authorization", "Bearer " + TestBase.token2)
				.when()
				.get(TestBase.getContact + TestBase.id)
				.then()
				.statusCode(200)
				.log().all()
				.extract().response();

		//Validate status message
		String status = res.statusLine();
		Assert.assertTrue(status.contains("OK"));
	}

}

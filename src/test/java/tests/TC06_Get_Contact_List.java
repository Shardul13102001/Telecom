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
@Feature("Get Contact List Feature")
public class TC06_Get_Contact_List extends TestBase {
	
	@Test
	@Severity(SeverityLevel.CRITICAL)
	@Story("Get Contact List")
    @Description("Verify get contact list")
	public void getContactList() throws IOException
	{
		if (token2 == null) {
			UserLogin();
	    }
		
		Response res = RestAssured.given()
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.header("Authorization", "Bearer " + TestBase.token2)
						.when()
						.get(getContactList)
						.then()
						.statusCode(200)
						.log().all()
						.extract().response();
		
		//Validate status message
		String status = res.statusLine();
		Assert.assertTrue(status.contains("OK"));
		
	}

}

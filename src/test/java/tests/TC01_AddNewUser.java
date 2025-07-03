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
import io.restassured.response.Response;

@Epic("User Module")
@Feature("Add New User Feature")
public class TC01_AddNewUser extends TestBase {
	
	public static String userEmail;
	
	@Test
	@Severity(SeverityLevel.CRITICAL)
	@Story("Add User")
    @Description("Verify New User created succesfully")
	public void addNewUser() throws IOException
	{ 
		Response res = signupres;
		res.then()
		.statusCode(201)
		.log().all();
		
		//validate status 
		Assert.assertTrue(res.getStatusLine().contains("Created"));
		
		//store email
		userEmail = res.jsonPath().getString("email");
		
	}
}

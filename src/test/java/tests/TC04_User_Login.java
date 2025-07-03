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
import payloads.loginPayload;

@Epic("User Module")
@Feature("User login Feature")
public class TC04_User_Login extends TestBase {
	
	
	@Test
	@Severity(SeverityLevel.CRITICAL)
	@Story("User Login")
    @Description("Verify user login")
	public void userLogin() throws IOException 
	{
		TestBase.UserLogin();
		Response res = TestBase.loginres;
		res.then()
		.statusCode(200)
        .log().all()
        .extract().response();
		
		System.out.println("Using Token2: " + TestBase.token2);
		TestBase.token2 = loginres.jsonPath().getString("token");
		
		
		/*
		prop = ConfigReader.getProperty();
		
	    loginPayload payload1 = new loginPayload();
	    //payload1.setEmail(TestBase.UpdatedEmail);
	    payload1.setEmail("itachi1751391373503@gmail.com");
	    payload1.setPassword(prop.getProperty("newPassword"));

	    Response res = RestAssured.given()
	            .contentType(ContentType.JSON)
	            .accept(ContentType.JSON)	         
	            .body(payload1)
	            .when()
	            .post(TestBase.userLogin)
	            .then()
	            .statusCode(200)
	            .log().all()
	            .extract().response();
	    
	   String newtoken = res.jsonPath().getString("token");
	   TestBase.token2 = newtoken;
	   
	   System.out.println("Using Token2: " + TestBase.token2);
	   */
	}

}

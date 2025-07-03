package base;

import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import config.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.AddNewUserPayload;
import payloads.loginPayload;

public class TestBase {
	
	public static Properties prop;
	public static String token1;
	public static String token2;
	public static String UpdatedEmail;
	public static String id;
	
	public static Response signupres;
    public static Response loginres;
	
	public static String NewUser = "users";
	public static String getUser = "users/me";
	public static String userLogin = "users/login";
	public static String addContact = "contacts";
	public static String getContactList = addContact; 
	public static String getContact = "contacts/";
	public static String updateUser = getUser;
	public static String userLogout = "users/logout";
	
	public static AddNewUserPayload payload;
	
	public static boolean isUserCreated = false;
	
	@BeforeSuite
	public static void baseSetup() throws IOException {
		if (!isUserCreated) {
			
		long time = System.currentTimeMillis();
		String newEmail = "itachi" + time + "@gmail.com";
		
	    prop = ConfigReader.getProperty();
	    RestAssured.baseURI = prop.getProperty("baseURI");
		prop = ConfigReader.getProperty();
	    
	        String UpdatedEmail1 = newEmail;
	        UpdatedEmail = UpdatedEmail1;

	        AddNewUserPayload payload = new AddNewUserPayload();
	        payload.setFirstName("Itachi");
	        payload.setLastName("Uchiha");
	        payload.setEmail(UpdatedEmail);
	        payload.setPassword(prop.getProperty("password"));
	        
	        

	        signupres = RestAssured.given()
	                .contentType(ContentType.JSON)
	                .accept(ContentType.JSON)
	                .body(payload)
	                .when()
	                .post(NewUser);

	        token1 = signupres.jsonPath().getString("token");

	        // Set flag so user is not created again
	        isUserCreated = true;
		}
	}
	

	public static void UserLogin() throws IOException {
	    prop = ConfigReader.getProperty();
	    loginPayload payload1 = new loginPayload();
	    payload1.setEmail(prop.getProperty("email"));
	    payload1.setPassword(prop.getProperty("newPassword"));

	    loginres = RestAssured.given()
	            .contentType(ContentType.JSON)
	            .accept(ContentType.JSON)         
	            .body(payload1)
	            .when()
	            .post(TestBase.userLogin);
	            

	    token2 = loginres.jsonPath().getString("token");
	    
	}

/*
	public static void loginAndGetToken() throws IOException {
		prop = ConfigReader.getProperty();
		
	    loginPayload payload1 = new loginPayload();
	    payload1.setEmail(newEmail);
	    payload1.setPassword(prop.getProperty("newPassword"));

	    loginres = RestAssured.given()
	            .contentType(ContentType.JSON)
	            .accept(ContentType.JSON)
	            .body(payload1)
	            .when()
	            .post(userLogin);

	    token2 = loginres.jsonPath().getString("token");
	}

	
	public static String RandomEmail()
	{
		long time = System.currentTimeMillis();
		String newEmail = "itachi" + time + "@gmail.com";
		return newEmail;
	}
*/
	
}

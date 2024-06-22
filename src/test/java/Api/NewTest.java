package Api;

import org.testng.annotations.Test;
import io.restassured.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*; 

import java.util.HashMap;


public class NewTest {
  @Test(priority = 3)
  public void get() {
	  given()
	  .header("Conter type","application/json")
	  .when()
	  .get("https://reqres.in/api/user?page=2")
	  .then()
	  .statusCode(200)
	  .log().all();
  }
  
 
  
  @Test(priority = 1)
  public void post()
  {
	  
	  HashMap<String, String> data=new HashMap<String, String>();
	  data.put("Name", "Aditya");
	  data.put("Roll", "Api-Automation");
	  data.put("JOD", "12.06.2024");
	  given()
	  .contentType("application/JSON")
	  .body(data)
	  .when()
	  .post("https://reqres.in/api/users")
	  .then()
	  .statusCode(201)
	  .log().all();
  }
  
  
  @Test(priority = 2)
  public void put()
  {
	  
	  HashMap<String, String> data=new HashMap<String, String>();
	  data.put("Name", "Aditya-kumar");
	  data.put("Roll", "Automation");
	  data.put("JOD", "22.06.2024");
	  given()
	  .contentType("application/JSON")
	  .body(data)
	  .when()
	  .put("https://reqres.in/api/users/386")
	  .then()
	  .statusCode(200)
	  .log().all();
  }
  
  @Test(priority = 4)
  public void delete()
  {
	  

	  given()
	  .contentType("application/JSON")
	  .when()
	  .delete("https://reqres.in/api/users/389")
	  .then()
	  .statusCode(204)
	  .log().all();
  }
  
}

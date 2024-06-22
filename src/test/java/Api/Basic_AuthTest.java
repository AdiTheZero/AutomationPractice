package Api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.Test;

public class Basic_AuthTest {
  @Test
  public void basicAuth() {
	  
	  RequestSpecification requestSpec= RestAssured.given();
	  
	  
	  //Specify URL
	  requestSpec.baseUri("https://www.postman-echo.com");
	  requestSpec.basePath("/basic-auth");
	  
	  Response res = requestSpec.auth().basic("postman", "password").get();//-->base 64 encode
	  
	 // Response res1 = requestSpec.auth().preemptive().basic("postman", "password").get();
	  
      System.out.println(res.statusLine());
      System.out.println(res.body().asString());
  }
}

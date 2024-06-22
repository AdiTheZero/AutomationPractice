package Api;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Bearer_Token {
    @Test
    public void bearerToken() {
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("name", "Aditya");
        data.put("email", "aditya@example.com");
        data.put("gender", "male");
        data.put("status", "active");

        String authToken = "Bearer 20f5565af0c0a2233afd65ecf3400e96486e6a3d791c3b04ff05cd2a47500d2b";

        RequestSpecification requestSpec = RestAssured.given();
        requestSpec
            .header("Authorization", authToken)
            .contentType(ContentType.JSON)
            .body(data)
            .baseUri("https://gorest.co.in")
            .basePath("/public/v2/users");

        Response res = requestSpec.post();

        System.out.println(res.statusCode());
        System.out.println(res.statusLine());
        System.out.println(res.getBody().asString());  // Print the response body for further inspection
    }
}

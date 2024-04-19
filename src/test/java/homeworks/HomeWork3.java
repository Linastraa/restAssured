package homeworks;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class HomeWork3 {

         /**
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     **/

         @Test
         public void assertion(){

             String url = "https://reqres.in/api/users/3";
             Response response = given().get(url);

             int statusCode = response.statusCode();
             System.out.println("statusCode = " + statusCode);

             String contentType = response.contentType();
             System.out.println("contentType = " + contentType);

             String statusLine = response.statusLine();
             System.out.println("statusLine = " + statusLine);


             //ASSERTIONS:-

             response
                     .then()
                     .statusCode(200)
                     .contentType(ContentType.JSON)
                     .statusLine("HTTP/1.1 200 OK");


//                 SoftAssert softAssert = new SoftAssert();
//
//                 softAssert.assertEquals(statusCode,200);
//
//                 softAssert.assertTrue(contentType.contains("application/json"));
//
//                 softAssert.assertEquals(statusLine,"HTTP/1.1 200 OK");
//
//                 softAssert.assertAll();
         }
}

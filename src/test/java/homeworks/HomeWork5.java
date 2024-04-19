package homeworks;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Collections;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class HomeWork5 {

       /**
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty
     **/

       @Test
       public void assertion(){
           String url = "https://reqres.in/api/users/23";

           Response response = given().get(url);

           int statusCode = response.statusCode();
           System.out.println("statusCode = " + statusCode);

           String StatusLine = response.statusLine();
           System.out.println("StatusLine = " + StatusLine);

           String Server = response.header("Server");
           System.out.println("Server = " + Server);

           response.prettyPrint();


           //ASSERTIONS:-

           response
                   .then()
                   .statusCode(404)
                   .statusLine("HTTP/1.1 404 Not Found")
                   .header("Server","cloudflare")
                   .body("", equalTo(Collections.emptyMap()));
       }
}

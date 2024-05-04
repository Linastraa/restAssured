package homeworks.HomeWork16;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class Authentication {
    public static String generateToken() {

        Map<String, String> bodyMap = new HashMap<>();
        String email="";

        if (email==null){
            bodyMap.put("email", "jasonsteel@gmail.com");//If the email is null we will assign our email and password.
            bodyMap.put("password", "Jason.123");
        }else {
            bodyMap.put("email", "linastraaa@gmail.com");//This email will be assigned by selenium run. If selenium does not work, this will be null.
            bodyMap.put("password", "Linastra1420");
        }


        Response response = given()
                .body(bodyMap)
                .contentType(ContentType.JSON)
                .post("https://thinking-tester-contact-list.herokuapp.com/users/login");
//        response.prettyPrint();

        return response.jsonPath().getString("token");
    }
}

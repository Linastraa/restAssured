package homeworks.HomeWork15;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static homeworks.HomeWork15.Authentication.generateToken;


public class BaseUrl {
    public static RequestSpecification spec;

    static  {

        spec = new RequestSpecBuilder()
                .setBaseUri("https://thinking-tester-contact-list.herokuapp.com/users")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization","Bearer "+generateToken())
                .build();

    }
}

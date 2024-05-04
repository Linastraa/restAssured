package homeworks.HomeWork16;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static homeworks.HomeWork16.Authentication.generateToken;


public class BaseUrl {
    public static RequestSpecification spec;

    static  {

        spec = new RequestSpecBuilder()
                .setBaseUri("https://thinking-tester-contact-list.herokuapp.com/contacts")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization","Bearer "+generateToken())
                .build();

    }
}

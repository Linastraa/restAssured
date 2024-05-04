package homeworks.HomeWork13;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetMethod extends  BaseUrl{
    /** Write an automation test that will create a 'user' then read, update and delete the created user
     using the "https://petstore.swagger.io/" document. (Create a classes for each request.) **/

    @Test
    public void getRequest() {
        spec.pathParams("first", "Linastra");
        Response response = given(spec).get("{first}");//Parameters can be declared directly here
        response.prettyPrint();

        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", equalTo(9), //hasSize() method checks this list's number of element
                        "username", equalTo("Linastra"),
                        "firstName", equalTo("Sulaiman"),//hasItem() method checks the existence of one single element in a list
                        "lastName", equalTo("Alzahrani"),
                        "email", equalTo("test@gamil.com"),
                        "password", equalTo("12344321"),
                        "phone", equalTo("+966123456789"),
                        "userStatus", equalTo(4));
    }
}

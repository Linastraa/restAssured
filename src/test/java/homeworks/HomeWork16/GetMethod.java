package homeworks.HomeWork16;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetMethod extends BaseUrl{
    @Test
    public void getRequest() {
        spec.pathParams("first", "");
        Response response = given(spec).get("{first}");//Parameters can be declared directly here
        response.prettyPrint();

        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("_id", hasItems("663646f30a93760013f0d091","663647032e101a0013feacd8"), //hasSize() method checks this list's number of element
                        "firstName", hasItem("John"),
                        "lastName", hasItem("Doe"),
                        "birthdate", hasItem("1970-01-01"),
                        "email", hasItem("jdoe@fake.com"));
    }
}

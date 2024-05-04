package homeworks.HomeWork16;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class DeleteMethod extends BaseUrl{
    @Test
    public void deleteRequest() {
        spec.pathParams("first", "");

        Response response = given(spec).delete("{first}");
        response.prettyPrint();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.statusCode(), 200);
        softAssert.assertEquals(response.contentType(), "unknown");
        softAssert.assertEquals(response.body(), "Contact delete");

        softAssert.assertAll();
    }
    }

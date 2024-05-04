package homeworks;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class HomeWork14 {
    /**
    Given
        https://dummy.restapiexample.com/api/v1/employees
    When
        User sends Get Request to the Url
    Then
        Status code is 200
    And
        There are 24 employees
    And
        "Tiger Nixon" and "Garrett Winters" are among the employees
    And
        The greatest age is 66
    And
        The name of the lowest age is "Tatyana Fitzpatrick"
    And
        Total salary of all employees is 6,644,770
 **/
    @Test
    public void assertion(){
        String url = "https://dummy.restapiexample.com/api/v1/employees";

        Response response = given().get(url);

        int statusCode = response.statusCode();
        System.out.println("statusCode = " + statusCode);

        String contentType = response.contentType();
        System.out.println("contentType = " + contentType);

        response.prettyPrint();




        response
                .then()
                .statusCode(200)//Satus code is 200
                .body("data", hasSize(24),
                        "data.employee_name",hasItems("Tiger Nixon","Garrett Winters"));

        List<Integer> MaxAge =
    }
}

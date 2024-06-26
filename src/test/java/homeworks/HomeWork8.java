package homeworks;

import base_urls.HomeWork8BaseUrl;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class HomeWork8 extends HomeWork8BaseUrl {

      /**
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
     **/

      @Test
      public void assertion(){
          spec.pathParams("first", "");

          String expectedData = """
                                 {
                                 "name": "morpheus",
                                 "job": "leader"
                                 }
                                 """;
          Response response = given(spec)
                  .body(expectedData)
                  .post("{first}");

          response.prettyPrint();

          //ASSERTIONS:-

          response
                  .then()
                  .statusCode(201)
                  .body("name", equalTo("morpheus"),
                          "job", equalTo("leader"));
      }

}

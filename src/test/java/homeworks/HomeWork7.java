package homeworks;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class HomeWork7 {

      /**
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then

            1)Status code is 200
            2)Print all pantone_values
            3)Print all ids greater than 3 on the console
              Assert that there are 3 ids greater than 3
            4)Print all names whose ids are less than 3 on the console
              Assert that the number of names whose ids are less than 3 is 2
    **/

      @Test
      public void assertion(){
          String url = "https://reqres.in/api/unknown/";

          Response response = given().get(url);

          int statusCode = response.statusCode();
          System.out.println("statusCode = " + statusCode);

          //printing the entire response first
          response.prettyPrint();

          SoftAssert softAssert = new SoftAssert();

          softAssert.assertEquals(statusCode,200);

          JsonPath jsonPath = response.jsonPath();
          List<Integer> pantone_valueList = jsonPath.getList("data.pantone_value");
          //then printing pantone_values
          System.out.println("pantone_values List = " + pantone_valueList);

          List<Integer> idlist = jsonPath.getList("data.id");
          List<Integer> IDsGreaterThan3 = new ArrayList<>();
          int idsGreaterThan3 = 0;
          for (int w : idlist) {
              if (w > 3) {
                  IDsGreaterThan3.add(w);
                  idsGreaterThan3++;
              }
          }
          System.out.println("IDs Greater Than 3 List = " + IDsGreaterThan3);
          softAssert.assertEquals(IDsGreaterThan3.size(),3);

          List<String> IDsSmallerThan3 = new ArrayList<>();
          int idsSmallerThan3 = 0;
          for (int w : idlist) {
              if (w < 3) {
                  IDsSmallerThan3.add(jsonPath.getString("data["+(w-1)+"].name"));
                  idsGreaterThan3++;
              }
          }
          System.out.println("Names whose IDs are less Than 3 List = " + IDsSmallerThan3);
          softAssert.assertEquals(IDsSmallerThan3.size(),2);

          softAssert.assertAll();
      }
}

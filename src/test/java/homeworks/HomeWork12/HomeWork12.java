package homeworks.HomeWork12;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class HomeWork12 extends BaseUrl {
    @Test
    public void postRequest() {
        spec.pathParams("first", "");

        tags[] tags = {new tags()};
        tags[0].setId(4);
        tags[0].setName("test");

        category category = new category();
        category.setId(6);
        category.setName("fish");

        PlaceHolder HomeWork12 = new PlaceHolder();
        HomeWork12.setId(9);
        HomeWork12.setCategory(category);
        HomeWork12.setName("dog");
        String []phote = {"test"};
        HomeWork12.setPhotoUrls(phote);
        HomeWork12.setTags(tags);
        HomeWork12.setStatus("available");


        PlaceHolder expectedData = new PlaceHolder(9,category,"dog",phote,tags,"available");

        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        PlaceHolder actualDa = response.as(PlaceHolder.class);
        System.out.println("actualDa = " + actualDa);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.statusCode(), 200);
        softAssert.assertEquals(actualDa.getId(), expectedData.getId());
        //softAssert.assertEquals(actualDa.getCategory(), expectedData.getCategory());
        softAssert.assertEquals(actualDa.getName(), expectedData.getName());
        softAssert.assertEquals(actualDa.getPhotoUrls(), expectedData.getPhotoUrls());
        //softAssert.assertEquals(actualDa.getTags(), expectedData.getTags());
        softAssert.assertEquals(actualDa.getStatus(), expectedData.getStatus());
        softAssert.assertAll();
    }
}

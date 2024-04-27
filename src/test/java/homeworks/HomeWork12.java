package homeworks;

import base_urls.HomeWork12BaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pojos.*;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;
import static org.testng.Assert.assertEquals;

public class HomeWork12 extends HomeWork12BaseUrl{
    @Test
    public void postRequest() {
        spec.pathParams("first", "");

        HomeWork12_tags[] tags = {new HomeWork12_tags()};
        tags[0].setId(4);
        tags[0].setName("test");

        HomeWork12_category category = new HomeWork12_category();
        category.setId(6);
        category.setName("fish");

        JsonPlaceHolderPojo_HomeWork12 HomeWork12 = new JsonPlaceHolderPojo_HomeWork12();
        HomeWork12.setId(9);
        HomeWork12.setCategory(category);
        HomeWork12.setName("dog");
        String []phote = {"test"};
        HomeWork12.setPhotoUrls(phote);
        HomeWork12.setTags(tags);
        HomeWork12.setStatus("available");


        JsonPlaceHolderPojo_HomeWork12 expectedData = new JsonPlaceHolderPojo_HomeWork12(9,category,"dog",phote,tags,"available");

        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        JsonPlaceHolderPojo_HomeWork12 actualDa = response.as(JsonPlaceHolderPojo_HomeWork12.class);
        System.out.println("actualDa = " + actualDa);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.statusCode(), 200);
        softAssert.assertEquals(actualDa.getId(), expectedData.getId());
        softAssert.assertEquals(actualDa.getCategory(), expectedData.getCategory());
        softAssert.assertEquals(actualDa.getName(), expectedData.getName());
        softAssert.assertEquals(actualDa.getPhotoUrls(), expectedData.getPhotoUrls());
        softAssert.assertEquals(actualDa.getTags(), expectedData.getTags());
        softAssert.assertEquals(actualDa.getStatus(), expectedData.getStatus());
        softAssert.assertAll();
    }
}

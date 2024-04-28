package homeworks.HomeWork12;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasItem;

public class HomeWork12 extends BaseUrl {
    @Test
    public void postRequest() {
        spec.pathParams("first", "");

        //setting parameters for tags part
        tags[] tags = {new tags()};
        tags[0].setId(4);
        tags[0].setName("test");

        //setting parameters for category part
        category category = new category();
        category.setId(6);
        category.setName("fish");

        //setting parameters for the entire body
        PlaceHolder HomeWork12 = new PlaceHolder();
        HomeWork12.setId(9);
        HomeWork12.setCategory(category);
        HomeWork12.setName("dog");
        String []phote = {"test"};
        HomeWork12.setPhotoUrls(phote);
        HomeWork12.setTags(tags);
        HomeWork12.setStatus("available");

        //saving the parameters with the name expectedData to post it into the server
        PlaceHolder expectedData = new PlaceHolder(9,category,"dog",phote,tags,"available");

        //posing the parameters
        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        //getting the parameters after posting it to do assertions
        PlaceHolder actualDa = response.as(PlaceHolder.class);
        System.out.println("actualDa = " + actualDa);

        //assertions
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.statusCode(), 200);
        softAssert.assertEquals(actualDa.getId(), expectedData.getId());
        softAssert.assertEquals(actualDa.getCategory().getId(), expectedData.getCategory().getId());
        softAssert.assertEquals(actualDa.getCategory().getName(), expectedData.getCategory().getName());
        softAssert.assertEquals(actualDa.getName(), expectedData.getName());
        softAssert.assertEquals(actualDa.getPhotoUrls(), expectedData.getPhotoUrls());
        softAssert.assertEquals(actualDa.getTags()[0].getId(), expectedData.getTags()[0].getId());
        softAssert.assertEquals(actualDa.getTags()[0].getName(), expectedData.getTags()[0].getName());
        softAssert.assertEquals(actualDa.getStatus(), expectedData.getStatus());
        softAssert.assertAll();
    }
    @Test
    public void getRequest() {
        spec.pathParams("first", "9");

        Response response = given(spec).get("{first}");//Parameters can be declared directly here
        response.prettyPrint();

        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", equalTo(9), //hasSize() method checks this list's number of element
                        "category.id", equalTo(6),
                        "category.name", equalTo("fish"),//hasItem() method checks the existence of one single element in a list
                        "name", equalTo("dog"),
                        "photoUrls", hasItem("test"),
                        "tags.id", hasItem(4),
                        "tags.name", hasItem("test"),
                        "status",equalTo("available"));
    }

    @Test
    public void putRequest() {
        spec.pathParams("first", "");

        //setting parameters for tags part
        tags[] tags = {new tags()};
        tags[0].setId(17);
        tags[0].setName("afterPutMethod");

        //setting parameters for category part
        category category = new category();
        category.setId(16);
        category.setName("fishAfterPutMethod");

        //setting parameters for the entire body
        PlaceHolder HomeWork12 = new PlaceHolder();
        HomeWork12.setId(9);
        HomeWork12.setCategory(category);
        HomeWork12.setName("doggi");
        String []phote = {"testAfterPutMethod"};
        HomeWork12.setPhotoUrls(phote);
        HomeWork12.setTags(tags);
        HomeWork12.setStatus("available");

        //saving the parameters with the name expectedData to post it into the server
        PlaceHolder expectedData = new PlaceHolder(9,category,"doggi",phote,tags,"available");

        //posing the parameters
        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        //getting the parameters after posting it to do assertions
        PlaceHolder actualDa = response.as(PlaceHolder.class);
        System.out.println("actualDa = " + actualDa);

        //assertions
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.statusCode(), 200);
        softAssert.assertEquals(actualDa.getId(), expectedData.getId());
        softAssert.assertEquals(actualDa.getCategory().getId(), expectedData.getCategory().getId());
        softAssert.assertEquals(actualDa.getCategory().getName(), expectedData.getCategory().getName());
        softAssert.assertEquals(actualDa.getName(), expectedData.getName());
        softAssert.assertEquals(actualDa.getPhotoUrls(), expectedData.getPhotoUrls());
        softAssert.assertEquals(actualDa.getTags()[0].getId(), expectedData.getTags()[0].getId());
        softAssert.assertEquals(actualDa.getTags()[0].getName(), expectedData.getTags()[0].getName());
        softAssert.assertEquals(actualDa.getStatus(), expectedData.getStatus());
        softAssert.assertAll();
    }

    @Test
    public void deleteRequest() {
        spec.pathParams("first", "9");

        PlaceHolder expectedData = new PlaceHolder();

        Response response = given(spec).delete("{first}");//First create a data and delete it. Do not delete some else's data.
        response.prettyPrint();

        PlaceHolder actualDa = response.as(PlaceHolder.class);
        System.out.println("actualDa = " + actualDa);

        //assertions
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(response.statusCode(), 200);
        softAssert.assertEquals(response.contentType(), "unknown");
        softAssert.assertEquals(actualDa, expectedData);


    }

}

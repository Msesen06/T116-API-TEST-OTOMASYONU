package Practice;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class C07_JsonPath {
    /*
***         Send a GET Request to https://reqres.in/api/users

              * test:
              The status code : 200
              The content type : application/json; charset=utf-8
              email : george.bluth@reqres.in
              first_name : George
              last_name : Bluth
              avatar : https://reqres.in/img/faces/1-image.jpg
 */

    @Test
    public void test(){

        Response response = given().when().get("https://reqres.in/api/users");
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath(); // api üzerinden gelen cevabın kalıbını, yapısını değiştirdik
        Assert.assertEquals("george.bluth@reqres.in",jsonPath.getString("data[0].email"));
        Assert.assertEquals("George",jsonPath.getString("data[0].first_name"));
        Assert.assertEquals("Bluth",jsonPath.getString("data[0].last_name"));
        Assert.assertEquals("https://reqres.in/img/faces/1-image.jpg",jsonPath.get("data[0].avatar"));
        Assert.assertEquals(1,jsonPath.getInt("data[0].id"));

    }



}

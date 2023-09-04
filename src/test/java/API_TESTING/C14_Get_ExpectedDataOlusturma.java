package API_TESTING;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert.*;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class C14_Get_ExpectedDataOlusturma {
    /*

         https://jsonplaceholder.typicode.com/posts/22 url’ine bir GET request yolladigimizda donen response body’sinin asagida verilen ile ayni oldugunu test ediniz
        Response body :
        {
        “userId”: 3,
        “id”: 22,
        “title”: “dolor sint quo a velit explicabo quia nam”,
        “body”: “eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
        um mollitia molestiae aut atque rem suscipit\nnam impedit esse”
        }
     */

    @Test
    public void expectedData(){
        //1- Endpoint
        String url ="https://jsonplaceholder.typicode.com/posts/22";

        //2- Expected Data
        JSONObject expData=new JSONObject();
        expData.put( "userId",3);
        expData.put( "id",22);
        expData.put( "title","dolor sint quo a velit explicabo quia nam");
        expData.put( "body","eos qui et ipsum ipsam suscipit aut\n" +
                "sed omnis non odio\n" +
                "expedita earum mollitia molestiae aut atque rem suscipit\n" +
                "nam impedit esse");

        //3- Response Kaydet

        Response response =given().when().get(url);
        //karsılastırma yapabilmek icin kodlarımıza response verilerini okutmamız gerekir
        //bunun icin JsonPath classından bir obje olusturuyoruz
        JsonPath jsonPath =response.jsonPath();
        assertEquals(expData.get("userId"),jsonPath.get("userId"));
        assertEquals(expData.get("id"),jsonPath.get("id"));
        assertEquals(expData.get("title"),jsonPath.get("title"));
        assertEquals(expData.get("body"),jsonPath.get("body"));

    }
}

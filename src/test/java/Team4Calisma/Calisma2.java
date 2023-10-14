package Team4Calisma;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static io.restassured.RestAssured.given;

public class Calisma2 {

          /*
            C14_Put_SoftAssertIleExpectedDataTesti
            http://dummy.restapiexample.com/api/v1/update/21 url’ine asagidaki body’ye
            sahip bir PUT request gonderdigimizde donen response’un
            asagidaki gibi oldugunu test edin.
            Request Body
                {
                “status”: “success”,
                “data”: {
                        “name”: “Ahmet”,
                        “salary”: “1230”,
                        “age”: “44”,
                        “id”: 40
                        }
                }
             Response Body
                {
                “status”: “success”,
                “data”: {
                            “name”: “Ahmet”,
                            “salary”: “1230",
                            “age”: “44",
                            “id”: 40 }
                },
                “message”: “Successfully! Record has been updated.«
               }
         */

    @Test
    public void test(){

        //1 Endpoint
        String url ="http://dummy.restapiexample.com/api/v1/update/21";

        //Request body

        JSONObject innerData =new JSONObject();
        innerData.put("name","Ahmet");
        innerData.put("salary",1230);
        innerData.put("age",44);
        innerData.put("id",40);

        JSONObject reqBody=new JSONObject();
        reqBody.put("data",innerData);
        reqBody.put("status","success");

        //Response kaydet

        Response response =given().contentType(ContentType.JSON)
                            .when().body(innerData.toString()).put(url);
        response.prettyPrint();

        //Assertions

        JSONObject expData=new JSONObject();

        expData.put("status","success");
        expData.put("data",innerData);
        expData.put("message","Successfully! Record has been updated.");


        JsonPath resJP=response.jsonPath();
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertEquals(resJP.get("status"),expData.get("status"));
        softAssert.assertEquals(resJP.get("data.name"),expData.getJSONObject("data").get("name"));
        softAssert.assertEquals(resJP.get("data.salary"),expData.getJSONObject("data").get("salary"));
        softAssert.assertEquals(resJP.get("data.age"),expData.getJSONObject("data").get("age"));
        softAssert.assertEquals(resJP.get("data.id"),expData.getJSONObject("data").get("id"));
        softAssert.assertEquals(resJP.get("message"),expData.get("message"));
        softAssert.assertAll();


    }


}

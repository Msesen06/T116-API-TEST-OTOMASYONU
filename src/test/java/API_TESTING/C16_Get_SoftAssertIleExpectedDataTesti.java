package API_TESTING;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import org.json.JSONObject;
import org.testng.asserts.SoftAssert;


public class C16_Get_SoftAssertIleExpectedDataTesti {

       /*
            C16_Get_SoftAssertIleExpectedDataTesti

            http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET
            request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
            Response Body
            {
                "status": "success",

                    "data": {
                        "id": 3,
                        "employee_name": "Ashton Cox",
                        "employee_salary": 86000,
                        "employee_age": 66, "profile_image": ""
                             },
                "message": "Successfully! Record has been fetched."
            }

       */

    @Test
    public void get01(){

        //1 - Endpoint
        String url ="http://dummy.restapiexample.com/api/v1/employee/3";

        // expected data
        /* {
                "status": "success",
                "data": {
                    "id": 3,
                    "employee_name": "Ashton Cox",
                    "employee_salary": 86000,
                    "employee_age": 66, "profile_image": ""
                    },
                "message": "Successfully! Record has been fetched."
             }

         */

        JSONObject expData =new JSONObject();
        JSONObject innerData=new JSONObject();
        innerData.put("id", 3);
        innerData.put( "employee_name", "Ashton Cox");
        innerData.put("employee_salary",86000);
        innerData.put("employee_age", 66);
        innerData.put("profile_image", "");

        expData.put( "status", "success");
        expData.put( "data", innerData);
        expData.put( "message", "Successfully! Record has been fetched.");

        //Response kaydet
        Response response =given().when().get(url);

        //Assertions

        SoftAssert softAssert =new SoftAssert();

        JsonPath resJP=response.jsonPath();

        softAssert.assertEquals(resJP.get("status"),expData.get("status"));
        softAssert.assertEquals(resJP.get("message"),expData.get("message"));
        softAssert.assertEquals(resJP.get("data.employee_name"),expData.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(resJP.get("data.employee_age"),expData.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(resJP.get("data.profile_image"),expData.getJSONObject("data").get("profile_image"));
        softAssert.assertAll("tamamlandı");






    }

}

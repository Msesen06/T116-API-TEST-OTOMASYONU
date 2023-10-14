package Team4Calisma;


import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static io.restassured.RestAssured.given;


public class Calisma3 {


        /*
            https://restful-booker.herokuapp.com/booking url’ine asagidaki body’ye
            sahip bir POST request gonderdigimizde donen response’un
            id haric asagidaki gibi oldugunu test edin.
            Request Body
                {
                   "firstname" : "Mustafa",
                   "lastname" : "SESEN",
                   "totalprice" : 116,
                   "depositpaid" : true,
                   "bookingdates" : {
                        "checkin" : "2023-01-01",
                        "checkout" : "2023-02-01"
                    },
                    "additionalneeds" : "Breakfast"
                }
             Response Body
              {
                "bookingid": 5071,
                "booking": {
                    "firstname": "Mustafa",
                    "lastname": "SESEN",
                    "totalprice": 116,
                    "depositpaid": true,
                    "bookingdates": {
                        "checkin": "2023-01-01",
                        "checkout": "2023-02-01"
                    },
                    "additionalneeds": "Breakfast"
                }
            }
         */


    @Test
    public void test01(){
        //1- Endpoint
        String url ="https://restful-booker.herokuapp.com/booking";

        //2- Request body

        JSONObject innerData=new JSONObject();
        innerData.put("checkin","2023-01-01");
        innerData.put("checkout" ,"2023-02-01");

        JSONObject reqBody =new JSONObject();
        reqBody.put("firstname" , "Mustafa");
        reqBody.put("lastname" , "SESEN");
        reqBody.put("totalprice" , 116);
        reqBody.put("depositpaid",true);
        reqBody.put("bookingdates" , innerData);
        reqBody.put("additionalneeds","Breakfast");

        //3 - Response kaydet

        Response response =given().contentType(ContentType.JSON).when()
                         .body(reqBody.toString()).post(url);


        //4- assertions
        JSONObject expData=new JSONObject();
        expData.put("booking",reqBody);


        JsonPath resJP=response.jsonPath();
        System.out.println(resJP.get("booking.firstname").toString());
        SoftAssert softAssert =new SoftAssert();

        softAssert.assertEquals(resJP.get("booking.firstname"),expData.getJSONObject("booking").get("firstname"));
        softAssert.assertEquals(resJP.get("booking.lastname"),expData.getJSONObject("booking").get("lastname"));
        softAssert.assertEquals(resJP.get("booking.totalprice"),expData.getJSONObject("booking").get("totalprice"));
        softAssert.assertEquals(resJP.get("booking.depositpaid"),expData.getJSONObject("booking").get("depositpaid"));
        softAssert.assertEquals(resJP.get("booking.bookingdates.checkin"),expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"));
        softAssert.assertAll("tests passed");







    }




}

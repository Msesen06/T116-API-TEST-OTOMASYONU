package API_TESTING;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class C15_2 {
                /*

            https://restful-booker.herokuapp.com/booking url’ine asagidaki body’ye sahip bir
            POST request gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin
            Request Body
            {
            “firstname” : “Ahmet”,
            “lastname” : “Bulut”,
            “totalprice” : 500,
            “depositpaid” : false,
            “bookingdates” : {
                                “checkin” : “2021-06-01”,
                                 “checkout” : “2021-06-10”
                                },
            “additionalneeds” : “wi-fi”
            }
            ResponseBody

            {
            “bookingid”: 24,
            “booking”: {
            “firstname”: “Ahmet”,
             “lastname”: “Bulut”,
              “totalprice”: 500,
              “depositpaid”: false,
              “bookingdates”: {
                            “checkin”: “2021-06-01",
                            “checkout”: “2021-06-10"
                                },
            “additionalneeds”: “wi-fi”
            }
            }
         */

    @Test
    public void expectedDataileJsonPathAssert(){
        String url ="https://restful-booker.herokuapp.com/booking";


        JSONObject innerData=new JSONObject();
        innerData.put("checkin","2021-06-01");
        innerData.put( "checkout","2021-06-10");

        JSONObject reqBody=new JSONObject();

        reqBody.put( "firstname","Ahmet");
        reqBody.put(  "lastname","Bulut");
        reqBody.put(  "totalprice",500);
        reqBody.put(  "depositpaid",false);
        reqBody.put(   "bookingdates",innerData);
        reqBody.put(   "additionalneeds","wi-fi");

        Response response =given().contentType(ContentType.JSON).when()
                .body(reqBody.toString()).post(url);

        response.prettyPrint();

        //ExpectedData
        JSONObject expData=new JSONObject();
        expData.put("booking",reqBody);

        JsonPath jsonPath =response.jsonPath();

        assertEquals(expData.getJSONObject("booking").get("firstname"),jsonPath.get("booking.firstname"));
        assertEquals(expData.getJSONObject("booking").get("lastname"),jsonPath.get("booking.lastname"));
        assertEquals(expData.getJSONObject("booking").get("totalprice"),jsonPath.get("booking.totalprice"));
        assertEquals(expData.getJSONObject("booking").get("depositpaid"),jsonPath.get("booking.depositpaid"));
        assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),jsonPath.get("booking.bookingdates.checkin"));
        assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),jsonPath.get("booking.bookingdates.checkout"));
        assertEquals(expData.getJSONObject("booking").get("additionalneeds"),jsonPath.get("booking.additionalneeds"));

    }
}

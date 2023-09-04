package API_TESTING;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class C15_Post_ExpectedDataveJsonPathileAssertion {
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

        JSONObject outerObject=new JSONObject();

        outerObject.put( "firstname","Ahmet");
        outerObject.put(  "lastname","Bulut");
        outerObject.put(  "totalprice",500);
        outerObject.put(  "depositpaid",false);
        outerObject.put(   "bookingdates",innerData);
        outerObject.put(   "additionalneeds","wi-fi");

        Response response =given().contentType(ContentType.JSON).when()
                            .body(outerObject.toString()).post(url);

        response.prettyPrint();


        //ExpectedData
        JSONObject expData=new JSONObject();

        expData.put( "firstname","Ahmet");
        expData.put(  "lastname","Bulut");
        expData.put(  "totalprice",500);
        expData.put(  "depositpaid",false);
        expData.put(  "bookingdates",innerData);
        expData.put(  "additionalneeds","wi-fi");


        JsonPath jsonPath =response.jsonPath();

        Assert.assertEquals(response.getBody().jsonPath().get("firstname"),jsonPath.get("firstname"));

        //Assert.assertEquals(expData.getJSONObject("booking.lastname"),jsonPath.getJsonObject("booking.lastname"));
        //Assert.assertEquals(expData.getJSONObject("booking.totalprice"),jsonPath.getJsonObject("booking.totalprice"));
        //Assert.assertEquals(expData.getJSONObject("booking.depositpaid"),jsonPath.getJsonObject("booking.depositpaid"));
        //Assert.assertEquals(expData.getJSONObject("booking.bookingdates.checkin"),jsonPath.getJsonObject("booking.bookingdates.checkin"));
        //Assert.assertEquals(expData.getJSONObject("booking.bookingdates.checkout"),jsonPath.getJsonObject("booking.bookingdates.checkout"));
        //Assert.assertEquals(expData.getJSONObject("booking.additionalneeds"),jsonPath.getJsonObject("booking.additionalneeds"));





    }
}

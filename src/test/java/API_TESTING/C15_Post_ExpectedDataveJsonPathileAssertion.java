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

        expData.put( "firstname","Ahmet");
        expData.put(  "lastname","Bulut");
        expData.put(  "totalprice",500);
        expData.put(  "depositpaid",false);
        expData.put(  "bookingdates",innerData);
        expData.put(  "additionalneeds","wi-fi");

        System.out.println(expData);
        JsonPath jsonPath =response.jsonPath();

        Assert.assertEquals(expData.get("firstname"),jsonPath.get("booking.firstname"));
        Assert.assertEquals(expData.get("lastname"),jsonPath.get("booking.lastname"));
        Assert.assertEquals(expData.get("totalprice"),jsonPath.get("booking.totalprice"));
        Assert.assertEquals(expData.get("depositpaid"),jsonPath.get("booking.depositpaid"));
        Assert.assertEquals(expData.getJSONObject("bookingdates").get("checkin"),jsonPath.get("booking.bookingdates.checkin"));
        Assert.assertEquals(expData.getJSONObject("bookingdates").get("checkout"),jsonPath.get("booking.bookingdates.checkout"));


    }
}

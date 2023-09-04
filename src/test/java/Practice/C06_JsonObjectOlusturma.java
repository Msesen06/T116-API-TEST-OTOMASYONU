package Practice;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C06_JsonObjectOlusturma {

        /*
https://restful-booker.herokuapp.com/booking url’ine asagidaki body’ye sahip bir POST
request gonderdigimizde
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
            donen Response’un,
            status code’unun 200,
            ve content type’inin application-json, ve response body’sindeki
            “firstname”in,“Ahmet”, ve “lastname”in, “Bulut”,
            ve “totalprice”in,500,
            ve “depositpaid”in,false,
            ve “checkin” tarihinin 2021-06-01 ve “checkout” tarihinin 2021-06-10 ve “additionalneeds”in,“wi-fi” olduğunu test edin (edited)
     */

    @Test
    public void test01(){


        /*
          “bookingdates” : {
                    “checkin” : “2021-06-01”,
                    “checkout” : “2021-06-10”
                    }
         */
        JSONObject innerBody = new JSONObject();
        innerBody.put("checkin","2021-06-01");
        innerBody.put("checkout","2021-06-10");
        // “firstname” : “Ahmet”,
        //  “lastname” : “Bulut”,
        //  “totalprice” : 500,
        //  “depositpaid” : false,

        JSONObject reqBody = new JSONObject();
        reqBody.put("firstname","Ahmet");
        reqBody.put("lastname","Bulut");
        reqBody.put("totalprice",500);
        reqBody.put("depositpaid",false);
        reqBody.put("bookingdates",innerBody);
        //“additionalneeds” : “wi-fi”
        reqBody.put("additionalneeds","wi-fi");

        //System.out.println(reqBody); oluşturduğumuz objeyi yazdırma


        Response response = given()
                .contentType(ContentType.JSON) // biz verilerimiz JSON formatında gönderiyoruz, api ona göre davran
                .when()
                .body(reqBody.toString())
                .post("https://restful-booker.herokuapp.com/booking");

        response.prettyPrint();

    }
}

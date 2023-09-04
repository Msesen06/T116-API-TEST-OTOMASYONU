package Team4Calisma;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class Calisma1 {
    /*
         https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde
        donen Response’un,
            status code’unun 200,
            ve content type’inin application-json,
            ve response body’sindeki
            "firstname“in, "Susan",
            ve "lastname“in, "Jackson",
            ve "totalprice“in, 612,
            ve "depositpaid“in, false,
            ve "additionalneeds“in, "Breakfast"
        oldugunu test edin
     */

    @Test
    public void bookingTest(){
        String url ="https://restful-booker.herokuapp.com/booking/10";
        Response response = given().when().get(url);

        response.prettyPrint();

        response.then().assertThat()
               .statusCode(200)
               .contentType("application/json")
               .body("firstname",equalTo("Susan"))
               .body("lastname",equalTo("Jones"))
               .body("totalprice",equalTo(744))
               .body("depositpaid",equalTo(true))
               .body("additionalneeds",equalTo("Breakfast"));

       /* response.then().assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("firstname",equalTo("Mark"),"lastname",equalTo("Jackson"),
                        "totalprice",equalTo(900),
                        "depositpaid",equalTo(true),
                        "additionalneeds",equalTo("Breakfast"));

        */







    }

    @Test
    public void createBooking(){
           /*
              {
              "firstname" : "Mustafa",
              "lastname" : "SESEN",
              "totalprice" : 116,
              "depositpaid" : true,
               "bookingdates" : {
                                 "checkin" : "2018-01-01",
                                 "checkout" : "2019-10-01"
                            },
              "additionalneeds" : "wi-fi"
            }
         */
        String url ="https://restful-booker.herokuapp.com/booking";

        JSONObject object1 =new JSONObject();
        object1.put( "checkin","2018-01-01");
        object1.put( "checkout","2019-10-01");

        JSONObject object2=new JSONObject();
        object2.put( "firstname","Mustafa");
        object2.put(  "lastname","SESEN");
        object2.put( "totalprice",116);
        object2.put( "depositpaid" , true);
        object2.put( "bookingdates" , object1);
        object2.put( "additionalneeds" , "wi-fi");

        Response response =given().contentType(ContentType.JSON).when()
                          .body(object2.toString()).put(url);

        response.prettyPrint();

        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("booking.firstname",equalTo("Mustafa"))
                .body("booking.lastname",equalTo("SESEN"))
                .body("booking.totalprice",equalTo(116))
                .body("booking.depositpaid",equalTo(true))
                .body("booking.additionalneeds",equalTo("wi-fi"));



    }
}

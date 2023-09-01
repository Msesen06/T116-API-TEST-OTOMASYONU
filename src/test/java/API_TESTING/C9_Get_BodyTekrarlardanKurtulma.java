package API_TESTING;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class C9_Get_BodyTekrarlardanKurtulma {
      /*
    https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde donen Response’un,
            status code’unun 200,
            ve content type’inin application-json, ve response body’sindeki
            “firstname”in, “Susan”,
            ve “lastname”in, “Jackson”,
            ve “totalprice”in, 612,
            ve “depositpaid”in, false,
	        ve “additionalneeds”in, “Breakfast” oldugunu test edin
     */

    @Test
    public void bodyTekrarindanKurtulma(){
        String url="https://restful-booker.herokuapp.com/booking/10";
        Response response=given().when().get(url);
        response.prettyPrint();

        response.then().assertThat()
                .statusCode(200).contentType("application/json; charset=utf-8")
                .body("firstname", equalTo("Sevda Basgan"),
                        "lastname",equalTo("Basgan Hanım"),
                        "totalprice",equalTo(555),"depositpaid",equalTo(true),
                        "additionalneeds",equalTo("Breakfast")
                );
    }
}

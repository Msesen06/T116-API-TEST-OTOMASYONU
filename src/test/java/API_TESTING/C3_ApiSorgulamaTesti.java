package API_TESTING;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C3_ApiSorgulamaTesti {
    /*
        https://restful-booker.herokuapp.com/booking/830 url’ine bir GET request
    gonderdigimizde donen Response’un,
    status code’unun 200,
    ve content type’inin application/json; charset=utf-8, ve Server isimli Header’in degerinin Cowboy,
    ve status Line’in HTTP/1.1 200 OK
     */
    @Test
    public void getAssert(){
        String url="https://restful-booker.herokuapp.com/booking/830";
        Response response=given().when().get(url);

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .statusLine("HTTP/1.1 200 OK")
                .header("Server","Cowboy");
    }

}

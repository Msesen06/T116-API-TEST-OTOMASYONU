package API_TESTING;


import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers.*;
import org.junit.Test;

import java.awt.geom.RectangularShape;

import static io.restassured.path.xml.XmlPath.given;
import static org.hamcrest.Matchers.*;


public class C13_ResponseBodyTestListKullanimi {

    /*
    http://dummy.restapiexample.com/api/v1/employees url’ine bir GET request yolladigimizda
    donen Response’in
    status code’unun 200,
    ve content type’inin Aplication.JSON, ve response body’sindeki
    employees sayisinin 24
    ve employee’lerden birinin “Ashton Cox”
    ve girilen yaslar icinde 61,21 ve 35 degerinin oldugunu test edin test edin.

     */

    @Test
    public void ListKullanimi(){
        //1- Endpoint hazırlama

        String url ="http://dummy.restapiexample.com/api/v1/employees";

        Response response = given().when().get(url);

        response.then().assertThat()
                        .statusCode(200)
                        .contentType("application/json")
                        .body("data.id", hasSize(24),
                         "data.employee_name",hasItem("Ashton Cox"),
                          "data.employee_age",hasItems(21,61,35));

    }
}

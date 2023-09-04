package Practice;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C05_GetReqTest {

    /*

        *** Send a GET Request to https://reqres.in/api/users

              test that:
              The status code : 200
              The content type : application/json; charset=utf-8

              Bu dataların varlığını test edin :
              email : tracey.ramos@reqres.in
              first_name : Tracey
              last_name : Ramos
              avatar : https://reqres.in/img/faces/6-image.jpg


            {
                "id": 6,
                "email": "tracey.ramos@reqres.in",
                "first_name": "Tracey",
                "last_name": "Ramos",
                "avatar": "https://reqres.in/img/faces/6-image.jpg"
             }
     */


    @Test
    public void test(){

        Response response = given().when().get("https://reqres.in/api/users");
        response.prettyPrint();

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("data[5].email",equalTo("tracey.ramos@reqres.in"))
                .body("data[5].first_name", equalTo("Tracey"))
                .body("data[5].last_name", equalTo("Ramos"))
                .body("data[5].avatar",equalTo("https://reqres.in/img/faces/6-image.jpg"))
                ;


    }

}

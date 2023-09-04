package Practice;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C04_GetReqTest {

    /*
    Get req
    Url :  https://reqres.in/api/users/6

    şunları test edin:
              The status code : 200
              The content type : application/json; charset=utf-8
              email : tracey.ramos@reqres.in
              first_name : Tracey
              last_name : Ramos
              avatar : https://reqres.in/img/faces/6-image.jpg

dönen response:
{
    "data": {
        "id": 6,
        "email": "tracey.ramos@reqres.in",
        "first_name": "Tracey",
        "last_name": "Ramos",
        "avatar": "https://reqres.in/img/faces/6-image.jpg"
    },
    "support": {
        "url": "https://reqres.in/#support-heading",
        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
    }
}
     */

    @Test
    public void test01(){

        Response response = given().when().get("https://reqres.in/api/users/6");
        response.prettyPrint();

        response
                .then()
                .assertThat()
                .contentType("application/json; charset=utf-8")
                .body("data.email",equalTo("tracey.ramos@reqres.in"),
                 "data.first_name",equalTo("Tracey"),
                 "data.last_name",equalTo("Ramos") ,
                 "data.avatar" ,equalTo("https://reqres.in/img/faces/6-image.jpg")


                );



    }
}

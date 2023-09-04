package Practice;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_GetReq {


    @Test
    public void test01(){

        /*
        url : https://reqres.in/api/users/
        get request

        dönen response yazdırın
         */

        // api'dan dönen cevap response objesi içine kaydolur
        Response response = given().when().get("https://reqres.in/api/users/");

        // api dan dönen cevabı yazdıralım
        response.prettyPrint();


    }
}

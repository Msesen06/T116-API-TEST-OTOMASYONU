package API_TESTING;

import baseURL.BaseURL_JSONHolder;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class C17_BaseURL_JsonPlaceHolder extends BaseURL_JSONHolder {

        /*
        Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin
            1- https://jsonplaceholder.typicode.com/posts endpointine bir GET request
               gonderdigimizde donen response’un status code’unun 200 oldugunu
               ve 	Response’ta 100 kayit oldugunu test edin
            2- https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET request
               gonderdigimizde donen response’un status code’unun 200 oldugunu
               ve “title” 	degerinin “optio dolor molestias sit” oldugunu test edin
            3- https://jsonplaceholder.typicode.com/posts/50 endpointine
               bir DELETE request 	gonderdigimizde donen response’un
               status code’unun 200 oldugunu ve response 	body’sinin null oldugunu test edin
     */

    @Test
    public void get01(){

        //endpoint
        specJSONHolder.pathParams("pp1","posts");

        //2 expected data
        //3 response kaydet
        Response response=given().spec(specJSONHolder).when().get("/{pp1}");

        //4- assert
        response.then().assertThat()
               .statusCode(200)
               .body("body",hasSize(100));
    }

    @Test
    public void get02(){
        //1-endpoint
        specJSONHolder.pathParams("pp1","posts","pp2",44);
        //2-expected data
        //3-response kaydet
        Response response=given().spec(specJSONHolder).get("/{pp1}/{pp2}");
        //4- assert
        response.then().assertThat()
                .statusCode(200)
                .body("title",equalTo("optio dolor molestias sit"));
    }

    @Test
    public void get03(){

        //1- endpoint
        specJSONHolder.pathParams("pp1","posts","pp2",50);
        //2- expected data
        //3- response kaydet
        Response response=given().spec(specJSONHolder).delete("/{pp1}/{pp2}");
        //4- assert
        response.then().assertThat()
                .statusCode(200)
                .body("body",equalTo(null));
    }
}

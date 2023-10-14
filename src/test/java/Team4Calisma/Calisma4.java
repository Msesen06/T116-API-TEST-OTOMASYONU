package Team4Calisma;

import baseURL.BaseURL_Dummy;
import io.restassured.response.Response;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class Calisma4 extends BaseURL_Dummy {

    /*
    http://dummy.restapiexample.com/api/v1/employee/5
    endpointine bir GET request
    gonderdigimizde donen response’un status code’unun 200 oldugunu
        "status": "success"
        "employee_name": "Airi Satou",
        "employee_salary": 162700,
        "employee_age": 33,
     */

    @Test
    public void test01(){

        specDummy.pathParams("isa1","employee","isa2",3);

        Response response =given().spec(specDummy).get("/{isa1}/{isa2}");

        response.then().
                statusCode(200)
                .body("status", equalTo("success"),
                        "data.employee_name",equalTo("Ashton Cox"),
                        "data.employee_salary",equalTo(86000),
                        "data.employee_age",equalTo(66));






    }


    /*
    http://dummy.restapiexample.com/api/v1/employees
    endpointine bir GET request
    gonderdigimizde donen response’un status code’unun 200 oldugunu
    data sayısının 24 oldugunu test edin

     */

    @Test
    public void test02(){


    }

}

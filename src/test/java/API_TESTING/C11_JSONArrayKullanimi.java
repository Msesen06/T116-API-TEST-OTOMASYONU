package API_TESTING;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C11_JSONArrayKullanimi {
      /*
    {
    "firstName": "John",
    "lastName": "doe",
    "age": 26,
    "address": {
        "streetAddress": "naist street",
        "city": "Nara",
        "postalCode": "630-0192"
                },
    "phoneNumbers": [
                    {
                        "type": "iPhone",
                        "number": "0123-4567-8888"
                    },
                    {
                        "type": "home",
                        "number": "0123-4567-8910"
                    }
                    ]
    }
     */

    @Test
    public void JSONArray(){
        JSONObject adressObject=new JSONObject();
        adressObject.put("streetAddress","naist street");
        adressObject.put("city","Nara");
        adressObject.put("postalCode","630-0192");

        JSONObject ceptel =new JSONObject();
        ceptel.put( "type","cep");
        ceptel.put( "number","0123-4567-8888");

        JSONObject evtel =new JSONObject();
        evtel.put( "type","home");
        evtel.put( "number","0414-454-1211");

        JSONArray phoneNumbers=new JSONArray();
        phoneNumbers.put(0,ceptel);
        phoneNumbers.put(1,evtel);

        JSONObject outerObject=new JSONObject();

        outerObject.put( "firstName","John");
        outerObject.put("lastName","doe");
        outerObject.put("age",26);
        outerObject.put("address",adressObject);
        outerObject.put("phoneNumbers",phoneNumbers);

        System.out.println(outerObject.toString());


    }











}

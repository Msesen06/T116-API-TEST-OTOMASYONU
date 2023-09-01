package API_TESTING;

import org.json.JSONObject;
import org.junit.Test;

public class C4_JsonObjesiOlusturma {
    /*
    Asagidaki JSON Objesini olusturup konsolda yazdirin.
    {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":1
    }
     */
    @Test
    public void jsonObjesiOlusturma(){

        JSONObject ilkJsonObjesi=new JSONObject();


        ilkJsonObjesi.put("title","Mustafa");
        ilkJsonObjesi.put("body","Merhaba nasılsınız");
        ilkJsonObjesi.put("userId",12);


        System.out.println("İlk JSON Objesi: "+ilkJsonObjesi);
    }
}

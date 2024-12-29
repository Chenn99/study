package com.louis.xml.json;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JSONDemo3 {

    @Test
    public void createJSON(){
        List<Name> list = new ArrayList<>();
        list.add(new Name("louis","ma","110328r@gamil.com"));
        list.add(new Name("schfui","jf","2476292@gamil.com"));
        JsonArray array = new JsonArray();
        for (Name n :list){
            JsonObject obj = new JsonObject();
            obj.addProperty("firstName",n.getFirstName());
            obj.addProperty("lastName",n.getLastName());
            obj.addProperty("email",n.getEamil());
            array.add(obj);
        }
        System.out.println(array.toString());
    }
}

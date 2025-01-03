package com.louis.xml.json;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class JSONDemo2 {

    /**
     * 使用JsonReader 解析复杂的Json数据
     */
    @Test
    public void parseJSONMessages(){
        InputStream is = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/louis/xml/json/message.json");

        InputStreamReader in = new InputStreamReader(is);
        JsonReader jsonReader = new JsonReader(in);
        ArrayList<Message> list = readMessgeArray(jsonReader);
        for (Message m :list){
            System.out.println(m);
        }

    }

    //读取Message数组
    private ArrayList<Message> readMessgeArray(JsonReader jsonReader) {
        ArrayList<Message> list = new ArrayList<>();
        try{
            jsonReader.beginArray();
            while (jsonReader.hasNext()){
                list.add(readMessage(jsonReader));
            }
            jsonReader.endArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    //解析一个Message对象
    private Message readMessage(JsonReader jsonReader){
        Message m = new Message();
        try{
            jsonReader.beginObject();
            while (jsonReader.hasNext()){
                String name = jsonReader.nextName();
                if ("id".equals(name)){
                    m.setId(jsonReader.nextLong());
                } else if ("text".equals(name)) {
                    m.setText(jsonReader.nextString());
                } else if ("geo".equals(name) && jsonReader.peek() != JsonToken.NULL) {
                    m.setGeo(readGeo(jsonReader));
                }else if ("user".equals(name)) {
                    m.setUser(readUser(jsonReader));
                }else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return m;
    }

    /**
     * 解析User
     * @param jsonReader
     * @return
     */
    private User readUser(JsonReader jsonReader){
        User user = new User();
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()){
                String name = jsonReader.nextName();
                if("name".equals(name)){
                    user.setName(jsonReader.nextString());
                } else if ("followers_count".equals(name)) {
                    user.setFollowers_count(jsonReader.nextInt());
                }else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    /**
     * 解析GEO
     * @param jsonReader
     * @return
     */
    private ArrayList<Double> readGeo(JsonReader jsonReader){
        ArrayList<Double> list = new ArrayList<>();
        try {
            jsonReader.beginArray();
            while (jsonReader.hasNext()){
                list.add(jsonReader.nextDouble());
            }
            jsonReader.endArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}

package com.example.sonarqube;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.util.JSON;

@SpringBootApplication
public class SonarqubeApplication {

    public static void main(String[] args) {

        SpringApplication.run(SonarqubeApplication.class, args);

        /*try {

            Mongo mongo = new Mongo("127.0.0.1", 27017);
            DB db = mongo.getDB("dbname");
            DBCollection collection = db.getCollection("dummyColl");

            // convert JSON to DBObject directly

            String json =
                "{\"colorName\" : \"red\",\"hexValue\" : \"#f00\"}";

            DBObject obj = (DBObject) JSON.parse(json);

            collection.insert(obj);

            System.out.println("Done");

        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }



}


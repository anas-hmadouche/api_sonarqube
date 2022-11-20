package com.example.sonarqube.service;

import com.example.sonarqube.entities.Parameters;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MapIssueParams {

    public String readJsonFromFile(String filePath) throws IOException, ParseException {
        String json = Files.readString(Paths.get(filePath));
        return new JSONParser().parse(json).toString();
    }

    public List<Parameters> convert(String JsonString) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        CollectionType typeReference =
                TypeFactory.defaultInstance().constructCollectionType(List.class, Parameters.class);
        List<Parameters> params = om.readValue(JsonString, typeReference);
        return params;
    }
}

package com.example.sonarqube.service;

import com.example.sonarqube.entities.Issue;
import com.example.sonarqube.entities.Parameters;
import com.example.sonarqube.interfaces.Iissues;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.example.sonarqube.issues.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MapIssueParams {

    public List<Iissues> listIissues = new ArrayList<>();


    public String readJsonFromFile(String filePath) throws IOException, ParseException {
        String json = Files.readString(Paths.get(filePath));
        return new JSONParser().parse(json).toString();
    }

    public List<Parameters> convert(String JsonString) throws JsonMappingException, JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        CollectionType typeReference =
                TypeFactory.defaultInstance().constructCollectionType(List.class, Parameters.class);
        List<Parameters> params =  om.readValue(JsonString, typeReference);
        return params;
    }
}

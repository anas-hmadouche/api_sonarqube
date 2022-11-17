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

    public Issue mapIssue(int position, int positionColonne, String types, String severities,
                          String createdBefore, String createdAfter, String projectName, String resolved ) throws ParseException {

        Iissues iissues = new IssueParams();

        iissues.getParameters().setPosition(position);
        iissues.getParameters().setPositionColonne(positionColonne);
        iissues.getParameters().setTypes(types);
        iissues.getParameters().setSeverities(severities);
        String dateBefore = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        if(!createdBefore.equals(""))
            iissues.getParameters().setCreatedBefore(createdBefore);
        else
            iissues.getParameters().setCreatedBefore(dateBefore);

        if(!createdAfter.equals("") && !createdBefore.equals("")){
            iissues.getParameters().setCreatedBefore(createdBefore);
            iissues.getParameters().setCreatedAfter(createdAfter);
        }

        iissues.getParameters().setProjectName(projectName);
        iissues.getParameters().setResolved(resolved);
        listIissues.add(iissues);

        Issue issue = iissues.getIssue();
        if(issue == null)
            return null;
        issue.setPosition(iissues.getParameters().getPosition());
        issue.setPositionColonne(iissues.getParameters().getPositionColonne());

        return issue;
    }



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

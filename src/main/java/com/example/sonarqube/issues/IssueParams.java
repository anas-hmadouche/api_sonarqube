package com.example.sonarqube.issues;

import com.example.sonarqube.entities.Issue;
import com.example.sonarqube.entities.Parameters;
import com.example.sonarqube.interfaces.Iissues;
import com.example.sonarqube.service.IssueService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class IssueParams implements Iissues {

    Parameters parameters = new Parameters();

    @Override
    public Parameters getParameters() {
        return parameters;
    }

    @Override
    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    IssueService issueService = new IssueService();

    @Override
    public Issue getIssue() throws ParseException {
   /*     String parameter = "?" + getParameters().getTypes() + getParameters().getSeverities() + getParameters().getProjectName()
                + getParameters().getCreatedAfter() + getParameters().getCreatedBefore() + getParameters().getStatuses()
                + getParameters().getResolved();
        System.out.println(BASEURL + parameter);
        return issueService.getIssue(BASEURL + parameter);*/
        return null;
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
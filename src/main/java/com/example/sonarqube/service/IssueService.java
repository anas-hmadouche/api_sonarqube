package com.example.sonarqube.service;

import com.example.sonarqube.entities.Issue;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IssueService {
    public IssueService() {
    }

    public Issue getIssue(String url) throws ParseException {

        Issue issue;

        RestTemplate restTemplate = new RestTemplate();
        String resultat = restTemplate.getForObject(url, String.class);

        issue = new Issue();

        JSONParser jsonP = new JSONParser();
        JSONObject jsonO = (JSONObject) jsonP.parse(resultat);
        if(String.valueOf(jsonO.get("total")).equals("0"))
            return null;
        issue.setTotal(String.valueOf(jsonO.get("total")));
        JSONArray jsonA = (JSONArray) jsonO.get("issues");
        JSONObject issueObj = (JSONObject) jsonA.get(0);
        issue.setId((String) issueObj.get("key"));
        issue.setSeverity((String) issueObj.get("severity"));
        issue.setCreationDate((String) issueObj.get("creationDate"));
        issue.setUpdateDate((String) issueObj.get("updateDate"));
        issue.setType((String) issueObj.get("type"));
        issue.setScope((String) issueObj.get("scope"));
        issue.setEffortTotal(String.valueOf(jsonO.get("effortTotal")));

        return issue;

    }

}

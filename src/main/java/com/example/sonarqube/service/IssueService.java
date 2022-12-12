package com.example.sonarqube.service;

import com.example.sonarqube.entities.Issue;
import com.example.sonarqube.entities.IssueDetails;
import com.example.sonarqube.entities.Parameters;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class IssueService {
    public IssueService() {
    }

    public Issue getIssue(Parameters param) throws ParseException {
        RestTemplate restTemplate = new RestTemplate();
        String resultat = restTemplate.getForObject(param.toString(), String.class);

        Issue issue = new Issue();

        // Transformer le resultat en format Json
        JSONParser jsonP = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonP.parse(resultat);
        //
        if(String.valueOf(jsonObject.get("total")).equals("0"))
            return null;
        issue.setTotal(String.valueOf(jsonObject.get("total")));

        JSONArray jsonArray = (JSONArray) jsonObject.get("issues");
        JSONObject issueObj = (JSONObject) jsonArray.get(0);
        issue.setKey((String) issueObj.get("key"));
        issue.setSeverity((String) issueObj.get("severity"));
        issue.setType((String) issueObj.get("type"));
        issue.setScope((String) issueObj.get("scope"));
        issue.setPosition(param.getPosition());
        issue.setPositionColonne(param.getPositionColonne());
        System.out.println(".........................................................................");
        System.out.println(issue);

        List<IssueDetails> listIssueDetails = new ArrayList<>();

        for(int i=0; i<jsonArray.size(); i++){
            IssueDetails issueDetails = new IssueDetails();
            JSONObject issueDetailsObj = (JSONObject) jsonArray.get(i);
            String line = String.valueOf(issueDetailsObj.get("line"));
            String message = (String) issueObj.get("message");
            String component = (String) issueObj.get("component");
            String creationDate = (String) issueObj.get("creationDate");
            creationDate = creationDate.split("T")[0];
            String updateDate = (String) issueObj.get("updateDate");
            updateDate = updateDate.split("T")[0];
            issueDetails.setLine(line);
            issueDetails.setMessage(message);
            issueDetails.setComponent(component);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            issueDetails.setCreationDate(LocalDate.parse(creationDate, formatter));
            issueDetails.setUpdateDate(LocalDate.parse(updateDate, formatter));
            listIssueDetails.add(issueDetails);
        }

        issue.setIssueDetails(listIssueDetails);
        return issue;

    }



}

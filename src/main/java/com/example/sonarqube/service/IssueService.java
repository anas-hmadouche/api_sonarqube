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

    public Issue getIssue(Parameters param, String pagination, String nature, String createdBefore, String createdAfter) throws ParseException {
        RestTemplate restTemplate = new RestTemplate();
        param.setCreatedBefore(param.getCreatedBefore() + createdBefore);
        //param.setCreatedAfter(param.getCreatedAfter() + createdAfter);
        //String p = String.valueOf(page);
        //String ps = String.valueOf(pageSize);
        String resultat = restTemplate.getForObject(param.toString() + pagination, String.class);
        //String resultat = restTemplate.getForObject(param.toString() , String.class);
        //System.out.println("***********" + param.toString() + "&p=" + p + "&ps=" + ps );
        System.out.println("***********" + param.toString() + pagination + "**********"  );
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
        issue.setProject((String) issueObj.get("project"));
        issue.setNature(nature);
        //issue.setPortfolio(portfolio);

        issue.setPosition(param.getPosition());
        issue.setPositionColonne(param.getPositionColonne());

        /*System.out.println(".........................................................................");
        System.out.println(issue);*/

        List<IssueDetails> listIssueDetails = new ArrayList<>();

        for(int i=0; i<jsonArray.size(); i++){
            IssueDetails issueDetails = new IssueDetails();
            JSONObject issueDetailsObj = (JSONObject) jsonArray.get(i);
            JSONObject textRange = (JSONObject) issueDetailsObj.get("textRange");
            String endLine = "";
            if(textRange!=null)
             endLine = String.valueOf(textRange.get("endLine"));
            System.out.println(endLine);
            String message = (String) issueDetailsObj.get("message");
            String component = (String) issueDetailsObj.get("component");
            String creationDate = (String) issueObj.get("creationDate");
            creationDate = creationDate.split("T")[0];
            String updateDate = (String) issueObj.get("updateDate");
            updateDate = updateDate.split("T")[0];
            issueDetails.setEndLine(endLine);
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

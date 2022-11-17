package com.example.sonarqube.issues;

import com.example.sonarqube.entities.Issue;
import com.example.sonarqube.entities.Parameters;
import com.example.sonarqube.interfaces.Iissues;
import com.example.sonarqube.service.IssueService;
import org.json.simple.parser.ParseException;

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
        String parameter = "?" + getParameters().getTypes() + getParameters().getSeverities() + getParameters().getProjectName()
                + getParameters().getCreatedAfter() + getParameters().getCreatedBefore() + getParameters().getStatuses()
                + getParameters().getResolved();
        System.out.println(BASEURL + parameter);
        return issueService.getIssue(BASEURL + parameter);
    }
}
package com.example.sonarqube.service;

import com.example.sonarqube.entities.Issue;
import com.example.sonarqube.export.ExportExcel11;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;

public class InvokeExcel {

    public String exportToExcel(List<Issue> issueList) throws IOException {



        ObjectMapper mapper = new ObjectMapper();

        ExportExcel11 exportExcel11 = new ExportExcel11();

        exportExcel11.exportexcel11(issueList);

        //Converting the Object to JSONString
        String jsonIssue = mapper.writeValueAsString(issueList);

        return jsonIssue;

    }
}

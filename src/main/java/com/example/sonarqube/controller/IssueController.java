package com.example.sonarqube.controller;

import com.example.sonarqube.service.InvokeExcel;
import com.example.sonarqube.service.MapIssueParams;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class IssueController {

    @GetMapping("/bugCritical")
    public String bugCriticalController() throws ParseException, IOException {

        MapIssueParams mapIssueParams = new MapIssueParams();

        InvokeExcel invokeExcel = new InvokeExcel();

        /*return invokeExcel.exportToExcel(mapIssueParams.mapIssue(10, "CODE_SMELL", "MAJOR",
                "2022-09-01", "cardamom:mmg:github:develop", "false"));*/
        return null;

    }

}

package com.example.sonarqube.service;

import com.example.sonarqube.entities.Issue;
import com.example.sonarqube.entities.Parameters;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExposeListIssues {
    public List<Issue> getIssues() {
        List<Issue> issueList = new ArrayList<>();
        try {
            MapIssueParams mapIssueParams = new MapIssueParams();

            // Récupérer le chemin du fichier data.json
            File currentDirFile = new File(".");
            String helper = currentDirFile.getAbsolutePath();
            String res = mapIssueParams.readJsonFromFile(helper + "\\config\\data.json");
            // convertir le contenu json à une liste des paramètres
            List<Parameters> paramsList = mapIssueParams.convert(res);

            IssueService issueService = new IssueService();
            paramsList.stream().map((param) -> {
                try {
                    Issue issue = issueService.getIssue(param);
                    if (issue != null)
                        issueList.add(issue);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                return null;
            }).collect(Collectors.toList());

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Export réalisé avec succés !");
        return issueList;
    }

}

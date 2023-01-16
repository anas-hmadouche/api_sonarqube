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
    public List<Issue> getIssues(String nature, String createdBefore, String createdAfter) {

        List<Issue> issueList = new ArrayList<>();
        try {
            MapIssueParams mapIssueParams = new MapIssueParams();

            // Récupérer le chemin du fichier data.json
            File currentDirFile = new File(".");
            String helper = currentDirFile.getAbsolutePath();
            String res = mapIssueParams.readJsonFromFile(helper + "\\config\\" + nature +".json");
            // convertir le contenu json à une liste des paramètres
            List<Parameters> paramsList = mapIssueParams.convert(res);
            System.out.println("paramlist : " + paramsList + "******");

            IssueService issueService = new IssueService();


            paramsList.stream().map((param) -> {
                try {
                    int total = -1;
                    Issue issue = issueService.getIssue(param, "", nature, createdBefore, createdAfter);
                    System.out.println("********* Get Total **********");

                    if(issue != null) {
                        total = Integer.parseInt(issue.getTotal());
                        if (total > 0) {
                            int pageSize = 5;
                            int page = total / pageSize + 1;
                            for (int i = 1; i <= page; i++) {
                                String pagination = "&p=" + i + "&ps=" + pageSize;
                                issue = issueService.getIssue(param, pagination, nature, createdBefore, createdAfter);
                            }
                            if (issue != null)
                                issueList.add(issue);
                        }
                    }

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


    public List<Issue> getIssues2(String nature, String createdBefore, String createdAfter) {

        return null;
    }

}

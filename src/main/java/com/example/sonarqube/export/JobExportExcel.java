package com.example.sonarqube.export;

import com.example.sonarqube.entities.Issue;
import com.example.sonarqube.entities.Parameters;
import com.example.sonarqube.service.InvokeExcel;

import com.example.sonarqube.service.IssueService;
import com.example.sonarqube.service.MapIssueParams;
import org.json.simple.parser.ParseException;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JobExportExcel implements Job {

    @Override
    public void execute(JobExecutionContext context) {

        // methode d'export des statistiques ExportExcelJob();
        try {
            MapIssueParams mapIssueParams = new MapIssueParams();
            List<Issue> issueList=new ArrayList<>();
            // Récupérer le chemin du fichier data.json
            File currentDirFile = new File(".");
            String helper = currentDirFile.getAbsolutePath();
            String res = mapIssueParams.readJsonFromFile(helper + "\\config\\data.json");
            // convertir le contenu json à une liste des paramètres
            List<Parameters> paramsList = mapIssueParams.convert(res);

            IssueService issueService=new IssueService();
            paramsList.stream().map((param)->{
                try {
                    Issue issue=issueService.getIssue(param);
                    if (issue!=null)
                    issueList.add(issue);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                return null;
            }).collect(Collectors.toList());

            InvokeExcel invokeExcel = new InvokeExcel();

            invokeExcel.exportToExcel(issueList);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Export réalisé avec succés !");
    }


}

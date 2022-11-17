package com.example.sonarqube.export;

import com.example.sonarqube.entities.Issue;
import com.example.sonarqube.entities.Parameters;
import com.example.sonarqube.interfaces.Iissues;
import com.example.sonarqube.service.InvokeExcel;
import com.example.sonarqube.service.MapIssueParams;

import com.google.gson.Gson;
import org.json.simple.parser.ParseException;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JobExportExcel implements Job {

    @Override
    public void execute(JobExecutionContext context) {

        // methode d'export des statistiques ExportExcelJob();
        try {
            MapIssueParams mapIssueParams = new MapIssueParams();

            Issue issueBugCritical;
            issueBugCritical = mapIssueParams.mapIssue(5, 3, "BUG", "CRITICAL",
                    "2022-09-01", "", "cardamom:mmg:github:develop", "false");
            Issue issueBugMajor;
            issueBugMajor = mapIssueParams.mapIssue(6, 3, "BUG", "MAJOR",
                    "2022-09-01", "", "cardamom:mmg:github:develop", "false");
            Issue issueBugBlocker;
            issueBugBlocker = mapIssueParams.mapIssue(7, 3, "BUG", "BLOCKER",
                    "2022-09-01", "", "cardamom:mmg:github:develop", "false");
            Issue issueVulnerabilityBlocker;
            issueVulnerabilityBlocker = mapIssueParams.mapIssue(8, 3, "VULNERABILITY", "BLOCKER",
                    "2022-09-01", "", "cardamom:mmg:github:develop", "false");
            Issue issueCodeSmellCritical;
            issueCodeSmellCritical = mapIssueParams.mapIssue(9, 3, "CODE_SMELL", "CRITICAL",
                    "2022-09-01", "", "cardamom:mmg:github:develop", "false");
            Issue issueCodeSmellMajor;
            issueCodeSmellMajor = mapIssueParams.mapIssue(10, 3, "CODE_SMELL", "MAJOR",
                    "2022-09-01", "", "cardamom:mmg:github:develop", "false");
            Issue issueCodeSmellBlocker;
            issueCodeSmellBlocker = mapIssueParams.mapIssue(11, 3, "CODE_SMELL", "BLOCKER",
                    "2022-09-01", "", "cardamom:mmg:github:develop", "false");

            Issue issueBugCriticalControle;
            issueBugCriticalControle = mapIssueParams.mapIssue(5, 4, "BUG", "CRITICAL", ""
                    , "", "cardamom:mmg:github:develop", "false");
            Issue issueBugMajorControle;
            issueBugMajorControle = mapIssueParams.mapIssue(6, 4, "BUG", "MAJOR", "", "",
                    "cardamom:mmg:github:develop", "false");
            Issue issueBugBlockerControle;
            issueBugBlockerControle = mapIssueParams.mapIssue(7, 4, "BUG", "BLOCKER", "", "",
                    "cardamom:mmg:github:develop", "false");
            Issue issueVulnerabilityBlockerControle;
            issueVulnerabilityBlockerControle = mapIssueParams.mapIssue(8, 4, "VULNERABILITY", "BLOCKER", "", "",
                    "cardamom:mmg:github:develop", "false");
            Issue issueCodeSmellCriticalControle;
            issueCodeSmellCriticalControle = mapIssueParams.mapIssue(9, 4, "CODE_SMELL", "CRITICAL", "", "",
                    "cardamom:mmg:github:develop", "false");
            Issue issueCodeSmellMajorControle;
            issueCodeSmellMajorControle = mapIssueParams.mapIssue(10, 4, "CODE_SMELL", "MAJOR",
                    "", "", "cardamom:mmg:github:develop", "false");
            Issue issueCodeSmellBlockerControle;
            issueCodeSmellBlockerControle = mapIssueParams.mapIssue(11, 4, "CODE_SMELL", "BLOCKER",
                    "", "", "cardamom:mmg:github:develop", "false");

            Issue issueBugCriticalNouveauCode;
            issueBugCriticalNouveauCode = mapIssueParams.mapIssue(5, 5, "BUG", "CRITICAL", "2022-10-31"
                    , "2022-10-01", "cardamom:mmg:github:develop", "false");
            Issue issueBugMajorNouveauCode;
            issueBugMajorNouveauCode = mapIssueParams.mapIssue(6, 5, "BUG", "MAJOR", "2022-10-31"
                    , "2022-10-01",
                    "cardamom:mmg:github:develop", "false");
            Issue issueBugBlockerNouveauCode;
            issueBugBlockerNouveauCode = mapIssueParams.mapIssue(7, 5, "BUG", "BLOCKER", "2022-10-31"
                    , "2022-10-01", "cardamom:mmg:github:develop", "false");
            Issue issueVulnerabilityBlockerNouveauCode;
            issueVulnerabilityBlockerNouveauCode = mapIssueParams.mapIssue(8, 5, "VULNERABILITY", "BLOCKER", "2022-10-31"
                    , "2022-10-01", "cardamom:mmg:github:develop", "false");
            Issue issueCodeSmellCriticalNouveauCode;
            issueCodeSmellCriticalNouveauCode = mapIssueParams.mapIssue(9, 5, "CODE_SMELL", "CRITICAL", "2022-10-31"
                    , "2022-10-01", "cardamom:mmg:github:develop", "false");
            Issue issueCodeSmellMajorNouveauCode;
            issueCodeSmellMajorNouveauCode = mapIssueParams.mapIssue(10, 5, "CODE_SMELL", "MAJOR", "2022-10-31"
                    , "2022-10-01", "cardamom:mmg:github:develop", "false");
            Issue issueCodeSmellBlockerNouveauCode;
            issueCodeSmellBlockerNouveauCode = mapIssueParams.mapIssue(11, 5, "CODE_SMELL", "BLOCKER", "2022-10-31"
                    , "2022-10-01", "cardamom:mmg:github:develop", "false");

            List<Issue> issueList = new ArrayList<>();
            if (issueCodeSmellCritical != null)
                issueList.add(issueCodeSmellCritical);
            if (issueCodeSmellMajor != null)
                issueList.add(issueCodeSmellMajor);
            if (issueCodeSmellBlocker != null)
                issueList.add(issueCodeSmellBlocker);
            if (issueBugCritical != null)
                issueList.add(issueBugCritical);
            if (issueBugMajor != null)
                issueList.add(issueBugMajor);
            if (issueBugBlocker != null)
                issueList.add(issueBugBlocker);
            if (issueVulnerabilityBlocker != null)
                issueList.add(issueVulnerabilityBlocker);

            if (issueCodeSmellCriticalNouveauCode != null)
                issueList.add(issueCodeSmellCriticalNouveauCode);
            if (issueCodeSmellMajorNouveauCode != null)
                issueList.add(issueCodeSmellMajorNouveauCode);
            if (issueCodeSmellBlockerNouveauCode != null)
                issueList.add(issueCodeSmellBlockerNouveauCode);
            if (issueBugCriticalNouveauCode != null)
                issueList.add(issueBugCriticalNouveauCode);
            if (issueBugMajorNouveauCode != null)
                issueList.add(issueBugMajorNouveauCode);
            if (issueBugBlockerNouveauCode != null)
                issueList.add(issueBugBlockerNouveauCode);
            if (issueVulnerabilityBlockerNouveauCode != null)
                issueList.add(issueVulnerabilityBlockerNouveauCode);

            if (issueCodeSmellCriticalControle != null)
                issueList.add(issueCodeSmellCriticalControle);
            if (issueCodeSmellMajorControle != null)
                issueList.add(issueCodeSmellMajorControle);
            if (issueCodeSmellBlockerControle != null)
                issueList.add(issueCodeSmellBlockerControle);
            if (issueBugCriticalControle != null)
                issueList.add(issueBugCriticalControle);
            if (issueBugMajorControle != null)
                issueList.add(issueBugMajorControle);
            if (issueBugBlockerControle != null)
                issueList.add(issueBugBlockerControle);
            if (issueVulnerabilityBlockerControle != null)
                issueList.add(issueVulnerabilityBlockerControle);

            Gson gson = new Gson();
            String jsonArray = gson.toJson(mapIssueParams.listIissues);
            File currentDirFile = new File(".");
            String helper = currentDirFile.getAbsolutePath();
            String res = mapIssueParams.readJsonFromFile(helper + "\\config\\data.json");
            List<Parameters> paramsList = mapIssueParams.convert(res);
            System.out.println(res);
            System.out.println(jsonArray);

            InvokeExcel invokeExcel = new InvokeExcel();

            invokeExcel.exportToExcel(issueList);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Export réalisé avec succés !");
    }
}

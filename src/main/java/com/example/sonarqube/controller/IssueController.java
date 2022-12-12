package com.example.sonarqube.controller;

import com.example.sonarqube.entities.Issue;
import com.example.sonarqube.entities.IssueDetails;
import com.example.sonarqube.service.ExposeListIssues;
import com.example.sonarqube.service.IssuePersistentService;
import com.example.sonarqube.view.IssueView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class IssueController {

    @Autowired
    private ExposeListIssues exposeListIssues;

    @Autowired
    private IssuePersistentService issuePersistentService;

    @GetMapping("/api/issues")
    public List<Issue> getAllIssues()  {
        return exposeListIssues.getIssues();
    }

    @GetMapping("/api/insertIssues")
    public void insertIssues(){
        List<Issue> issues = getAllIssues();
        issues.forEach(issuePersistentService::ajouterIssue);
    }

    @GetMapping("/api/findAll")
    public List<Issue> fetchAllIssues(){
        return issuePersistentService.getAllIssues();
    }

    @GetMapping("/api/findIssueViewAll")
    public List<IssueView> fetchAllIssueViews(){
        return issuePersistentService.getAllIssueViews();
    }

    @GetMapping("/api/findIssueByKey/{key}")
    public List<IssueDetails> fetchIssueByKey(@PathVariable(value = "key") String key) {
        return issuePersistentService.fetchIssueByKey(key).get(0).getIssueDetails();
    }

    @GetMapping("/api/fetchIssueByCreationDate/{creationDate}")
    public List<Issue> fetchIssueByCreationDate(@PathVariable(value = "creationDate") String creationDate) {
        return issuePersistentService.fetchIssueByCreationDate(creationDate);
    }

    @GetMapping("/api/fetchIssueByCreationDateBetween/{dateDebut}/{dateFin}")
    public List<Issue> fetchIssueByCreationDateBetween(@PathVariable(value = "dateDebut") String dateDebut, @PathVariable(value = "dateFin") String dateFin) {
        return issuePersistentService.fetchIssueByCreationDateBetween(dateDebut, dateFin);
    }
}

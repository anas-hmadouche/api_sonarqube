package com.example.sonarqube.controller;

import com.example.sonarqube.entities.Issue;
import com.example.sonarqube.entities.IssueDetails;
import com.example.sonarqube.entities.Portfolio;
import com.example.sonarqube.service.ExposeListIssues;
import com.example.sonarqube.service.IssuePersistentService;
import com.example.sonarqube.service.PortfolioService;
import com.example.sonarqube.view.IssueView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class IssueController {

    @Autowired
    private ExposeListIssues exposeListIssues;

    @Autowired
    private IssuePersistentService issuePersistentService;

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping("/api/issues")
    public List<Issue> getAllIssues(String nature, String createdBefore, String createdAfter)  {
        //List<Issue> issues = exposeListIssues.getIssues(nature, createdBefore, createdAfter, page, pageSize);
        //return new ResponseEntity<>(issues, HttpStatus.OK);
        return exposeListIssues.getIssues(nature, createdBefore, createdAfter);
    }


  /*  @GetMapping("/api/issues")
    public List<Issue> getAllIssues(String nature, String portfolio, String createdBefore, String createdAfter, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "500") int pageSize)  {
        List<Issue> issues = exposeListIssues.getIssues(nature, portfolio, createdBefore, createdAfter, page, pageSize);
        //return new ResponseEntity<>(issues, HttpStatus.OK);
        return exposeListIssues.getIssues(nature, portfolio, createdBefore, createdAfter, page, pageSize);
    }*/

    /*@GetMapping("/api/insertIssues/{nature}/{createdBefore}")
    public void insertIssues(@PathVariable(value = "nature") String nature, @PathVariable(value = "createdBefore") String createdBefore){
        int total = 0;
        //for (Portfolio portfolio : portfolioService.getAllPortfolios()) {
            //if(total == 0)
                total = Integer.parseInt(getAllIssues(nature, createdBefore, "", 1, 1).get(0).getTotal());
            if(total>0) {
                int pageSize = 500;
                int page = total / pageSize + 1;
                for (int i = 1; i <= page; i++) {
                    List<Issue> issues = getAllIssues(nature, createdBefore, "", i, pageSize);
                    issues.forEach(issuePersistentService::ajouterIssue);
                }
            }
        //}

    }*/

/*    @GetMapping("/insertIssues/{nature}/{createdBefore}")
    public void insertIssues(@PathVariable(value = "nature") String nature, @PathVariable(value = "createdBefore") String createdBefore){
        //int total = 0;
        //for (Portfolio portfolio : portfolioService.getAllPortfolios()) {
            *//*if(total == 0)
            total = Integer.parseInt(getAllIssues(nature, portfolio.getName(), createdBefore, "", 1, 1).get(0).getTotal());
            if(total>0) {
                int pageSize = 500;
                int page = total / pageSize + 1;
                for (int i = 1; i <= page; i++) {*//*
                    List<Issue> issues = getAllIssues(nature, createdBefore);
                    issues.forEach(issuePersistentService::ajouterIssue);
               // }
            //}
        }

    }*/

    @GetMapping("/api/insertIssues/{nature}/{createdBefore}")
    public void insertIssues(@PathVariable(value = "nature") String nature, @PathVariable(value = "createdBefore") String createdBefore){
       // for (Portfolio portfolio : portfolioService.getAllPortfolios()) {
            List<Issue> issues = getAllIssues(nature, createdBefore,"");
            issues.forEach(issuePersistentService::ajouterIssue);
        //}

    }

    /*@GetMapping("/api/insertIssues/{nature}/{createdBefore}/{createdAfter}")
    public void insertIssues(@PathVariable(value = "nature") String nature, @PathVariable(value = "createdBefore") String createdBefore, @PathVariable(value = "createdAfter") String createdAfter){
        for (Portfolio portfolio : portfolioService.getAllPortfolios()) {
            List<Issue> issues = getAllIssues(nature, portfolio.getName(), createdBefore, createdAfter, 1, 1);
            issues.forEach(issuePersistentService::ajouterIssue);
        }

    }*/

    @GetMapping("/api/findAll")
    public List<Issue> fetchAllIssues(){
        return issuePersistentService.getAllIssues();
    }

    @GetMapping("/api/findIssueViewAll")
    public List<IssueView> fetchAllIssueViews(){
        return issuePersistentService.getAllIssueViews();
    }

    @GetMapping("/api/findIssueById/{id}")
    public List<IssueDetails> fetchIssueById(@PathVariable(value = "id") String id) {
        return issuePersistentService.fetchIssueById(id).get(0).getIssueDetails();
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

    @GetMapping("/api/fetchIssueByNature/{nature}")
    public List<Issue> fetchIssueByNature(@PathVariable(value = "nature") String nature){
        return issuePersistentService.fetchIssueByNature(nature);
    }

    @GetMapping("/api/fetchIssueByProject/{project}")
    public List<Issue> fetchIssueByProject(@PathVariable(value = "project") String project){
        return issuePersistentService.fetchIssueByProject(project);
    }
    /*@GetMapping("/api/fetchIssueByPortfolio/{portfolio}")
    public List<Issue> fetchIssueByPortfolio(@PathVariable(value = "portfolio") String portfolio){
        return issuePersistentService.fetchIssueByPortfolio(portfolio);
    }*/

/*    @GetMapping("/api/fetchIssueByPortfolio/{portfolio}")
    public List<Issue> fetchIssueByPortfolio(@PathVariable(value = "portfolio") String portfolio){
        List<Issue> issues1 = new ArrayList<>();
        portfolioService.findPortfolioByName(portfolio).getProjects().stream().map(
                project -> {
                    List<Issue> issues = issuePersistentService.findPortfolioByName(portfolio)
                }
        )
    }*/


}

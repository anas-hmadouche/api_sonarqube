package com.example.sonarqube.service;

import com.example.sonarqube.entities.Issue;
import com.example.sonarqube.interfaces.IssueRepository;
import com.example.sonarqube.interfaces.IssueViewRepository;
import com.example.sonarqube.view.IssueView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class IssuePersistentService {

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private IssueViewRepository issueViewRepository;

    public List<Issue> getAllIssues(){
        return issueRepository.findAll();
    }

    public List<IssueView> getAllIssueViews(){
        return issueViewRepository.findAllIssueView();
    }

    public Issue ajouterIssue(Issue issue){
        return issueRepository.insert(issue);
    }
    public List<Issue> fetchIssueByKey(String key){
        return issueRepository.findIssueByKey(key);
    }
    public List<Issue> fetchIssueByCreationDate(String creationDate){
        LocalDate date = LocalDate.parse(creationDate);
        return issueRepository.findByIssueDetailsCreationDate(date);
    }
    public List<Issue> fetchIssueByCreationDateBetween(String dateDebut1, String dateFin1){
        LocalDate dateDebut = LocalDate.parse(dateDebut1);
        LocalDate dateFin = LocalDate.parse(dateFin1);
        return issueRepository.findByIssueDetailsCreationDateBetween(dateDebut, dateFin);
    }

}

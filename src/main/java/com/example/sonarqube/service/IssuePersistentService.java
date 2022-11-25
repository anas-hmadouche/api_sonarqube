package com.example.sonarqube.service;

import com.example.sonarqube.entities.Issue;
import com.example.sonarqube.interfaces.IssueRepository;
import com.example.sonarqube.interfaces.IssueViewRepository;
import com.example.sonarqube.view.IssueView;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@AllArgsConstructor
@Service
public class IssuePersistentService {
    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private IssueViewRepository issueViewRepository;

    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }
    public List<IssueView> getAllIssueViews() {
        return issueViewRepository.findAllIssueView();
    }

   public List<Issue> fetchIssueByKey(String key) {
        return issueRepository.findIssueByKey(key);
    }

    public Issue ajouterIssue(Issue issue) {
        return issueRepository.insert(issue);
    }

    /*public Issue editIssue(@PathVariable(value = "email") String email,
                               @RequestBody Issue studentsDetails) {
        studentsDetails.setEmail(email);
        final Issue updatIssue = repository.save(studentsDetails);
        return updatIssue;
    }*/
}

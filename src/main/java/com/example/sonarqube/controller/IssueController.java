package com.example.sonarqube.controller;

import com.example.sonarqube.entities.Issue;
import com.example.sonarqube.entities.IssueDetails;
import com.example.sonarqube.service.ExposeListIssues;
import com.example.sonarqube.service.IssuePersistentService;
import com.example.sonarqube.view.IssueView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    /*



    /*@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public com.cogigroup.gestionproduits.Student addStudent(@RequestBody com.cogigroup.gestionproduits.Student student) {
        return studentService.ajouterStudent(student);
    }

    @PutMapping(value = "/{email}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<com.cogigroup.gestionproduits.Student> updateStudents(@PathVariable(value = "email") String email ,
                                                                                @RequestBody com.cogigroup.gestionproduits.Student studentsDetails)
            throws ResourceNotFoundException {
        studentsDetails.setEmail(email);
        final com.cogigroup.gestionproduits.Student updateStudent=studentService.editStudent(email,studentsDetails);

        return ResponseEntity.ok(updateStudent);
    }*/

}

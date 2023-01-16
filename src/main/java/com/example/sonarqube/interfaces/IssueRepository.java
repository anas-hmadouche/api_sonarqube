package com.example.sonarqube.interfaces;

import com.example.sonarqube.entities.Issue;
import com.example.sonarqube.entities.Parameters;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface IssueRepository extends MongoRepository<Issue, String> {

    List<Issue> findIssueById(String id);
    List<Issue> findIssueByKey(String key);

    List<Issue> findByIssueDetailsCreationDateLessThanEqual(LocalDate creationDate);

    List<Issue> findByIssueDetailsCreationDateBetween(LocalDate dateDebut, LocalDate dateFin);

    List<Issue> findIssueByProject(String project);

    //List<Issue> findIssueByPortfolio(String portfolio);

    List<Issue> findIssueByNature(String nature);

   /* Optional<Issue> findIssueByEmail(String email);

    List<Issue> findIssueByKey(String key);

    Issue insert(Issue student);

    Issue save(Issue student);*/
}

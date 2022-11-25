package com.example.sonarqube.interfaces;

import com.example.sonarqube.entities.Issue;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IssueRepository extends MongoRepository<Issue, String> {

    List<Issue> findIssueByKey(String key);

   /* Optional<Issue> findIssueByEmail(String email);

    List<Issue> findIssueByKey(String key);

    Issue insert(Issue student);

    Issue save(Issue student);*/
}

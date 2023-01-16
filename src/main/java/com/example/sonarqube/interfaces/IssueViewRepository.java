package com.example.sonarqube.interfaces;

import com.example.sonarqube.entities.Issue;
import com.example.sonarqube.view.IssueView;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface IssueViewRepository extends MongoRepository<Issue, String> {

    @Query("select i from Issue i")
    List<IssueView> findAllIssueView();

}

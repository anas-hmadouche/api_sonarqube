package com.example.sonarqube.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor @ToString
@Document(collection = "Issue")
public class Issue {

    private String id;
    private String key;
    private  String severity;
    private  String type;
    private  String scope;
    private  String total;
    private  String project;
    //private  String portfolio;
    private String nature;
    private List<IssueDetails> issueDetails;
    @JsonIgnore
    private int position;
    @JsonIgnore
    private int positionColonne;
}

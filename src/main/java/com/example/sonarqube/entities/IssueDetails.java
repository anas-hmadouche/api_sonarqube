package com.example.sonarqube.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor @NoArgsConstructor @ToString
public class IssueDetails {
    private  String line;
    private  String message;
    private  String component;
    private  String creationDate;
    private  String updateDate;
    private  String author;
}

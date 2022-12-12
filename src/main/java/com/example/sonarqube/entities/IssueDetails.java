package com.example.sonarqube.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor @ToString
public class IssueDetails {
    private  String line;
    private  String message;
    private  String component;
    private  LocalDate creationDate;
    private  LocalDate updateDate;
    private  String author;
}

package com.example.sonarqube.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IssueView {
    private String key;
    private  String severity;
    private  String type;
    private  String total;
    private  String project;
    private  String portfolio;
}

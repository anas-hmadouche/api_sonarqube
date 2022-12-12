package com.example.sonarqube.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "portfolios")
public class Portfolio {
    private String name;
    private List<Project> projects;

}

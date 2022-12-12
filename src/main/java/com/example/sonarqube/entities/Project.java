package com.example.sonarqube.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "projects")
public class Project {
    private String key;
    private String refKey;
    private String name;
    private String qualifier;
}

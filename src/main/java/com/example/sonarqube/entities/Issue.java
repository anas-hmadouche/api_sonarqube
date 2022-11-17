package com.example.sonarqube.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor @NoArgsConstructor @ToString
@Document(collection = "issues")
public class Issue {

    @Id
    private String id;
    private  String severity;
    private  String creationDate;
    private  String updateDate;
    private  String type;
    private  String scope;
    private  String total;
    private String effortTotal;
    @JsonIgnore
    private int position;
    @JsonIgnore
    private int positionColonne;
}

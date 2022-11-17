package com.example.sonarqube.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
@Getter
public class Parameters {
    private String types = "";
    private String severities = "";
    private String createdBefore = "";
    private String createdAfter = "";
    private String statuses = "";
    private String projectName = "";
    private String resolved = "";
    private int position;
    private int positionColonne;

    public void setTypes(String types) {
        this.types = "types=" + types;
    }

    public void setResolved(String resolved) {
        this.resolved = "&resolved=" + resolved;
    }

    public void setSeverities(String severities) {
        this.severities = "&severities=" + severities;
    }

    public void setCreatedBefore(String createdBefore) {
        this.createdBefore = "&createdBefore=" + createdBefore;
    }

    public void setCreatedAfter(String createdAfter) {
        this.createdAfter = "&createdAfter=" + createdAfter;
    }

    public void setStatuses(String statuses) {
        this.statuses = "&statuses=" + statuses;
    }

    public void setProjectName(String projectName) {
        this.projectName = "&componentKeys=" + projectName;
    }

}

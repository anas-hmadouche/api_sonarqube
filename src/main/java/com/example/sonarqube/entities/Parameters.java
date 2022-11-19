package com.example.sonarqube.entities;

import lombok.*;

@Data
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Parameters {
    private String types = "";
    private String severities = "";
    private String createdBefore = "";
    private String createdAfter = "";
    private String statuses = "";

    @Override
    public String toString() {
        String parameter = "https://sonarqube.inria.fr/sonarqube/api/issues/search?" + getTypes() + getSeverities() + getProjectName()
                + getCreatedAfter() + getCreatedBefore() + getStatuses()
                + getResolved();
        return parameter;
    }

    private String projectName = "";
    private String resolved = "";

    private int position;
    private int positionColonne;

}

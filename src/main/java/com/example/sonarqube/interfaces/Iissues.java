package com.example.sonarqube.interfaces;

import com.example.sonarqube.entities.Issue;
import com.example.sonarqube.entities.Parameters;
import org.json.simple.parser.ParseException;

public interface Iissues {

    String BASEURL = "https://sonarqube.inria.fr/sonarqube/api/issues/search";

    public Parameters getParameters();

    public void setParameters(Parameters parameters);

    Issue getIssue() throws ParseException;

}

package com.example.sonarqube.controller;

import com.example.sonarqube.entities.Portfolio;
import com.example.sonarqube.service.PortfolioService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PortfolioController {
    @Autowired
    private PortfolioService portfolioService;
    @GetMapping("/api/portfolio/findProjectsByPortfolio/{name}")
    public Portfolio findPortfolioByName(@PathVariable(value = "name") String name){
        return portfolioService.findPortfolioByName(name);
    }
    //Retourner les portfolios depuis sonarqube
    @GetMapping("/api/portfolio/getPortfolioFromSonarqube/{name}")
    public Portfolio getPortfolioFromSonarqube(@PathVariable(value = "name") String name) throws ParseException {
        String url = "https://sonarqube.azfr.allianz/sonarqube/api/measures/component_tree?component=" + name + "&metricKeys=coverage";
        return portfolioService.getProjectsByPortfolio(url);
    }
}

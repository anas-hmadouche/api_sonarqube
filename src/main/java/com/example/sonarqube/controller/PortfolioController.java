package com.example.sonarqube.controller;

import com.example.sonarqube.entities.Issue;
import com.example.sonarqube.entities.Portfolio;
import com.example.sonarqube.service.PortfolioService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PortfolioController {
    @Autowired
    private PortfolioService portfolioService;

    @GetMapping("/api/portfolio/findProjectsByPortfolio/{name}")
    public Portfolio findPortfolioByName(@PathVariable(value = "name") String name) throws ParseException {
        Portfolio portfolio = portfolioService.findPortfolioByName(name);

        List<Issue> issues1= new ArrayList<>();
        portfolio.getProjects().size();

        return portfolio;
    }
    //Retourner les portfolios depuis sonarqube
    /*@GetMapping("/api/portfolio/getPortfolioFromSonarqube")
    public Portfolio getPortfolioFromSonarqube() throws ParseException {
       List<Portfolio> portfolios= portfolioService.findAllPortfoliosFromServer();
        Portfolio portfolio=null;
        for (Portfolio p: portfolios) {
            String url = "https://sonarqube.azfr.allianz/sonarqube/api/measures/component_tree?component=" + p.getName()+ "&metricKeys=coverage";
             portfolio = portfolioService.getProjectsByPortfolio(url);
             if(portfolio!=null)
            portfolioService.savePortfolio(portfolio);
        }

        return portfolio;
    }*/

   /* @GetMapping("/api/portfolio/insertPortfolio")
    public Portfolio getPortfolioFromSonarqube() throws ParseException {
        //Portfolio portfolio = portfolioService.getProjectsByPortfolio(url);
        //portfolioService.savePortfolio(portfolio);
        *//*Portfolio portfolio = new Portfolio("ADC-Distribox");
        Portfolio portfolio1 = new Portfolio("ADC-ViedeContrat");
        Portfolio portfolio2 = new Portfolio("ADC-Mobile");
        portfolioService.savePortfolio(portfolio);
        portfolioService.savePortfolio(portfolio1);
        portfolioService.savePortfolio(portfolio2);*//*
        //return portfolio;
    }*/

    @GetMapping("/api/portfolio/getAllPortfolios")
    public List<Portfolio> getAllPortfolios() throws ParseException {
        //Portfolio portfolio = portfolioService.getProjectsByPortfolio(url);
        //portfolioService.savePortfolio(portfolio);

        return portfolioService.getAllPortfolios();

    }




}

package com.example.sonarqube.service;

import com.example.sonarqube.entities.Portfolio;
import com.example.sonarqube.entities.Project;
import com.example.sonarqube.interfaces.PortfolioRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PortfolioService {
    @Autowired
    private PortfolioRepository portfolioRepository;
    public Portfolio getProjectsByPortfolio(String portfolio) throws ParseException {
        RestTemplate restTemplate = new RestTemplate();
        String resultat = restTemplate.getForObject(portfolio, String.class);

        Portfolio portfolio1 = new Portfolio();
        List<Project> projects =new ArrayList<>();

        // Transformer le resultat en format Json
        JSONParser jsonP = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonP.parse(resultat);
        JSONObject pagingObj = (JSONObject) jsonObject.get("paging");
        String total = String.valueOf(pagingObj.get("total"));
        //
        if (total.equals("0"))
            return null;

        JSONObject baseComponent = (JSONObject) jsonObject.get("baseComponent");
        String name = ((String) baseComponent.get("name"));


        JSONArray components = (JSONArray) jsonObject.get("components");

        portfolio1.setName(name);


        /*components.forEach(project1 -> {
            JSONObject projectObj = (JSONObject) project1;
            String nameP = ((String) projectObj.get("name"));
            String key = ((String) projectObj.get("key"));
            String refKey = ((String) projectObj.get("refKey"));
            String qualifier = ((String) projectObj.get("qualifier"));
            System.out.println("********" + key + "********");
            Project project=new Project(nameP, key, refKey, qualifier);
            projects.add(project);
        });*/
portfolio1.setProjects(projects);
return portfolio1;

    }

    public Portfolio savePortfolio(Portfolio portfolio) throws ParseException {
        return portfolioRepository.save(portfolio);

    }
    public Portfolio findPortfolioByName(String name){
        return portfolioRepository.findPortfolioByName(name);
    }

    public List<Portfolio> getAllPortfolios(){
        return portfolioRepository.findAll();
    }


}

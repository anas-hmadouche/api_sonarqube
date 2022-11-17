package com.example.sonarqube;

import com.example.sonarqube.service.IssueService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SonarController {

    @Autowired
    private IssueService issueService;

    @GetMapping("/sonarqube")
    public String getMessage() throws ParseException {

        String url = "https://sonarqube.inria.fr/sonarqube/api/issues/search?types=BUG&severities=MAJOR&resolved=false&componentKeys=cardamom:mmg:github:develop";
        RestTemplate restTemplate = new RestTemplate();
        String resultat = restTemplate.getForObject(url,String.class);
        return resultat;
    }


   /* @GetMapping("/{types}")
    public ResponseEntity<Object> getByType(@PathVariable(value = "types") String types) throws ResourceNotFoundException {

        Issue issue= personneService.getIssueByType(types);
        return ResponseEntity.ok().body(personne);

    }*/
}

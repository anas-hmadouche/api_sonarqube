package com.example.sonarqube.interfaces;

import com.example.sonarqube.entities.Portfolio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends MongoRepository<Portfolio, String> {
    public Portfolio findPortfolioByName(String name);
}

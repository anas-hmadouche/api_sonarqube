package com.example.sonarqube;

import com.example.sonarqube.export.JobExportExcel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.text.ParseException;
import java.util.Arrays;

@SpringBootApplication
public class SonarqubeApplication {

   public static void main(String[] args) throws SchedulerException, ParseException {

        SpringApplication.run(SonarqubeApplication.class, args);
/*
        SchedulerFactory sf = new StdSchedulerFactory(); // implementation instantiation of StdSchedulerFactory
        Scheduler scheduler = sf.getScheduler();

        //? The newJob() method is a factory to create an instance of type JobBuilder.
        //? All you have to do is invoke the different methods to configure the builder
        //? and invoke its build() method to obtain the corresponding instance.
        //? LDAPQueryJob is the class job that implement job
        JobDetail detail = JobBuilder.newJob(JobExportExcel.class).withIdentity("exportexcel").build();

        //?create an instance of trigger and use the different setters to configure the instance
        CronTriggerImpl trigger = new CronTriggerImpl();
        trigger.setCronExpression("0 * * ? * *");
        trigger.setName("Daily 2 minute trigger");

        //?Save the job schedule with the trigger provided as parameters
        scheduler.scheduleJob(detail, trigger);

        //?Start the scheduler
        scheduler.start();
*/
    }

    @Bean
    public CorsFilter corsFilter(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
                "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
    return new CorsFilter(urlBasedCorsConfigurationSource);
}


}


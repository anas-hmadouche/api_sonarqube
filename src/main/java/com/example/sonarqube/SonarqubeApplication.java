package com.example.sonarqube;

import com.example.sonarqube.export.JobExportExcel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.util.JSON;

import java.text.ParseException;

@SpringBootApplication
public class SonarqubeApplication {

    public static void main(String[] args) throws SchedulerException, ParseException {

        SpringApplication.run(SonarqubeApplication.class, args);

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

    }



}


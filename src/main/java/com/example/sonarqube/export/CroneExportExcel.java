package com.example.sonarqube.export;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;

public class CroneExportExcel {

    public static void main(String[] args) throws Exception {
        //*-----------------scheduling-----------------------------------

        //? we use for this application Quartz Scheduler
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




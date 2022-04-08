package com.cakecrypto.batch.configuration;

import com.cakecrypto.batch.constants.JobConstants;
import com.cakecrypto.batch.job.CurrencyJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

@Configuration
public class JobConfig {

    @Bean(name = JobConstants.CURRENCY_JOB)
    public JobDetail jobDetail() {
        return JobBuilder.newJob().ofType(CurrencyJob.class)
                .storeDurably()
                .withIdentity(JobConstants.CURRENCY_JOB)
                .withDescription("Invoke currency Job service...")
                .build();
    }

    @Bean
    public Trigger trigger(@Qualifier(JobConstants.CURRENCY_JOB) JobDetail job) {
        return TriggerBuilder.newTrigger().forJob(job)
                .withSchedule(simpleSchedule().repeatForever().withIntervalInMinutes(1))
                .build();
    }

}

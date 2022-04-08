package com.cakecrypto.batch.job;

import com.cakecrypto.batch.service.CurrencyJobService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CurrencyJob implements Job {

    @Autowired
    private CurrencyJobService currencyJobService;

    public void execute(JobExecutionContext context) throws JobExecutionException {
        currencyJobService.executeCurrencyJob();
    }
}

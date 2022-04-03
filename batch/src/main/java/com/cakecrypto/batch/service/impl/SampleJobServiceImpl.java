package com.cakecrypto.batch.service.impl;

import com.cakecrypto.batch.service.SampleJobService;
import org.springframework.stereotype.Service;

@Service
public class SampleJobServiceImpl implements SampleJobService {


    @Override
    public void executeSampleJob() {
        System.out.println("hello schedule");
    }
}

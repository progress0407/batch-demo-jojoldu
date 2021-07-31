package com.example.demo.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class Lecture5ScoeTestConfiguration {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job scopeJobTest() {
        return jobBuilderFactory.get("scopeJobTest")
                .start(simpleStepScopeTest1(null))
                .build();
    }

    @Autowired
    private Lec5ScopeTestTasklet1 lec5ScopeTestTasklet1;

    @Bean
    @JobScope
    public Step simpleStepScopeTest1(@Value("#{JobParameters[requestDate]}") String requestDate) {
        return stepBuilderFactory.get("simpleStep1")
                .tasklet(lec5ScopeTestTasklet1)
                .build();
    }
}
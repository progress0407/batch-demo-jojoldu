package com.example.demo.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class SImpleJobConfiguration {
  private final JobBuilderFactory jobBuilderFactory;
  private final StepBuilderFactory stepBuilderFactory;

  @Bean
  public Job simpleJob() {
    return jobBuilderFactory.get("simpleJob")
        .start(simpleStep1(null))
        .build();
  }

  @Bean
  @JobScope
  public Step simpleStep1(@Value("#{JobParameters[requestDate]}") String requestDate) {
     return stepBuilderFactory.get("simpleStep1")
         .tasklet(((contribution, chunkContext) -> {
           log.info(">>>>> this Step 1");
           log.info("requestDate = {}", requestDate);
           return RepeatStatus.FINISHED;
         }))
         .build();
  }
}

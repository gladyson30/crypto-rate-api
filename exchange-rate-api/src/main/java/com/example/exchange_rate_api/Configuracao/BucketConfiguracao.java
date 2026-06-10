package com.example.exchange_rate_api.Configuracao;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.BucketConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class BucketConfiguracao {

    @Bean
    public BucketConfiguration bucketConfiguration() {
        return BucketConfiguration.builder()
                .addLimit(
                        Bandwidth.builder()
                                .capacity(10)
                                .refillGreedy(10, Duration.ofMinutes(1))
                                .build()
                )
                .build();
    }
}

package com.example.exchange_rate_api.Configuracao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class CriptoConfiguracao {

    @Value("${spring.coingecko.base-url}")
    private String baseUrl;

    @Value("${spring.coingecko.api-key}")
    private String apiKey;

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("x-cg-demo-api-key", apiKey)
                .build();
    }

}

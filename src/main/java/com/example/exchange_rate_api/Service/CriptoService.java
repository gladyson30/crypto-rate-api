package com.example.exchange_rate_api.Service;

import com.example.exchange_rate_api.Model.Cripto;
import com.example.exchange_rate_api.execoes.MoedaNaoExiste;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class CriptoService {

    private final WebClient client;


    @Cacheable(value = "cripto", key = "#moeda")
    public Cripto buscarCotacao(String moeda){

        Map<String, Cripto> resposta = client.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/simple/price")
                        .queryParam("ids", moeda)
                        .queryParam("vs_currencies", "brl,usd")
                        .build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Cripto>>() {})
                .block();
        if (resposta == null || resposta.get(moeda) == null){
            throw new MoedaNaoExiste("Essa cripto não existe");
        }

        return resposta.get(moeda);
    }
}

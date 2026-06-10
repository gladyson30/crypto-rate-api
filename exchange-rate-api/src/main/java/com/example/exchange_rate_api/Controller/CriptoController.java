package com.example.exchange_rate_api.Controller;

import com.example.exchange_rate_api.Model.Cripto;
import com.example.exchange_rate_api.Service.CriptoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cripto")
public class CriptoController {

    @Autowired
    private CriptoService service;

    @Operation(
            summary = "Buscar cotação de criptomoeda",
            description = "Retorna o preço atual em BRL e USD. Dados cacheados por 5 minutos."
    )
    @ApiResponse(responseCode = "200", description = "Cotação retornada com sucesso")
    @ApiResponse(responseCode = "429", description = "Limite de requisições excedido")

    @GetMapping("/{moeda}")
    public ResponseEntity<Cripto> buscarCotacao(@PathVariable String moeda){
        Cripto cripto= service.buscarCotacao(moeda);
        return ResponseEntity.status(200).body(cripto);
    }
}

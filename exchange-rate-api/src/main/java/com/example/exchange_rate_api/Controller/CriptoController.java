package com.example.exchange_rate_api.Controller;

import com.example.exchange_rate_api.Model.Cripto;
import com.example.exchange_rate_api.Service.CriptoService;
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

    @GetMapping("/{moeda}")
    public ResponseEntity<Cripto> buscarCotacao(@PathVariable String moeda){
        Cripto cripto= service.buscarCotacao(moeda);
        return ResponseEntity.status(200).body(cripto);
    }
}

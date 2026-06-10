package com.example.exchange_rate_api.Controller;

import com.example.exchange_rate_api.execoes.MoedaNaoExiste;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CriptoControllerAdvice {

    @ExceptionHandler(MoedaNaoExiste.class)
    public ResponseEntity<String> moedaNaoExiste(MoedaNaoExiste moedaNaoExiste){
        return ResponseEntity.status(404).body("Essa cripto não existe");
    }
}

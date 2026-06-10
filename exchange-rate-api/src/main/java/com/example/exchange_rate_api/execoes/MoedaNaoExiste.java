package com.example.exchange_rate_api.execoes;

public class MoedaNaoExiste extends RuntimeException {
    public MoedaNaoExiste(String message) {
        super(message);
    }
}

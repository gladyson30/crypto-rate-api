package com.example.exchange_rate_api.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cripto {

    @JsonProperty("brl")
    private double valorBr;

    @JsonProperty("usd")
    private double valorUs;

}

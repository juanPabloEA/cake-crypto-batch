package com.cakecrypto.batch.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class QuoteEntity {
    @JsonProperty("USD")
    public CurrencyEntity uSD;
}

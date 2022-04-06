package com.cakecrypto.batch.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Setter
@Getter
public class CryptoCurrencyDTO {
    public int id;
    public String name;
    public Date last_updated;
    public double price;
}

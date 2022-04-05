package com.cakecrypto.batch.entity;

import lombok.Getter;
import java.util.Date;

@Getter
public class CurrencyEntity {
    public double price;
    public int volume_24h;
    public double volume_change_24h;
    public double percent_change_1h;
    public double percent_change_24h;
    public double percent_change_7d;
    public double market_cap;
    public int market_cap_dominance;
    public double fully_diluted_market_cap;
    public Date last_updated;
}

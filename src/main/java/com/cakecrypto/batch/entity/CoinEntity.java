package com.cakecrypto.batch.entity;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;

@Getter
public class CoinEntity {
    public int id;
    public String name;
    public String symbol;
    public String slug;
    public int cmc_rank;
    public int num_market_pairs;
    public int circulating_supply;
    public int self_reported_circulating_supply;
    public int self_reported_market_cap;
    public int total_supply;
    public int max_supply;
    public Date last_updated;
    public Date date_added;
    public ArrayList<String> tags;
    public Object platform;
    public QuoteEntity quote;
}

package com.cakecrypto.batch.entity;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class CoinMarketCapEntity {
    public StatusEntity status;
    public ArrayList<CoinEntity> data;
}

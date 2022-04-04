package com.cakecrypto.batch.service.impl;

import com.cakecrypto.batch.service.CoinMarketCap;
import com.cakecrypto.batch.service.CurrencyJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyJobServiceImpl implements CurrencyJobService {

    @Autowired
    CoinMarketCap coinMarketCap;

    @Override
    public void executeCurrencyJob() {
        coinMarketCap.getLatestCryptoCurrency();
    }
}

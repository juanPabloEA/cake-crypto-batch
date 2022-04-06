package com.cakecrypto.batch.service;

import com.cakecrypto.batch.entity.CoinMarketCapEntity;

public interface CoinMarketCapService {

    CoinMarketCapEntity getLatestCryptoCurrency();
}

package com.cakecrypto.batch.repository;

import com.cakecrypto.batch.entity.CryptoCurrency;

import java.util.List;

public interface CryptoCurrencyRepo {
    void saveAll(List<CryptoCurrency> cryptoCurrencyList);
}

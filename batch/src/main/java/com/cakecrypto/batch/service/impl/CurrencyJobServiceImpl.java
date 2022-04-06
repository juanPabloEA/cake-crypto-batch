package com.cakecrypto.batch.service.impl;

import com.cakecrypto.batch.dto.CryptoCurrencyDTO;
import com.cakecrypto.batch.entity.CoinMarketCapEntity;
import com.cakecrypto.batch.mapper.CryptoCurrencyDTOMapper;
import com.cakecrypto.batch.service.CoinMarketCapService;
import com.cakecrypto.batch.service.CurrencyJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyJobServiceImpl implements CurrencyJobService {

    @Autowired
    CoinMarketCapService coinMarketCap;

    @Override
    public void executeCurrencyJob() {
        CoinMarketCapEntity coinMarketCapEntity = coinMarketCap.getLatestCryptoCurrency();
        List<CryptoCurrencyDTO> cryptoCurrencyDTO = CryptoCurrencyDTOMapper.mapCoinMarketCapEntityToCryptoCurrencyDTO(coinMarketCapEntity);
    }
}

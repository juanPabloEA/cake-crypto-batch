package com.cakecrypto.batch.mapper;

import com.cakecrypto.batch.entity.CryptoCurrency;
import com.cakecrypto.batch.entity.CoinEntity;
import com.cakecrypto.batch.entity.CoinMarketCapEntity;

import java.util.ArrayList;
import java.util.List;

public class CryptoCurrencyDTOMapper {

    public static List<CryptoCurrency> mapCoinMarketCapEntityToCryptoCurrencyDTO(CoinMarketCapEntity coinMarketCapEntity) {
        List<CryptoCurrency> listReturn = new ArrayList<>();
        for(CoinEntity coinEntity : coinMarketCapEntity.getData()) {
            var cryptoCurrencyDTO = CryptoCurrency.builder()
                    .id(coinEntity.getId())
                    .name(coinEntity.getName())
                    .price(coinEntity.getQuote().getUSD().getPrice())
                    .last_updated(coinEntity.getLast_updated())
                    .build();
            listReturn.add(cryptoCurrencyDTO);
        }
        return listReturn;
    }
}

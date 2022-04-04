package com.cakecrypto.batch.constants;

import com.cakecrypto.batch.service.CoinMarketCap;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix = "coinmarketcap.api")
@Getter
@Setter
public class CoinMarketCapProperties {
    private String key;
    private CoinMarketCapApiUrl url;
}

package com.cakecrypto.batch.constants;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "coinmarketcap.api")
@Getter
@Setter
public class CoinMarketCapProperties {
    private String key;
    private CoinMarketCapApiUrl url;
}

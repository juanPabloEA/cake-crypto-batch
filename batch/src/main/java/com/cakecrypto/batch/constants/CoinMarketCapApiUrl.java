package com.cakecrypto.batch.constants;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

@Configuration
@Setter
@Getter
public class CoinMarketCapApiUrl {
    private String latest;
}

package com.cakecrypto.batch.service.impl;

import com.cakecrypto.batch.constants.CoinMarketCapProperties;
import com.cakecrypto.batch.entity.CoinMarketCapEntity;
import com.cakecrypto.batch.service.CoinMarketCap;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CoinMarketCapImpl implements CoinMarketCap {

    @Autowired
    CoinMarketCapProperties coinMarketCapProperties;

    @Override
    public CoinMarketCapEntity getLatestCryptoCurrency() {
        String uri = coinMarketCapProperties.getUrl().getLatest();
        List<NameValuePair> parameters = new ArrayList<>();
        parameters.add(new BasicNameValuePair("start","1"));
        parameters.add(new BasicNameValuePair("limit","30"));

        try {
            String result = makeAPICall(uri, parameters);
            ObjectMapper om = new ObjectMapper();
            return om.readValue(result, CoinMarketCapEntity.class);
        } catch (IOException e) {
            System.out.println("Error: cannot access content - " + e);
        } catch (URISyntaxException e) {
            System.out.println("Error: Invalid URL " + e);
        }
        return null;
    }

    private String makeAPICall(String uri, List<NameValuePair> parameters)
            throws URISyntaxException, IOException {
        URIBuilder query = new URIBuilder(uri);
        query.addParameters(parameters);

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(query.build());
        request.setHeader(HttpHeaders.ACCEPT, "application/json");
        request.addHeader("X-CMC_PRO_API_KEY", coinMarketCapProperties.getKey());

        try (CloseableHttpResponse response = client.execute(request)) {
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            EntityUtils.consume(entity);
            return EntityUtils.toString(entity);
        }
    }
}

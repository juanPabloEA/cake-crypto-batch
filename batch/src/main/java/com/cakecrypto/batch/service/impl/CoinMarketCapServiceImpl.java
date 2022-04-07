package com.cakecrypto.batch.service.impl;

import com.cakecrypto.batch.constants.CoinMarketCapProperties;
import com.cakecrypto.batch.entity.CoinMarketCapEntity;
import com.cakecrypto.batch.service.CoinMarketCapService;
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
public class CoinMarketCapServiceImpl implements CoinMarketCapService {

    @Autowired
    CoinMarketCapProperties coinMarketCapProperties;

    @Override
    public CoinMarketCapEntity getLatestCryptoCurrency() {
        String uri = coinMarketCapProperties.getUrl().getLatest();
        List<NameValuePair> parameters = new ArrayList<>();
        parameters.add(new BasicNameValuePair("start","1"));
        parameters.add(new BasicNameValuePair("limit","30"));
        parameters.add(new BasicNameValuePair("convert","USD"));

        try {
            String result = makeAPICall(uri, parameters);
            ObjectMapper om = new ObjectMapper();
            System.out.println(result);
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
        String response_content = "";

        URIBuilder query = new URIBuilder(uri);
        query.addParameters(parameters);

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(query.build());
        request.setHeader(HttpHeaders.ACCEPT, "application/json");
        request.addHeader("X-CMC_PRO_API_KEY", coinMarketCapProperties.getKey());

        CloseableHttpResponse response = client.execute(request);

        try {
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            response_content = EntityUtils.toString(entity);
            EntityUtils.consume(entity);
        } finally {
            response.close();
        }

        return response_content;
    }
}

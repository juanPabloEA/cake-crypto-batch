package com.cakecrypto.batch.repository;

import com.cakecrypto.batch.entity.CryptoCurrency;
import com.cakecrypto.batch.firestore.AbstractFirestoreRepository;
import com.google.cloud.firestore.Firestore;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CryptoCurrencyRepoImpl extends AbstractFirestoreRepository<CryptoCurrency> implements CryptoCurrencyRepo {

    protected CryptoCurrencyRepoImpl(Firestore firestore) {
        super(firestore, "crypto");
    }

    @Override
    public void saveAll(List<CryptoCurrency> cryptoCurrencyList) {
        for(CryptoCurrency crypto : cryptoCurrencyList) {
            this.save(crypto);
        }
    }
}

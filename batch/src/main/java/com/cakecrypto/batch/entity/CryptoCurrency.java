package com.cakecrypto.batch.entity;

import com.cakecrypto.batch.firestore.DocumentId;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Setter
@Getter
public class CryptoCurrency {
    @DocumentId
    public int id;
    public String name;
    public Date last_updated;
    public double price;
}

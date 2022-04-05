package com.cakecrypto.batch.entity;

import lombok.Getter;

import java.util.Date;

@Getter
public class StatusEntity {
    public Date timestamp;
    public int error_code;
    public Object error_message;
    public int elapsed;
    public int credit_count;
    public Object notice;
}

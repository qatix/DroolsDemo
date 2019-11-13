package com.qatix.droolsdemo.entity;

import lombok.Data;

@Data
public class AddressCheckResult {

    private Boolean postCodeResult = false; // true:通过校验；false：未通过校验
}
package com.qatix.droolsdemo.service;

import com.qatix.droolsdemo.entity.Message;

public interface SimpleService {
    String fireRule();

    String fireRuleWithMessage(Message message);
}

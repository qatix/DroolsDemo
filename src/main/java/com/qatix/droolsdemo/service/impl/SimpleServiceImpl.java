package com.qatix.droolsdemo.service.impl;

import com.qatix.droolsdemo.entity.Message;
import com.qatix.droolsdemo.service.SimpleService;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("simpleService")
public class SimpleServiceImpl implements SimpleService {

    @Resource
    private KieSession kieSession;

    @Override
    public String fireRule() {

        // go !
        Message message = new Message();
        message.setMessage("Hello World");
        message.setStatus(Message.HELLO);
        kieSession.insert(message);//插入
        kieSession.fireAllRules();//执行规则
//        kieSession.dispose();
        return message.getMessage();
    }

    @Override
    public String fireRuleWithMessage(Message message) {
//        KieServices ks = KieServices.Factory.get();
//        KieContainer kContainer = ks.getKieClasspathContainer();
//        KieSession kieSession = kContainer.newKieSession("ksession-rules");
        kieSession.insert(message);//插入
        kieSession.fireAllRules();//执行规则
//        kieSession.dispose();
        return message.getMessage();
    }
}

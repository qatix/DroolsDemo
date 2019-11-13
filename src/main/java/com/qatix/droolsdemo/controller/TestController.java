package com.qatix.droolsdemo.controller;

import com.qatix.droolsdemo.entity.Address;
import com.qatix.droolsdemo.entity.AddressCheckResult;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@RequestMapping("/test")
@Controller
public class TestController {

    @Resource
    private KieSession kieSession;

    @ResponseBody
    @RequestMapping("/address")
    public String test(@RequestParam(name = "code") String code) {
        Address address = new Address();
        address.setPostcode(code);

        AddressCheckResult result = new AddressCheckResult();
        kieSession.insert(address);
        kieSession.insert(result);
        int ruleFiredCount = kieSession.fireAllRules();
        System.out.println("触发了" + ruleFiredCount + "条规则");

        if (result.getPostCodeResult()) {
            System.out.println("规则校验通过");
            return "规则校验通过";
        }
        return "规则校验不通过";
    }
}
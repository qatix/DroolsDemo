package com.qatix.droolsdemo;

import com.qatix.droolsdemo.entity.DroolsRule;
import com.qatix.droolsdemo.repositoty.RuleRepositoty;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class RuleTest {

    @Resource
    private RuleRepositoty ruleRepositoty;


    @Test
    void testAdd(){
        DroolsRule rule = new DroolsRule();
        rule.setRuleKey("aaaa");
        rule.setRuleContent("test content");
        rule.setCreateTime(LocalDate.now());

        ruleRepositoty.save(rule);
    }

    @Test
    void testList(){
        List<DroolsRule> ruleList = ruleRepositoty.findAll();
        System.out.println("find rule:"+ruleList.size());
        for (DroolsRule r : ruleList){
            System.out.println(r.toString());
        }
    }
}

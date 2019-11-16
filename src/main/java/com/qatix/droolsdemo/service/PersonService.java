package com.qatix.droolsdemo.service;

import com.qatix.droolsdemo.entity.DroolsRule;
import com.qatix.droolsdemo.entity.Person;
import com.qatix.droolsdemo.kie.NewKieBase;
import com.qatix.droolsdemo.repositoty.PersonRepository;
import com.qatix.droolsdemo.repositoty.RuleRepositoty;
import org.apache.commons.lang3.StringUtils;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PersonService {

    @Resource
    private PersonRepository personRepository;

    @Resource
    private RuleRepositoty ruleRepositoty;

    public List<Person> listPerson() {

        DroolsRule rule = ruleRepositoty.findByRuleKey("test_rule_1");

        if (rule == null) {
            throw new RuntimeException("Rule not found");
        } else if (StringUtils.isBlank(rule.getRuleContent())) {
            throw new RuntimeException("Rule is empty");
        }
        System.out.println("get rule:" + rule.toString());


        KieBase kieBase = NewKieBase.rulekieBase(rule.getRuleContent());
        List<Person> list = personRepository.findAll();
        for (Person person : list) {
            KieSession kieSession = kieBase.newKieSession();
            kieSession.insert(person);
            int firedCount = kieSession.fireAllRules();
            System.out.println("fired rule:" + firedCount);
            kieSession.dispose();
        }
        return list;
    }

    public List<Person> listOriginPerson() {
        return personRepository.findAll();
    }
}

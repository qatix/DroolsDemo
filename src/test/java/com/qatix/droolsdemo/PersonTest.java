package com.qatix.droolsdemo;

import com.qatix.droolsdemo.entity.DroolsRule;
import com.qatix.droolsdemo.entity.Person;
import com.qatix.droolsdemo.kie.RuleExecute;
import com.qatix.droolsdemo.repositoty.PersonRepository;
import com.qatix.droolsdemo.repositoty.RuleRepositoty;
import com.qatix.droolsdemo.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PersonTest {

    @Resource
    private PersonRepository personRepository;

    @Resource
    private RuleRepositoty ruleRepositoty;


    @Autowired
    private PersonService personService;

    @Test
    void testAddAndList() {
        Person person = new Person();
        person.setName("tang");
        person.setAge(20);
        personRepository.save(person);

        person = new Person();
        person.setName("zhang");
        person.setAge(22);
        personRepository.save(person);


        System.out.println("list result:");
        List<Person> personList = personRepository.findAll();
        for (Person p : personList) {
            System.out.println(p.toString());
        }
    }

    @Test
    void testRule() {

        DroolsRule rule = new DroolsRule();
        rule.setRuleKey("test_rule_1");
        rule.setRuleContent(RuleExecute.activityRule());
        rule.setCreateTime(LocalDate.now());
        ruleRepositoty.save(rule);
        System.out.println("save rule to db successfully");

        Person person = new Person();
        person.setName("zhang");
        person.setAge(22);
        personRepository.save(person);

        System.out.println("origin person list:");
        System.out.println(personService.listOriginPerson());

        System.out.println("after modified:");
        System.out.println(personService.listPerson());
    }


}

package com.qatix.droolsdemo.kie;

public class RuleExecute {
    public static String activityRule() {
        return "package rules \n " +
                "import   com.qatix.droolsdemo.entity.Person; \n" +
                " rule    \'person_1\' \n" +
                " no-loop true \n" +
                " salience  10 \n" +
                " when \n" +
                "  $p:Person(name==\'zhang\',age==\'22\' )\n " +
                " then \n" +
                "  modify($p){ setName(\'张小三\' )} \n" +
                "end \n";
    }
}
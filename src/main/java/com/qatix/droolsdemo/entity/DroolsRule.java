package com.qatix.droolsdemo.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "drools_rule")
public class DroolsRule {
    @Id
    @GeneratedValue
    private Long ruleId;

    @Column(nullable = false, unique = true, name = "rule_key")
    private String ruleKey;

    @Column(nullable = false, name = "rule_content")
    private String ruleContent;

    @Column(name = "create_time")
    private LocalDate createTime;

    private LocalDate updateTime;
}

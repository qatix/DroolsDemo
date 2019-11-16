package com.qatix.droolsdemo.repositoty;

import com.qatix.droolsdemo.entity.DroolsRule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RuleRepositoty extends JpaRepository<DroolsRule, Long> {

    DroolsRule findByRuleKey(String rukeKey);
}

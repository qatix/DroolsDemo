CREATE TABLE `drools_rule` (
  `rule_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `rule_key` varchar(64) DEFAULT NULL COMMENT '业务主键',
  `rule_content` longtext COMMENT '规则',
  PRIMARY KEY (`rule_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

INSERT INTO `drools_rule` (`rule_id`, `rule_key`, `rule_content`) VALUES ('1', 'repayment', 'package rules\r\n\r\nimport com.utonw.finance.vo.FinanceRepaymentVo\r\nimport java.math.BigDecimal\r\n\r\nrule \"FirstInterest\"\r\n no-loop true\r\n lock-on-active true\r\n salience 1\r\n when\r\n repaymentVo : FinanceRepaymentVo(repaymentPlanVoList != null && repaymentPlanVoList.size() >= periods)\r\n then\r\n repaymentVo.addFee(\"repayInterest\",\"FirstInsterest_TotalInterestFee\");\r\n repaymentVo.addFee(\"repayManage\",\"FirstInsterest_TotalManagerFee\");\r\n repaymentVo.addFee(\"repayTotal\",\"FirstInsterest_TotalAllFee\");\r\n update(repaymentVo);\r\nend');
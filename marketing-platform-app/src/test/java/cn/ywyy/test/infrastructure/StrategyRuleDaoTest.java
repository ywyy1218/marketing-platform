package cn.ywyy.test.infrastructure;

import cn.ywyy.infrastructure.persistent.dao.IStrategyRuleDao;
import cn.ywyy.infrastructure.persistent.po.StrategyRule;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author: wjx
 * @description:
 * @create 2024/7/7 11:08
 */
@SpringBootTest
@Slf4j
public class StrategyRuleDaoTest {

    @Resource
    private IStrategyRuleDao strategyRuleDao;

    @Test
    public void test_queryStrategyRuleValue(){
        StrategyRule strategyRule = new StrategyRule();
        strategyRule.setStrategyId(100003L);
        strategyRule.setRuleModel("rule_blacklist");
        String ruleValue = strategyRuleDao.queryStrategyRuleValue(strategyRule);
        log.info("ruleValue:{}", ruleValue);
    }
}

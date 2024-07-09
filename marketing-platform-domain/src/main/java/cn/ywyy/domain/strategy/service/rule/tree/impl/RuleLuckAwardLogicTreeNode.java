package cn.ywyy.domain.strategy.service.rule.tree.impl;

import cn.ywyy.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import cn.ywyy.domain.strategy.service.rule.tree.ILogicTreeNode;
import cn.ywyy.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author: wjx
 * @description: 兜底奖励节点
 * @create 2024/7/9 13:34
 */
@Component("rule_luck_award")
@Slf4j
public class RuleLuckAwardLogicTreeNode implements ILogicTreeNode {
    @Override
    public DefaultTreeFactory.TreeActionEntity logic(String userId, Long strategyId, Integer awardId) {
        return DefaultTreeFactory.TreeActionEntity.builder()
                .ruleLogicCheckType(RuleLogicCheckTypeVO.TAKE_OVER)
                .strategyAwardData(DefaultTreeFactory.StrategyAwardData.builder()
                        .awardId(101)
                        .awardRuleValue("1,100")
                        .build())
                .build();
    }
}

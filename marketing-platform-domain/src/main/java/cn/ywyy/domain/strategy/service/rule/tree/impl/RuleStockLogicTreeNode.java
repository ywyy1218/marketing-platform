package cn.ywyy.domain.strategy.service.rule.tree.impl;

import cn.ywyy.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import cn.ywyy.domain.strategy.service.rule.tree.ILogicTreeNode;
import cn.ywyy.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author: wjx
 * @description: 库存节点
 * @create 2024/7/9 13:34
 */
@Component("rule_stock")
@Slf4j
public class RuleStockLogicTreeNode implements ILogicTreeNode {
    @Override
    public DefaultTreeFactory.TreeActionEntity logic(String userId, Long strategyId, Integer awardId) {
        return DefaultTreeFactory.TreeActionEntity.builder()
                .ruleLogicCheckType(RuleLogicCheckTypeVO.TAKE_OVER)
                .build();
    }
}

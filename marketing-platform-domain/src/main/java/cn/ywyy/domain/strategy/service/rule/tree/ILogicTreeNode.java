package cn.ywyy.domain.strategy.service.rule.tree;

import cn.ywyy.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;

/**
 * @author: wjx
 * @description: 规则树接口
 * @create 2024/7/9 10:16
 */
public interface ILogicTreeNode {

    DefaultTreeFactory.TreeActionEntity logic(String userId, Long strategyId, Integer awardId, String ruleValue);
}

package cn.ywyy.domain.strategy.service.rule.tree.factory.engine;

import cn.ywyy.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;

/**
 * @author: wjx
 * @description: 规则树组合接口
 * @create 2024/7/9 13:42
 */
public interface IDecisionTreeEngine {

    DefaultTreeFactory.StrategyAwardData process(String userId, Long strategyId, Integer awardId);
}

package cn.ywyy.domain.strategy.service.rule.chain;

import cn.ywyy.domain.strategy.service.rule.chain.factory.DefaultChainFactory;

/**
 * @author: wjx
 * @description: 责任链接口
 * @create 2024/7/8 15:08
 */
public interface ILogicChain extends ILogicChainArmory{

    /**
     * 责任链接口
     * @param userId 用户ID
     * @param strategyId 策略ID
     * @return 奖品ID
     */
    DefaultChainFactory.StrategyAwardVO logic(String userId, Long strategyId);


}

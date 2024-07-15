package cn.ywyy.domain.strategy.service;

import cn.ywyy.domain.strategy.model.entity.StrategyAwardEntity;

import java.util.List;

/**
 * @author: wjx
 * @description: 策略奖品查询接口
 * @create 2024/7/15 13:34
 */
public interface IRaffleAward {

    /**
     * 根据策略ID查询抽奖奖品列表的配置
     * @param strategyId 策略ID
     * @return 奖品列表
     */
    List<StrategyAwardEntity> queryRaffleStrategyAwardList(Long strategyId);
}

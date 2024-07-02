package cn.ywyy.domain.strategy.repository;

import cn.ywyy.domain.strategy.model.entity.StrategyAwardEntity;

import java.util.List;
import java.util.Map;

/**
 * @author: wjx
 * @description: 策略仓储服务接口
 * @create 2024/7/2 13:10
 */

public interface IStrategyRepository {

    List<StrategyAwardEntity> queryStrategyAwardList(Long strategyId);

    void storeStrategyAwardSearchRateTable(Long strategyId, Integer rateRange, Map<Integer, Integer> strategyAwardSearchRateTable);

    Integer getStrategyAwardAssemble(Long strategyId, Integer rateKey);

    int getRateRange(Long strategyId);

}


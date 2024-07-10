package cn.ywyy.domain.strategy.repository;

import cn.ywyy.domain.strategy.model.entity.StrategyAwardEntity;
import cn.ywyy.domain.strategy.model.entity.StrategyEntity;
import cn.ywyy.domain.strategy.model.entity.StrategyRuleEntity;
import cn.ywyy.domain.strategy.model.valobj.RuleTreeVO;
import cn.ywyy.domain.strategy.model.valobj.StrategyAwardRuleModelVO;

import java.util.List;
import java.util.Map;

/**
 * @author: wjx
 * @description: 策略仓储服务接口
 * @create 2024/7/2 13:10
 */

public interface IStrategyRepository {

    List<StrategyAwardEntity> queryStrategyAwardList(Long strategyId);

    void storeStrategyAwardSearchRateTable(String key, Integer rateRange, Map<Integer, Integer> strategyAwardSearchRateTable);

    Integer getStrategyAwardAssemble(String key, Integer rateKey);

    int getRateRange(Long strategyId);

    int getRateRange(String key);

    StrategyEntity queryStrategyEntityByStrategyId(Long strategyId);

    StrategyRuleEntity queryStrategyRule(Long strategyId, String ruleModel);

    String queryStrategyRuleValue(Long strategyId, Integer awardId, String ruleModel);

    String queryStrategyRuleValue(Long strategyId, String ruleModel);

    StrategyAwardRuleModelVO queryStrategyAwardRuleModel(Long strategyId, Integer awardId);

    RuleTreeVO queryRuleTreeVOByTreeId(String treeId);
}


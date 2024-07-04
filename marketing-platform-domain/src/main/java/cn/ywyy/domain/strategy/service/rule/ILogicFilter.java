package cn.ywyy.domain.strategy.service.rule;

import cn.ywyy.domain.strategy.model.entity.RuleActionEntity;
import cn.ywyy.domain.strategy.model.entity.RuleMatterEntity;

/**
 * @author: wjx
 * @description: 抽奖规则过滤
 * @create 2024/7/4 10:25
 */
public interface ILogicFilter<T extends RuleActionEntity.RaffleEntity> {

    RuleActionEntity<T> filter(RuleMatterEntity ruleMatterEntity);
}

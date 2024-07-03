package cn.ywyy.domain.strategy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: wjx
 * @description: 策略实体
 * @create 2024/7/3 14:28
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StrategyEntity {
    /** 抽奖策略ID */
    private Long strategyId;
    /** 抽奖策略描述 */
    private String strategyDesc;
    /** 规则模型，rule配置的模型同步到此表，便于使用 */
    private String ruleModels;
}

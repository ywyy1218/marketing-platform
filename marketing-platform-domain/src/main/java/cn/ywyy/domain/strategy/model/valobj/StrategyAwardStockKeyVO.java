package cn.ywyy.domain.strategy.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author: wjx
 * @description: 策略奖品库存Key标识值对象
 * @create 2024/7/11 13:07
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StrategyAwardStockKeyVO {
    // 策略ID
    private Long strategyId;
    // 奖品ID
    private Integer awardId;
}

package cn.ywyy.domain.strategy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: wjx
 * @description: 抽奖因子实体
 * @create 2024/7/4 10:00
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RaffleFactorEntity {

    /** 用户ID */
    private String userId;
    /** 抽奖策略ID */
    private Long strategyId;
    /** 奖品ID */
    private Integer awardId;
}

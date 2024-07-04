package cn.ywyy.domain.strategy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: wjx
 * @description: 抽奖奖品实体
 * @create 2024/7/4 10:06
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RaffleAwardEntity {

    /** 抽奖策略ID */
    private Long strategyId;
    /** 抽奖奖品ID - 内部流转使用 */
    private Integer awardId;
    /** 奖品对接标识 - 每一个都是一个对应的发奖策略 */
    private String awardKey;
    /** 奖品配置信息 */
    private String awardConfig;
    /** 奖品内容描述 */
    private String awardDesc;
}

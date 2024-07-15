package cn.ywyy.trigger.api.dto;

import lombok.Data;

/**
 * @author: wjx
 * @description: 抽奖奖品列表，请求对象
 * @create 2024/7/14 15:19
 */
@Data
public class RaffleAwardListRequestDTO {

    // 抽奖策略ID
    private Long strategyId;
}

package cn.ywyy.domain.strategy.service;

import cn.ywyy.domain.strategy.model.entity.RaffleAwardEntity;
import cn.ywyy.domain.strategy.model.entity.RaffleFactorEntity;

/**
 * @author: wjx
 * @description: 抽奖策略接口
 * @create 2024/7/4 9:56
 */
public interface IRaffleStrategy {

    RaffleAwardEntity performRaffle(RaffleFactorEntity raffleFactorEntity);
}

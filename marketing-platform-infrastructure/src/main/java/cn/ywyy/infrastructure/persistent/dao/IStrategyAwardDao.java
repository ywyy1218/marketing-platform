package cn.ywyy.infrastructure.persistent.dao;

import cn.ywyy.infrastructure.persistent.po.StrategyAward;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: wjx
 * @description: 抽奖策略奖品明细配置 - 概率、规则
 * @create 2024/7/1 11:39
 */
@Mapper
public interface IStrategyAwardDao {
    List<StrategyAward> queryStrategyAwardList();

    List<StrategyAward> queryStrategyAwardListByStrategyId(Long strategyId);
}

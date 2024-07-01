package cn.ywyy.infrastructure.persistent.dao;

import cn.ywyy.infrastructure.persistent.po.Strategy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: wjx
 * @description: 抽奖策略
 * @create 2024/7/1 11:37
 */
@Mapper
public interface IStrategyDao {
    List<Strategy> queryStrategyList();
}

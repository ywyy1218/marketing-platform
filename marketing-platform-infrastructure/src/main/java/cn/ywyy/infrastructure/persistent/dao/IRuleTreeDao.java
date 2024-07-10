package cn.ywyy.infrastructure.persistent.dao;

import cn.ywyy.infrastructure.persistent.po.RuleTree;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: wjx
 * @description: 规则树表DAO操作
 * @create 2024/7/10 9:47
 */
@Mapper
public interface IRuleTreeDao {

    RuleTree queryRuleTreeByTreeId(String treeId);
}

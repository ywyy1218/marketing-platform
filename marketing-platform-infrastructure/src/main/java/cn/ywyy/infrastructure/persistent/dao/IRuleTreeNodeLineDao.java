package cn.ywyy.infrastructure.persistent.dao;

import cn.ywyy.infrastructure.persistent.po.RuleTreeNodeLine;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: wjx
 * @description: 规则树节点连线表DAO
 * @create 2024/7/10 9:47
 */
@Mapper
public interface IRuleTreeNodeLineDao {

    List<RuleTreeNodeLine> queryRuleTreeNodeLineListByTreeId(String treeId);
}

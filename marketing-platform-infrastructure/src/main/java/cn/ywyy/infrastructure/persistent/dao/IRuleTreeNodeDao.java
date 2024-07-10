package cn.ywyy.infrastructure.persistent.dao;

import cn.ywyy.infrastructure.persistent.po.RuleTreeNode;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: wjx
 * @description: 规则树节点表DAO
 * @create 2024/7/10 9:47
 */
@Mapper
public interface IRuleTreeNodeDao {

    List<RuleTreeNode> queryRuleTreeNodeListByTreeId(String treeId);


}

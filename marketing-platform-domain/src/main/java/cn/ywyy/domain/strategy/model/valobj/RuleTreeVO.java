package cn.ywyy.domain.strategy.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author: wjx
 * @description: 规则树对象 树根信息 【不具有唯一ID，不需要改变数据库的结果对象，可以被定义为值对象】
 * @create 2024/7/9 9:53
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RuleTreeVO {

    /** 规则树ID */
    private String treeId;
    /** 规则树名称 */
    private String treeName;
    /** 规则树描述 */
    private String treeDesc;
    /** 规则根节点 */
    private String treeRootRuleNode;

    /** 规则节点 */
    private Map<String, RuleTreeNodeVO> treeNodeMap;

}

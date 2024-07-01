package cn.ywyy.infrastructure.persistent.po;

import lombok.Data;

import java.util.Date;

/**
 * @author: wjx
 * @description: 抽奖策略
 * @create 2024/7/1 10:42
 */

/**
 * alt+shift：多行选中
 * alt：多行输入
 *
 * @Data: 都有get、set方法了
 */

@Data
public class Strategy {

    /** 自增ID */
    private Long id;
    /** 抽奖策略ID */
    private Long strategyId;
    /** 抽奖策略描述 */
    private String strategyDesc;
    /** 规则模型，rule配置的模型同步到此表，便于使用 */
    private String ruleModels;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;
}

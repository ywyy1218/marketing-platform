package cn.ywyy.domain.strategy.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author: wjx
 * @description: 抽奖策略规则规则值对象： 值对象，没有唯一ID， 仅限从数据库查询对象
 * @create 2024/7/6 11:57
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StrategyAwardRuleModelVO {

    private String ruleModels;

}

package cn.ywyy.domain.strategy.service.rule.factory;

import cn.ywyy.domain.strategy.model.entity.RuleActionEntity;
import cn.ywyy.domain.strategy.service.annotation.LogicStrategy;
import cn.ywyy.domain.strategy.service.rule.ILogicFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: wjx
 * @description: 默认的规则工厂
 * @create 2024/7/4 11:09
 */

/**
 * 该类 DefaultLogicFactory 主要用于初始化并管理一组实现了 ILogicFilter 接口的规则过滤器。
 * 这些过滤器通过 LogicStrategy 注解来标识，并被存储在一个 ConcurrentHashMap 中，以便根据特定的逻辑模式代码快速检索。
 */
@Service
public class DefaultLogicFactory {

    public Map<String, ILogicFilter<?>> logicFilterMap = new ConcurrentHashMap<>();

    /**
     * 这段代码的作用是根据每个逻辑过滤器类上的 LogicStrategy 注解，将抽奖规则类型(rule_model)与其对应的逻辑过滤器关联起来，存储在 logicFilterMap 中。
     * 这样可以通过 LogicModel 快速查找到对应的逻辑过滤器实体类。
     * @param logicFilters
     */
    public DefaultLogicFactory(List<ILogicFilter<?>> logicFilters) {
        logicFilters.forEach(logic -> {
            LogicStrategy strategy = AnnotationUtils.findAnnotation(logic.getClass(), LogicStrategy.class);
            if (null != strategy) {
                logicFilterMap.put(strategy.logicMode().getCode(), logic);
            }
        });
    }

    public <T extends RuleActionEntity.RaffleEntity> Map<String, ILogicFilter<T>> openLogicFilter() {
        return (Map<String, ILogicFilter<T>>) (Map<?, ?>) logicFilterMap;
    }

    @Getter
    @AllArgsConstructor
    public enum LogicModel {

        RULE_WIGHT("rule_weight","【抽奖前规则】根据抽奖权重返回可抽奖范围KEY", "before"),
        RULE_BLACKLIST("rule_blacklist","【抽奖前规则】黑名单规则过滤，命中黑名单则直接返回", "before"),
        RULE_LOCK("rule_lock", "【抽奖中规则】抽奖n次后，对应奖品可解锁抽奖", "center"),
        RULE_LUCK_AWARD("rule_luck_award", "【抽奖后规则】幸运奖兜底", "after");

        private final String code;
        private final String info;
        private final String type;

        public static boolean isCenter(String code){
            return "center".equals(LogicModel.valueOf(code.toUpperCase()).type);
        }

        public static boolean isAfter(String code){
            return "after".equals(LogicModel.valueOf(code.toUpperCase()).type);
        }
    }

}


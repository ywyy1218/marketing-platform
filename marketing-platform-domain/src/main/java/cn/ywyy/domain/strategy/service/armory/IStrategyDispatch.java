package cn.ywyy.domain.strategy.service.armory;

/**
 * @author: wjx
 * @description: 抽奖的策略调度
 * @create 2024/7/3 10:03
 */
public interface IStrategyDispatch {
    /**
     * 获取抽奖策略装配的随机结果
     * @param strategyId 策略ID
     * @return 抽奖结果
     */
    Integer getRandomAwardId(Long strategyId);


    Integer getRandomAwardId(Long strategyId, String ruleWeightValue);


}

package cn.ywyy.test.domain;

import cn.ywyy.domain.strategy.service.armory.IStrategyArmory;
import cn.ywyy.domain.strategy.service.armory.IStrategyDispatch;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author: wjx
 * @description: 测试 策略装配库（兵工厂）、负责初始化策略计算 的功能
 * @create 2024/7/2 15:13
 */
@SpringBootTest
@Slf4j
public class StrategyArmoryDispatchTest {

    @Resource
    private IStrategyArmory strategyArmory;
    @Resource
    private IStrategyDispatch strategyDispatch;

    /**
     * 策略ID： 100001L、100002L , 装配的时候创建策略表写入到redis
     */
    @BeforeEach
    public void test_strategyArmory() {
        boolean success = strategyArmory.assembleLotteryStrategy(100001L);
        log.info("测试结果：{}", success);
    }

    /**
     * 从装配的策略中随机获取奖ID值
     */
    @Test
    public void test_getRandomAwardId() {
        log.info("测试结果：{} - 奖品ID值", strategyDispatch.getRandomAwardId(100001L));
        log.info("测试结果：{} - 奖品ID值", strategyDispatch.getRandomAwardId(100001L));
        log.info("测试结果：{} - 奖品ID值", strategyDispatch.getRandomAwardId(100001L));
    }


    /**
     * 根据策略ID+权重值，从装配的策略中随机获取奖品ID值
     */
    @Test
    public void test_getRandomAwardId_ruleWeightValue() {
        log.info("测试结果：{} - 4000 奖品ID值", strategyDispatch.getRandomAwardId(100001L,
                "4000:102,103,104,105"));
        log.info("测试结果：{} - 5000 奖品ID值", strategyDispatch.getRandomAwardId(100001L,
                "5000:102,103,104,105,106,107"));
        log.info("测试结果：{} - 6000 奖品ID值", strategyDispatch.getRandomAwardId(100001L,
                "6000:102,103,104,105,106,107,108,109"));
    }

}

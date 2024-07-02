package cn.ywyy.test.domain;

import cn.ywyy.domain.strategy.service.armory.IStrategyArmory;
import lombok.extern.slf4j.Slf4j;
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
public class StrategyArmoryTest {

    @Resource
    private IStrategyArmory strategyArmory;

    @Test
    public void test_strategyArmory() {
        boolean success = strategyArmory.assembleLotteryStrategy(100002L);
        log.info("测试结果：{}", success);
    }

    @Test
    public void test_getAssembleRandomVal() {
        log.info("测试结果：{} - 奖品ID值", strategyArmory.getRandomAwardId(100002L));
        log.info("测试结果：{} - 奖品ID值", strategyArmory.getRandomAwardId(100002L));
        log.info("测试结果：{} - 奖品ID值", strategyArmory.getRandomAwardId(100002L));
    }

}

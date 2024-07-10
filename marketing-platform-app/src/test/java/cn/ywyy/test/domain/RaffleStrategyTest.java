package cn.ywyy.test.domain;

import cn.ywyy.domain.strategy.model.entity.RaffleAwardEntity;
import cn.ywyy.domain.strategy.model.entity.RaffleFactorEntity;
import cn.ywyy.domain.strategy.service.IRaffleStrategy;
import cn.ywyy.domain.strategy.service.armory.IStrategyArmory;
import cn.ywyy.domain.strategy.service.rule.chain.impl.RuleWeightLogicChain;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import javax.annotation.Resource;

/**
 * @author: wjx
 * @description: 抽奖策略测试
 * @create 2024/7/4 16:53
 */
@Slf4j
@SpringBootTest
public class RaffleStrategyTest {
    @Resource
    private IRaffleStrategy raffleStrategy;

    @Resource
    private IStrategyArmory strategyArmory;

    @Resource
    private RuleWeightLogicChain ruleWeightLogicChain;


    /**
     * ReflectionTestUtils是Spring Framework提供的一个实用工具类，用于在测试时访问和修改非公开字段和方法。
     * 你可以使用ReflectionTestUtils设置类的私有字段。确保ruleWeightLogicFilter已经实例化，并且字段名和类型是正确的。
     */
    @BeforeEach
    public void setUp() {
        // 策略装配 100001、100002、100003
        log.info("测试结果：{}", strategyArmory.assembleLotteryStrategy(100001L));
//        log.info("测试结果：{}", strategyArmory.assembleLotteryStrategy(100002L));
//        log.info("测试结果：{}", strategyArmory.assembleLotteryStrategy(100003L));
        log.info("测试结果：{}", strategyArmory.assembleLotteryStrategy(100006L));

        // 通过反射 mock 规则中的值
        ReflectionTestUtils.setField(ruleWeightLogicChain, "userScore", 4500L);

    }

    @Test
    public void test_performRaffle() {
        RaffleFactorEntity raffleFactorEntity = RaffleFactorEntity.builder()
                .userId("wjx")
                .strategyId(100001L)
                .build();

        RaffleAwardEntity raffleAwardEntity = raffleStrategy.performRaffle(raffleFactorEntity);

        log.info("请求参数：{}", JSON.toJSONString(raffleFactorEntity));
        log.info("测试结果：{}", JSON.toJSONString(raffleAwardEntity));
    }

    @Test
    public void test_performRaffle_blacklist() {
        RaffleFactorEntity raffleFactorEntity = RaffleFactorEntity.builder()
                .userId("user003")  // 黑名单用户 user001,user002,user003
                .strategyId(100003L)
                .build();

        RaffleAwardEntity raffleAwardEntity = raffleStrategy.performRaffle(raffleFactorEntity);

        log.info("请求参数：{}", JSON.toJSONString(raffleFactorEntity));
        log.info("测试结果：{}", JSON.toJSONString(raffleAwardEntity));
    }

    /**
     * 次数错校验，抽奖n次后解锁。100003 策略，你可以通过调整 @Before 的 setUp 方法中个人抽奖次数来验证。比如最开始设置0，之后设置10
     * ReflectionTestUtils.setField(ruleLockLogicFilter, "userRaffleCount", 10L);
     */
    @Test
    public void test_raffle_center_rule_lock(){
        RaffleFactorEntity raffleFactorEntity = RaffleFactorEntity.builder()
                .userId("wjx")
                .strategyId(100003L)
                .build();

        RaffleAwardEntity raffleAwardEntity = raffleStrategy.performRaffle(raffleFactorEntity);

        log.info("请求参数：{}", JSON.toJSONString(raffleFactorEntity));
        log.info("测试结果：{}", JSON.toJSONString(raffleAwardEntity));
    }


}

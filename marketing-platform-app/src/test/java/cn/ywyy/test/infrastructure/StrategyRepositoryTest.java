package cn.ywyy.test.infrastructure;

import cn.ywyy.domain.strategy.model.valobj.RuleTreeVO;
import cn.ywyy.domain.strategy.repository.IStrategyRepository;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author: wjx
 * @description: 仓储数据查询测试
 * @create 2024/7/10 10:12
 */
@SpringBootTest
@Slf4j
public class StrategyRepositoryTest {
    @Resource
    private IStrategyRepository repository;

    @Test
    public void test_queryRuleTreeByTreeId() {
        RuleTreeVO ruleTreeVO = repository.queryRuleTreeVOByTreeId("tree_lock_1");
        log.info("测试结果：{}", JSON.toJSONString(ruleTreeVO));
    }
}

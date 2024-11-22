package cn.ywyy.test.domain.activity;

import cn.ywyy.domain.activity.model.entity.ActivityOrderEntity;
import cn.ywyy.domain.activity.model.entity.ActivityShopCartEntity;
import cn.ywyy.domain.activity.service.IRaffleOrder;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author: wjx
 * @description: 抽奖活动订单单测
 * @create 2024/11/20 22:17
 */
@SpringBootTest
@Slf4j
public class RaffleOrderTest {

    @Resource
    private IRaffleOrder raffleOrder;

    @Test
    public void test_createRaffleActivityOrder() {
        ActivityShopCartEntity activityShopCartEntity = new ActivityShopCartEntity();
        activityShopCartEntity.setUserId("wjx");
        activityShopCartEntity.setSku(9011L);
        ActivityOrderEntity raffleActivityOrder = raffleOrder.createRaffleActivityOrder(activityShopCartEntity);
        log.info("测试结果：{}", JSON.toJSONString(raffleActivityOrder));
    }
}

package cn.ywyy.test.domain.activity;

import cn.ywyy.domain.activity.model.entity.ActivityOrderEntity;
import cn.ywyy.domain.activity.model.entity.ActivityShopCartEntity;
import cn.ywyy.domain.activity.model.entity.SkuRechargeEntity;
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

    @Test
    public void test_createSkuRechargeOrder() {
        SkuRechargeEntity skuRechargeEntity = new SkuRechargeEntity();
        skuRechargeEntity.setUserId("wjx");
        skuRechargeEntity.setSku(9011L);
        // outBusinessNo 作为幂等仿重使用，同一个业务单号2次使用会抛出索引冲突
        // Duplicate entry '700091009111' for key 'uq_out_business_no' 确保唯一性。
        skuRechargeEntity.setOutBusinessNo("700091009112");
        String orderId = raffleOrder.createSkuRechargeOrder(skuRechargeEntity);
        log.info("测试结果：{}", orderId);
    }
}

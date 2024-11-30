package cn.ywyy.domain.activity.service.rule.chain.impl;

import cn.ywyy.domain.activity.model.entity.ActivityCountEntity;
import cn.ywyy.domain.activity.model.entity.ActivityEntity;
import cn.ywyy.domain.activity.model.entity.ActivitySkuEntity;
import cn.ywyy.domain.activity.service.rule.chain.AbstractActionChain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author: wjx
 * @description: 商品库存规则节点
 * @create 2024/11/23 23:55
 */
@Slf4j
@Component("activity_sku_stock_action")
public class ActivitySkuStockActionChain extends AbstractActionChain {

    @Override
    public Boolean action(ActivitySkuEntity activitySkuEntity, ActivityEntity activityEntity, ActivityCountEntity activityCountEntity) {
        log.info("活动责任链-商品库存处理【校验&扣减】开始。");
        return true;
    }
}

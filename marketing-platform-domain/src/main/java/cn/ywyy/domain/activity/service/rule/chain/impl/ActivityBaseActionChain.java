package cn.ywyy.domain.activity.service.rule.chain.impl;

import cn.ywyy.domain.activity.model.entity.ActivityCountEntity;
import cn.ywyy.domain.activity.model.entity.ActivityEntity;
import cn.ywyy.domain.activity.model.entity.ActivitySkuEntity;
import cn.ywyy.domain.activity.service.rule.chain.AbstractActionChain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author: wjx
 * @description: 活动规则过滤【日期、状态】
 * @create 2024/11/23 23:54
 */
@Slf4j
@Component("activity_base_action")
public class ActivityBaseActionChain extends AbstractActionChain {

    @Override
    public Boolean action(ActivitySkuEntity activitySkuEntity, ActivityEntity activityEntity, ActivityCountEntity activityCountEntity) {
        log.info("活动责任链-基础信息【有效期、状态】校验开始。");
        return next().action(activitySkuEntity, activityEntity, activityCountEntity);
    }
}

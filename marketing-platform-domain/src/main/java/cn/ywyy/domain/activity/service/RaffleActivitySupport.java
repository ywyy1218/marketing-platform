package cn.ywyy.domain.activity.service;

import cn.ywyy.domain.activity.model.entity.ActivityCountEntity;
import cn.ywyy.domain.activity.model.entity.ActivityEntity;
import cn.ywyy.domain.activity.model.entity.ActivitySkuEntity;
import cn.ywyy.domain.activity.repository.IActivityRepository;
import cn.ywyy.domain.activity.service.rule.chain.factory.DefaultActivityChainFactory;

import javax.annotation.Resource;

/**
 * @author: wjx
 * @description: 抽奖活动支撑类
 * @create 2024/11/23 23:35
 */
public class RaffleActivitySupport {

    @Resource
    protected IActivityRepository activityRepository;

    @Resource
    protected DefaultActivityChainFactory defaultActivityChainFactory;


    public ActivitySkuEntity queryActivitySku(Long sku) {
        return activityRepository.queryActivitySku(sku);
    }

    public ActivityEntity queryRaffleActivityByActivityId(Long activityId) {
        return activityRepository.queryRaffleActivityByActivityId(activityId);
    }

    public ActivityCountEntity queryRaffleActivityCountByActivityCountId(Long activityCountId) {
        return activityRepository.queryRaffleActivityCountByActivityCountId(activityCountId);
    }
}

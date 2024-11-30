package cn.ywyy.domain.activity.repository;

import cn.ywyy.domain.activity.model.aggregate.CreateOrderAggregate;
import cn.ywyy.domain.activity.model.entity.ActivityCountEntity;
import cn.ywyy.domain.activity.model.entity.ActivityEntity;
import cn.ywyy.domain.activity.model.entity.ActivitySkuEntity;

/**
 * @author: wjx
 * @description: 活动仓储接口
 * @create 2024/11/20 21:50
 */
public interface IActivityRepository {

    /**
     * 查询raffle_activity_sku表信息
     * @param sku
     * @return 活动sku实体对象
     */
    ActivitySkuEntity queryActivitySku(Long sku);

    /**
     * 查询raffle_activity表信息
     * @param activityId 活动id
     * @return 活动实体对象
     */
    ActivityEntity queryRaffleActivityByActivityId(Long activityId);

    /**
     * 查询raffle_activity_count表信息
     * @param activityCountId 活动次数编号
     * @return 活动次数实体对象
     */
    ActivityCountEntity queryRaffleActivityCountByActivityCountId(Long activityCountId);

    /**
     * 保存订单操作
     * @param createOrderAggregate 下单聚合对象
     */
    void doSaveOrder(CreateOrderAggregate createOrderAggregate);
}

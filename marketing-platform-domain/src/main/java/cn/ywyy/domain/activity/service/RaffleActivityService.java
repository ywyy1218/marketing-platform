package cn.ywyy.domain.activity.service;

import cn.ywyy.domain.activity.model.aggregate.CreateOrderAggregate;
import cn.ywyy.domain.activity.model.entity.*;
import cn.ywyy.domain.activity.model.valobj.OrderStateVO;
import cn.ywyy.domain.activity.repository.IActivityRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author: wjx
 * @description: 抽奖活动服务
 * @create 2024/11/20 22:12
 */
@Service
public class RaffleActivityService extends AbstractRaffleActivity{


    public RaffleActivityService(IActivityRepository activityRepository) {
        super(activityRepository);
    }

    @Override
    protected void doSaveOrder(CreateOrderAggregate createOrderAggregate) {
        activityRepository.doSaveOrder(createOrderAggregate);
    }

    @Override
    protected CreateOrderAggregate buildOrderAggregate(SkuRechargeEntity skuRechargeEntity, ActivityEntity activityEntity, ActivitySkuEntity activitySkuEntity, ActivityCountEntity activityCountEntity) {
        // 订单实体对象
        ActivityOrderEntity activityOrderEntity = new ActivityOrderEntity();
        activityOrderEntity.setUserId(skuRechargeEntity.getUserId());
        activityOrderEntity.setSku(skuRechargeEntity.getSku());
        activityOrderEntity.setActivityId(activityEntity.getActivityId());
        activityOrderEntity.setActivityName(activityEntity.getActivityName());
        activityOrderEntity.setStrategyId(activityEntity.getStrategyId());
        // 公司里一般会有专门的雪花算法UUID服务，我们这里直接生成个12位就可以了。
        activityOrderEntity.setOrderId(RandomStringUtils.randomNumeric(12));
        activityOrderEntity.setOrderTime(new Date());
        activityOrderEntity.setTotalCount(activityCountEntity.getTotalCount());
        activityOrderEntity.setDayCount(activityCountEntity.getDayCount());
        activityOrderEntity.setMonthCount(activityCountEntity.getMonthCount());
        activityOrderEntity.setState(OrderStateVO.completed);
        activityOrderEntity.setOutBusinessNo(skuRechargeEntity.getOutBusinessNo());

        return CreateOrderAggregate.builder()
                .userId(skuRechargeEntity.getUserId())
                .activityId(activitySkuEntity.getActivityId())
                .totalCount(activityCountEntity.getTotalCount())
                .dayCount(activityCountEntity.getDayCount())
                .monthCount(activityCountEntity.getMonthCount())
                .activityOrderEntity(activityOrderEntity)
                .build();
    }
}

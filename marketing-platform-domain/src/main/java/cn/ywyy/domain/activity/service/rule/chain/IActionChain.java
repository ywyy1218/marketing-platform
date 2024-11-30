package cn.ywyy.domain.activity.service.rule.chain;

import cn.ywyy.domain.activity.model.entity.ActivityCountEntity;
import cn.ywyy.domain.activity.model.entity.ActivityEntity;
import cn.ywyy.domain.activity.model.entity.ActivitySkuEntity;

/**
 * @author: wjx
 * @description: 责任链接口，下单规则过滤接口
 * @create 2024/11/23 23:46
 */
public interface IActionChain extends IActionChainArmory{
    Boolean action(ActivitySkuEntity activitySkuEntity, ActivityEntity activityEntity, ActivityCountEntity activityCountEntity);
}

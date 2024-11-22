package cn.ywyy.domain.activity.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: wjx
 * @description: 订单状态枚举值对象（用于描述对象属性的值，如枚举，不影响数据库操作的对象，无生命周期）
 * @create 2024/11/20 21:18
 */
@Getter
@AllArgsConstructor
public enum OrderStateVO {
    completed("completed", "完成");

    private final String code;
    private final String desc;

}

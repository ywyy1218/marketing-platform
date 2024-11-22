package cn.ywyy.domain.activity.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: wjx
 * @description: 活动状态值对象
 * @create 2024/11/20 21:15
 */
@Getter
@AllArgsConstructor
public enum ActivityStateVO {
    create("create", "创建"),
    open("open", "开启"),
    close("close", "关闭"),
;
    private final String code;
    private final String desc;

}

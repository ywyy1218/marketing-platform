package cn.ywyy.domain.strategy.service.annotation;

import cn.ywyy.domain.strategy.service.rule.factory.DefaultLogicFactory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: wjx
 * @description: 策略自定义枚举
 * @create 2024/7/4 13:06
 */

/**
 * @Target({ElementType.TYPE}): 指定该注解可以应用于类型（类、接口、枚举等）。
 * @Retention(RetentionPolicy.RUNTIME): 指定该注解在运行时可用（通过反射可以访问）。
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LogicStrategy {
    DefaultLogicFactory.LogicModel logicMode();
}
package cn.ywyy.domain.activity.service.rule.chain;


/**
 * @author: wjx
 * @description: 装配接口
 * @create 2024/11/23 23:58
 */
public interface IActionChainArmory {
    IActionChain appendNext(IActionChain next);

    IActionChain next();
}

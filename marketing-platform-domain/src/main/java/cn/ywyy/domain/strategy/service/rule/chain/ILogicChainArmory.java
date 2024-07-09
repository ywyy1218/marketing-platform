package cn.ywyy.domain.strategy.service.rule.chain;

/**
 * @author: wjx
 * @description: 装配接口
 * @create 2024/7/8 19:30
 */
public interface ILogicChainArmory {
    ILogicChain appendNext(ILogicChain next);

    ILogicChain next();
}

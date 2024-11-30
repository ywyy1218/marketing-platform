package cn.ywyy.domain.activity.service.rule.chain;

/**
 * @author: wjx
 * @description: 下单规则责任链抽象类
 * @create 2024/11/23 23:56
 */
public abstract class AbstractActionChain implements IActionChain{

    private IActionChain next;

    @Override
    public IActionChain appendNext(IActionChain next) {
        this.next = next;
        return next;
    }

    @Override
    public IActionChain next() {
        return next;
    }
}

package cn.ywyy.domain.strategy.service.rule.chain;

/**
 * @author: wjx
 * @description:
 * @create 2024/7/8 15:11
 */
public abstract class AbstractLogicChain implements ILogicChain{
    private ILogicChain next;

    @Override
    public ILogicChain appendNext(ILogicChain next) {
        this.next = next;
        return next;
    }

    @Override
    public ILogicChain next() {
        return next;
    }

    protected abstract String ruleModel();
}

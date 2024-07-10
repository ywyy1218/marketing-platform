package cn.ywyy.domain.strategy.service.raffle;

import cn.ywyy.domain.strategy.model.valobj.RuleTreeVO;
import cn.ywyy.domain.strategy.model.valobj.StrategyAwardRuleModelVO;
import cn.ywyy.domain.strategy.repository.IStrategyRepository;
import cn.ywyy.domain.strategy.service.AbstractRaffleStrategy;
import cn.ywyy.domain.strategy.service.armory.IStrategyDispatch;
import cn.ywyy.domain.strategy.service.rule.chain.ILogicChain;
import cn.ywyy.domain.strategy.service.rule.chain.factory.DefaultChainFactory;
import cn.ywyy.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;
import cn.ywyy.domain.strategy.service.rule.tree.factory.engine.IDecisionTreeEngine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: wjx
 * @description: 默认的抽奖策略实现
 * @create 2024/7/4 16:27
 */
@Slf4j
@Service
public class DefaultRaffleStrategy extends AbstractRaffleStrategy {

    public DefaultRaffleStrategy(IStrategyRepository repository, IStrategyDispatch strategyDispatch, DefaultChainFactory defaultChainFactory, DefaultTreeFactory defaultTreeFactory) {
        super(repository, strategyDispatch, defaultChainFactory, defaultTreeFactory);
    }

    @Override
    public DefaultChainFactory.StrategyAwardVO raffleLogicChain(String userId, Long strategyId) {
        ILogicChain logicChain = defaultChainFactory.openLogicChain(strategyId);
        return logicChain.logic(userId, strategyId);
    }

    @Override
    public DefaultTreeFactory.StrategyAwardVO raffleLogicTree(String userId, Long strategyId, Integer awardId) {
        StrategyAwardRuleModelVO strategyAwardRuleModelVO = repository.queryStrategyAwardRuleModel(strategyId, awardId);
        if (strategyAwardRuleModelVO == null) {
            return DefaultTreeFactory.StrategyAwardVO.builder()
                    .awardId(awardId)
                    .build();
        }
        RuleTreeVO ruleTreeVO = repository.queryRuleTreeVOByTreeId(strategyAwardRuleModelVO.getRuleModels());
        if (ruleTreeVO == null) {
            throw new RuntimeException("存在抽奖策略配置的规则模型 Key，未在库表 rule_tree、rule_tree_node、rule_tree_line 配置对应的规则树信息 " + strategyAwardRuleModelVO.getRuleModels());
        }
        IDecisionTreeEngine treeEngine = defaultTreeFactory.openLogicTree(ruleTreeVO);
        return treeEngine.process(userId, strategyId, awardId);
    }

}

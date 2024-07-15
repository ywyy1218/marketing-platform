package cn.ywyy.trigger.api;

import cn.ywyy.trigger.api.dto.RaffleAwardListRequestDTO;
import cn.ywyy.trigger.api.dto.RaffleAwardListResponseDTO;
import cn.ywyy.trigger.api.dto.RaffleRequestDTO;
import cn.ywyy.trigger.api.dto.RaffleResponseDTO;
import cn.ywyy.types.model.Response;

import java.util.List;

/**
 * @author: wjx
 * @description: 抽奖服务接口
 * @create 2024/7/14 14:56
 */
public interface IRaffleService {

    /**
     * 策略装配接口
     * @param strategyId 策略ID
     * @return 装配结果
     */
    Response<Boolean> strategyArmory(Long strategyId);

    /**
     * 查询抽奖奖品列表配置
     *
     * @param requestDTO 抽奖奖品列表查询请求参数
     * @return 奖品列表数据
     */
    Response<List<RaffleAwardListResponseDTO>> queryRaffleAwardList(RaffleAwardListRequestDTO requestDTO);

    /**
     * 随机抽奖接口
     *
     * @param requestDTO 请求参数
     * @return 抽奖结果
     */
    Response<RaffleResponseDTO> randomRaffle(RaffleRequestDTO requestDTO);

}

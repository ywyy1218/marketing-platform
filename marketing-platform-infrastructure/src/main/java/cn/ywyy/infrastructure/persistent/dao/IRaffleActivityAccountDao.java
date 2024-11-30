package cn.ywyy.infrastructure.persistent.dao;

import cn.ywyy.infrastructure.persistent.po.RaffleActivityAccount;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: wjx
 * @description: 抽奖活动账户表 DAO
 * @create 2024/10/13 23:37
 */
@Mapper
public interface IRaffleActivityAccountDao {
    /**
     * 更新用户账户抽奖配额
     * @param raffleActivityAccount 活动抽奖账户对象
     * @return 受影响的行数
     */
    int updateAccountQuota(RaffleActivityAccount raffleActivityAccount);

    /**
     * 新增抽奖活动庄户
     * @param raffleActivityAccount 活动抽奖账户对象
     */
    void insert(RaffleActivityAccount raffleActivityAccount);

}

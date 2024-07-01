package cn.ywyy.infrastructure.persistent.dao;

import cn.ywyy.infrastructure.persistent.po.Award;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

/**
 * @author: wjx
 * @description: 奖品表DAO
 * @create 2024/7/1 11:36
 */
@Mapper
public interface IAwardDao {

    List<Award> queryAwardList();

}

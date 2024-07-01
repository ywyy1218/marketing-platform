package cn.ywyy.test.infrastructure;

import cn.ywyy.infrastructure.persistent.dao.IAwardDao;
import cn.ywyy.infrastructure.persistent.po.Award;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: wjx
 * @description: 奖品持久化单元测试
 * @create 2024/7/1 14:35
 */
@SpringBootTest
@Slf4j
public class AwardDaoTest {

    @Resource
    private IAwardDao awardDao;

    @Test
    public void test_queryAwardList(){
        List<Award> awards = awardDao.queryAwardList();
        log.info("测试结果：{}", JSON.toJSONString(awards));
    }
}

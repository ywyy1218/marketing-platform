package cn.ywyy.domain.activity.service;

import cn.ywyy.domain.activity.repository.IActivityRepository;
import org.springframework.stereotype.Service;

/**
 * @author: wjx
 * @description:
 * @create 2024/11/20 22:12
 */
@Service
public class RaffleActivityService extends AbstractRaffleActivity{
    public RaffleActivityService(IActivityRepository activityRepository) {
        super(activityRepository);
    }
}

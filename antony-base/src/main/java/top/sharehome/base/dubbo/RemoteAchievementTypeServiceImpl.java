package top.sharehome.base.dubbo;

import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;
import top.sharehome.base.api.RemoteAchievementTypeService;
import top.sharehome.base.domain.Achievement;
import top.sharehome.base.mapper.AchievementMapper;

/**
 * 成果类型服务
 *
 * @author AntonyCheng
 */
@RequiredArgsConstructor
@Service
@DubboService
public class RemoteAchievementTypeServiceImpl implements RemoteAchievementTypeService {

    private final AchievementMapper achievementMapper;

    /**
     * 根据ID获取成果类型服务
     *
     * @param achievementTypeId 成果类型id
     * @return 成果类型
     */
    @Override
    public String queryAchievementTypeNameById(Long achievementTypeId) {
        Achievement achievement = achievementMapper.selectById(achievementTypeId);
        return achievement.getAchievementTypeName();
    }

}

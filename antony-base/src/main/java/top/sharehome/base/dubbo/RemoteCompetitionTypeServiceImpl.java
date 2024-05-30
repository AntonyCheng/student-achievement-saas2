package top.sharehome.base.dubbo;

import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;
import top.sharehome.base.api.RemoteCompetitionTypeService;
import top.sharehome.base.domain.Competition;
import top.sharehome.base.mapper.CompetitionMapper;

/**
 * 竞赛类型服务
 *
 * @author AntonyCheng
 */
@RequiredArgsConstructor
@Service
@DubboService
public class RemoteCompetitionTypeServiceImpl implements RemoteCompetitionTypeService {

    private final CompetitionMapper competitionMapper;

    /**
     * 根据ID获取竞赛类型服务
     *
     * @param competitionTypeId 竞赛类型id
     * @return 竞赛类型
     */
    @Override
    public String queryCompetitionTypeNameById(Long competitionTypeId) {
        Competition competition = competitionMapper.selectById(competitionTypeId);
        return competition.getCompetitionTypeName();
    }

}

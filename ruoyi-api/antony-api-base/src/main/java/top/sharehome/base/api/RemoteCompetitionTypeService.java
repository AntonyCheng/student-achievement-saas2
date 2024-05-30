package top.sharehome.base.api;


/**
 * 竞赛类型服务
 *
 * @author AntonyCheng
 */
public interface RemoteCompetitionTypeService {

    /**
     * 根据ID获取竞赛类型服务
     *
     * @param achievementTypeId 竞赛类型id
     * @return 竞赛类型
     */
    String queryCompetitionTypeNameById(Long achievementTypeId);

}

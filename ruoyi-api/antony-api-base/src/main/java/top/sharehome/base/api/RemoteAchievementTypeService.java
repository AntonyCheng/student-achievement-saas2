package top.sharehome.base.api;


/**
 * 成果类型服务
 *
 * @author AntonyCheng
 */
public interface RemoteAchievementTypeService {

    /**
     * 根据ID获取成果类型服务
     *
     * @param achievementTypeId 成果类型id
     * @return 客户端对象
     */
    String queryAchievementTypeNameById(Long achievementTypeId);

}

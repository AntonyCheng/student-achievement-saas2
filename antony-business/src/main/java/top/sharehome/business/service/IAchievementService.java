package top.sharehome.business.service;

import top.sharehome.business.domain.vo.AchievementVo;
import top.sharehome.business.domain.bo.AchievementBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 在校成果管理Service接口
 *
 * @author AntonyCheng
 * @date 2024-05-27
 */
public interface IAchievementService {

    /**
     * 查询在校成果管理
     */
    AchievementVo queryById(Long achievementId);

    /**
     * 查询在校成果管理列表
     */
    TableDataInfo<AchievementVo> queryMyPageList(AchievementBo bo, PageQuery pageQuery);

    TableDataInfo<AchievementVo> queryStuPageList(AchievementBo bo, PageQuery pageQuery);

    TableDataInfo<AchievementVo> queryPageList(AchievementBo bo, PageQuery pageQuery);

    /**
     * 查询在校成果管理列表
     */
    List<AchievementVo> queryMyList(AchievementBo bo);

    List<AchievementVo> queryStuList(AchievementBo bo);

    List<AchievementVo> queryList(AchievementBo bo);

    /**
     * 新增在校成果管理
     */
    Boolean insertByBo(AchievementBo bo);

    /**
     * 修改在校成果管理
     */
    Boolean updateMyByBo(AchievementBo bo);

    Boolean updateStuByBo(AchievementBo bo);

    /**
     * 校验并批量删除在校成果管理信息
     */
    Boolean deleteMyWithValidByIds(Collection<Long> ids, Boolean isValid);

    Boolean deleteWithValidByIds(List<Long> achievementIds, Boolean b);
}

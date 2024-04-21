package top.sharehome.business.service;

import top.sharehome.business.domain.Achievement;
import top.sharehome.business.domain.vo.AchievementVo;
import top.sharehome.business.domain.bo.AchievementBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 成果Service接口
 *
 * @author AntonyCheng
 * @date 2024-04-21
 */
public interface IAchievementService {

    /**
     * 查询成果
     */
    AchievementVo queryById(Long achievementId);

    /**
     * 查询成果列表
     */
    TableDataInfo<AchievementVo> queryPageList(AchievementBo bo, PageQuery pageQuery);

    /**
     * 查询成果列表
     */
    List<AchievementVo> queryList(AchievementBo bo);

    /**
     * 新增成果
     */
    Boolean insertByBo(AchievementBo bo);

    /**
     * 修改成果
     */
    Boolean updateByBo(AchievementBo bo);

    /**
     * 校验并批量删除成果信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}

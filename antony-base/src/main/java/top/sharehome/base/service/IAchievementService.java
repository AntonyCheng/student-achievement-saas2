package top.sharehome.base.service;

import top.sharehome.base.domain.Achievement;
import top.sharehome.base.domain.vo.AchievementVo;
import top.sharehome.base.domain.bo.AchievementBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 成果类型Service接口
 *
 * @author AntonyCheng
 * @date 2024-04-15
 */
public interface IAchievementService {

    /**
     * 查询成果类型
     */
    AchievementVo queryById(Long achievementId);

    /**
     * 查询成果类型列表
     */
    TableDataInfo<AchievementVo> queryPageList(AchievementBo bo, PageQuery pageQuery);

    /**
     * 查询成果类型列表
     */
    List<AchievementVo> queryList(AchievementBo bo);

    /**
     * 新增成果类型
     */
    Boolean insertByBo(AchievementBo bo);

    /**
     * 修改成果类型
     */
    Boolean updateByBo(AchievementBo bo);

    /**
     * 校验并批量删除成果类型信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}

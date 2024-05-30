package top.sharehome.business.service;

import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import top.sharehome.business.domain.bo.CompetitionBo;
import top.sharehome.business.domain.vo.CompetitionVo;

import java.util.Collection;
import java.util.List;

/**
 * 在校竞赛管理Service接口
 *
 * @author AntonyCheng
 * @date 2024-05-27
 */
public interface ICompetitionService {

    /**
     * 查询在校竞赛管理
     */
    CompetitionVo queryById(Long achievementId);

    /**
     * 查询在校竞赛管理列表
     */
    TableDataInfo<CompetitionVo> queryMyPageList(CompetitionBo bo, PageQuery pageQuery);

    TableDataInfo<CompetitionVo> queryStuPageList(CompetitionBo bo, PageQuery pageQuery);

    TableDataInfo<CompetitionVo> queryPageList(CompetitionBo bo, PageQuery pageQuery);

    /**
     * 查询在校竞赛管理列表
     */
    List<CompetitionVo> queryMyList(CompetitionBo bo);

    List<CompetitionVo> queryStuList(CompetitionBo bo);

    List<CompetitionVo> queryList(CompetitionBo bo);

    /**
     * 新增在校竞赛管理
     */
    Boolean insertByBo(CompetitionBo bo);

    /**
     * 修改在校竞赛管理
     */
    Boolean updateMyByBo(CompetitionBo bo);

    Boolean updateStuByBo(CompetitionBo bo);

    /**
     * 校验并批量删除在校竞赛管理信息
     */
    Boolean deleteMyWithValidByIds(Collection<Long> ids, Boolean isValid);

    Boolean deleteWithValidByIds(List<Long> achievementIds, Boolean b);
}

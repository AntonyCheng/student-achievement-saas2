package top.sharehome.base.service;

import top.sharehome.base.domain.Competition;
import top.sharehome.base.domain.vo.CompetitionVo;
import top.sharehome.base.domain.bo.CompetitionBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 竞赛类型Service接口
 *
 * @author AntonyCheng
 * @date 2024-04-15
 */
public interface ICompetitionService {

    /**
     * 查询竞赛类型
     */
    CompetitionVo queryById(Long competitionId);

    /**
     * 查询竞赛类型列表
     */
    TableDataInfo<CompetitionVo> queryPageList(CompetitionBo bo, PageQuery pageQuery);

    /**
     * 查询竞赛类型列表
     */
    List<CompetitionVo> queryList(CompetitionBo bo);

    /**
     * 新增竞赛类型
     */
    Boolean insertByBo(CompetitionBo bo);

    /**
     * 修改竞赛类型
     */
    Boolean updateByBo(CompetitionBo bo);

    /**
     * 校验并批量删除竞赛类型信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}

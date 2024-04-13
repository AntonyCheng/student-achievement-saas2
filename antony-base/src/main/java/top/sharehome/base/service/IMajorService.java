package top.sharehome.base.service;

import top.sharehome.base.domain.Major;
import top.sharehome.base.domain.vo.MajorVo;
import top.sharehome.base.domain.bo.MajorBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 专业Service接口
 *
 * @author AntonyCheng
 * @date 2024-04-13
 */
public interface IMajorService {

    /**
     * 查询专业
     */
    MajorVo queryById(Long majorId);

    /**
     * 查询专业列表
     */
    TableDataInfo<MajorVo> queryPageList(MajorBo bo, PageQuery pageQuery);

    /**
     * 查询专业列表
     */
    List<MajorVo> queryList(MajorBo bo);

    /**
     * 新增专业
     */
    Boolean insertByBo(MajorBo bo);

    /**
     * 修改专业
     */
    Boolean updateByBo(MajorBo bo);

    /**
     * 校验并批量删除专业信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}

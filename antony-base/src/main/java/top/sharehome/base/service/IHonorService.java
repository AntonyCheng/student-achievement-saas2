package top.sharehome.base.service;

import top.sharehome.base.domain.Honor;
import top.sharehome.base.domain.vo.HonorVo;
import top.sharehome.base.domain.bo.HonorBo;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;

import java.util.Collection;
import java.util.List;

/**
 * 荣誉类型Service接口
 *
 * @author AntonyCheng
 * @date 2024-04-15
 */
public interface IHonorService {

    /**
     * 查询荣誉类型
     */
    HonorVo queryById(Long honorId);

    /**
     * 查询荣誉类型列表
     */
    TableDataInfo<HonorVo> queryPageList(HonorBo bo, PageQuery pageQuery);

    /**
     * 查询荣誉类型列表
     */
    List<HonorVo> queryList(HonorBo bo);

    /**
     * 新增荣誉类型
     */
    Boolean insertByBo(HonorBo bo);

    /**
     * 修改荣誉类型
     */
    Boolean updateByBo(HonorBo bo);

    /**
     * 校验并批量删除荣誉类型信息
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}

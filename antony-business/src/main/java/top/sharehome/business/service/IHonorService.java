package top.sharehome.business.service;

import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import top.sharehome.business.domain.bo.HonorBo;
import top.sharehome.business.domain.vo.HonorVo;

import java.util.Collection;
import java.util.List;

/**
 * 在校荣誉管理Service接口
 *
 * @author AntonyCheng
 * @date 2024-05-27
 */
public interface IHonorService {

    /**
     * 查询在校荣誉管理
     */
    HonorVo queryById(Long honorId);

    /**
     * 查询在校荣誉管理列表
     */
    TableDataInfo<HonorVo> queryMyPageList(HonorBo bo, PageQuery pageQuery);

    TableDataInfo<HonorVo> queryStuPageList(HonorBo bo, PageQuery pageQuery);

    TableDataInfo<HonorVo> queryPageList(HonorBo bo, PageQuery pageQuery);

    /**
     * 查询在校荣誉管理列表
     */
    List<HonorVo> queryMyList(HonorBo bo);

    List<HonorVo> queryStuList(HonorBo bo);

    List<HonorVo> queryList(HonorBo bo);

    /**
     * 新增在校荣誉管理
     */
    Boolean insertByBo(HonorBo bo);

    /**
     * 修改在校荣誉管理
     */
    Boolean updateMyByBo(HonorBo bo);

    Boolean updateStuByBo(HonorBo bo);

    /**
     * 校验并批量删除在校荣誉管理信息
     */
    Boolean deleteMyWithValidByIds(Collection<Long> ids, Boolean isValid);

    Boolean deleteWithValidByIds(List<Long> honorIds, Boolean b);
}

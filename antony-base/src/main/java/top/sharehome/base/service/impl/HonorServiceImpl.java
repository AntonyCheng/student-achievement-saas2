package top.sharehome.base.service.impl;

import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.sharehome.base.domain.bo.HonorBo;
import top.sharehome.base.domain.vo.HonorVo;
import top.sharehome.base.domain.Honor;
import top.sharehome.base.mapper.HonorMapper;
import top.sharehome.base.service.IHonorService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 荣誉类型Service业务层处理
 *
 * @author AntonyCheng
 * @date 2024-04-15
 */
@RequiredArgsConstructor
@Service
public class HonorServiceImpl implements IHonorService {

    private final HonorMapper baseMapper;

    /**
     * 查询荣誉类型
     */
    @Override
    public HonorVo queryById(Long honorId){
        return baseMapper.selectVoById(honorId);
    }

    /**
     * 查询荣誉类型列表
     */
    @Override
    public TableDataInfo<HonorVo> queryPageList(HonorBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<Honor> lqw = buildQueryWrapper(bo);
        Page<HonorVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询荣誉类型列表
     */
    @Override
    public List<HonorVo> queryList(HonorBo bo) {
        LambdaQueryWrapper<Honor> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<Honor> buildQueryWrapper(HonorBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<Honor> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(bo.getHonorName()), Honor::getHonorName, bo.getHonorName());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), Honor::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增荣誉类型
     */
    @Override
    public Boolean insertByBo(HonorBo bo) {
        Honor add = MapstructUtils.convert(bo, Honor.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setHonorId(add.getHonorId());
        }
        return flag;
    }

    /**
     * 修改荣誉类型
     */
    @Override
    public Boolean updateByBo(HonorBo bo) {
        Honor update = MapstructUtils.convert(bo, Honor.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(Honor entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除荣誉类型
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}

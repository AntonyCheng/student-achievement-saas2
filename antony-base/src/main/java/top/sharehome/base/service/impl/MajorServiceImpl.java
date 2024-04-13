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
import top.sharehome.base.domain.bo.MajorBo;
import top.sharehome.base.domain.vo.MajorVo;
import top.sharehome.base.domain.Major;
import top.sharehome.base.mapper.MajorMapper;
import top.sharehome.base.service.IMajorService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 专业Service业务层处理
 *
 * @author AntonyCheng
 * @date 2024-04-13
 */
@RequiredArgsConstructor
@Service
public class MajorServiceImpl implements IMajorService {

    private final MajorMapper baseMapper;

    /**
     * 查询专业
     */
    @Override
    public MajorVo queryById(Long majorId){
        return baseMapper.selectVoById(majorId);
    }

    /**
     * 查询专业列表
     */
    @Override
    public TableDataInfo<MajorVo> queryPageList(MajorBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<Major> lqw = buildQueryWrapper(bo);
        Page<MajorVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询专业列表
     */
    @Override
    public List<MajorVo> queryList(MajorBo bo) {
        LambdaQueryWrapper<Major> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<Major> buildQueryWrapper(MajorBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<Major> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getDeptId() != null, Major::getDeptId, bo.getDeptId());
        lqw.like(StringUtils.isNotBlank(bo.getMajorName()), Major::getMajorName, bo.getMajorName());
        lqw.eq(StringUtils.isNotBlank(bo.getMajorGrade()), Major::getMajorGrade, bo.getMajorGrade());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), Major::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增专业
     */
    @Override
    public Boolean insertByBo(MajorBo bo) {
        Major add = MapstructUtils.convert(bo, Major.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setMajorId(add.getMajorId());
        }
        return flag;
    }

    /**
     * 修改专业
     */
    @Override
    public Boolean updateByBo(MajorBo bo) {
        Major update = MapstructUtils.convert(bo, Major.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(Major entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除专业
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}

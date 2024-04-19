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
import top.sharehome.base.domain.bo.AchievementBo;
import top.sharehome.base.domain.vo.AchievementVo;
import top.sharehome.base.domain.Achievement;
import top.sharehome.base.mapper.AchievementMapper;
import top.sharehome.base.service.IAchievementService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 成果类型Service业务层处理
 *
 * @author AntonyCheng
 * @date 2024-04-15
 */
@RequiredArgsConstructor
@Service
public class AchievementServiceImpl implements IAchievementService {

    private final AchievementMapper baseMapper;

    /**
     * 查询成果类型
     */
    @Override
    public AchievementVo queryById(Long achievementId){
        return baseMapper.selectVoById(achievementId);
    }

    /**
     * 查询成果类型列表
     */
    @Override
    public TableDataInfo<AchievementVo> queryPageList(AchievementBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<Achievement> lqw = buildQueryWrapper(bo);
        Page<AchievementVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询成果类型列表
     */
    @Override
    public List<AchievementVo> queryList(AchievementBo bo) {
        LambdaQueryWrapper<Achievement> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<Achievement> buildQueryWrapper(AchievementBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<Achievement> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(bo.getAchievementTypeName()), Achievement::getAchievementTypeName, bo.getAchievementTypeName());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), Achievement::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增成果类型
     */
    @Override
    public Boolean insertByBo(AchievementBo bo) {
        Achievement add = MapstructUtils.convert(bo, Achievement.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setAchievementTypeId(add.getAchievementTypeId());
        }
        return flag;
    }

    /**
     * 修改成果类型
     */
    @Override
    public Boolean updateByBo(AchievementBo bo) {
        Achievement update = MapstructUtils.convert(bo, Achievement.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(Achievement entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除成果类型
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}

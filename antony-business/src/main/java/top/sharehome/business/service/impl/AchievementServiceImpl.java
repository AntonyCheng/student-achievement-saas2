package top.sharehome.business.service.impl;

import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.mybatis.core.page.PageQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.sharehome.business.domain.bo.AchievementBo;
import top.sharehome.business.domain.vo.AchievementVo;
import top.sharehome.business.domain.Achievement;
import top.sharehome.business.mapper.AchievementMapper;
import top.sharehome.business.service.IAchievementService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 成果Service业务层处理
 *
 * @author AntonyCheng
 * @date 2024-04-21
 */
@RequiredArgsConstructor
@Service
public class AchievementServiceImpl implements IAchievementService {

    private final AchievementMapper baseMapper;

    /**
     * 查询成果
     */
    @Override
    public AchievementVo queryById(Long achievementId){
        return baseMapper.selectVoById(achievementId);
    }

    /**
     * 查询成果列表
     */
    @Override
    public TableDataInfo<AchievementVo> queryPageList(AchievementBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<Achievement> lqw = buildQueryWrapper(bo);
        Page<AchievementVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询成果列表
     */
    @Override
    public List<AchievementVo> queryList(AchievementBo bo) {
        LambdaQueryWrapper<Achievement> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<Achievement> buildQueryWrapper(AchievementBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<Achievement> lqw = Wrappers.lambdaQuery();
        lqw.eq(bo.getAchievementTypeId() != null, Achievement::getAchievementTypeId, bo.getAchievementTypeId());
        lqw.eq(bo.getAchievementStudentId() != null, Achievement::getAchievementStudentId, bo.getAchievementStudentId());
        lqw.eq(bo.getAchievementTeacherId() != null, Achievement::getAchievementTeacherId, bo.getAchievementTeacherId());
        lqw.eq(StringUtils.isNotBlank(bo.getAchievementOtherStudentIds()), Achievement::getAchievementOtherStudentIds, bo.getAchievementOtherStudentIds());
        lqw.eq(StringUtils.isNotBlank(bo.getAchievementOtherTeacherIds()), Achievement::getAchievementOtherTeacherIds, bo.getAchievementOtherTeacherIds());
        lqw.eq(StringUtils.isNotBlank(bo.getAchievementEvidenceUrl()), Achievement::getAchievementEvidenceUrl, bo.getAchievementEvidenceUrl());
        lqw.eq(StringUtils.isNotBlank(bo.getAchievementFeedback()), Achievement::getAchievementFeedback, bo.getAchievementFeedback());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), Achievement::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增成果
     */
    @Override
    public Boolean insertByBo(AchievementBo bo) {
        Achievement add = MapstructUtils.convert(bo, Achievement.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setAchievementId(add.getAchievementId());
        }
        return flag;
    }

    /**
     * 修改成果
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
     * 批量删除成果
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}

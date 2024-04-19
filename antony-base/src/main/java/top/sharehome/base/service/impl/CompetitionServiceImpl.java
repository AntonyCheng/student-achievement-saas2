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
import top.sharehome.base.domain.bo.CompetitionBo;
import top.sharehome.base.domain.vo.CompetitionVo;
import top.sharehome.base.domain.Competition;
import top.sharehome.base.mapper.CompetitionMapper;
import top.sharehome.base.service.ICompetitionService;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 竞赛类型Service业务层处理
 *
 * @author AntonyCheng
 * @date 2024-04-15
 */
@RequiredArgsConstructor
@Service
public class CompetitionServiceImpl implements ICompetitionService {

    private final CompetitionMapper baseMapper;

    /**
     * 查询竞赛类型
     */
    @Override
    public CompetitionVo queryById(Long competitionId){
        return baseMapper.selectVoById(competitionId);
    }

    /**
     * 查询竞赛类型列表
     */
    @Override
    public TableDataInfo<CompetitionVo> queryPageList(CompetitionBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<Competition> lqw = buildQueryWrapper(bo);
        Page<CompetitionVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询竞赛类型列表
     */
    @Override
    public List<CompetitionVo> queryList(CompetitionBo bo) {
        LambdaQueryWrapper<Competition> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<Competition> buildQueryWrapper(CompetitionBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<Competition> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(bo.getCompetitionTypeName()), Competition::getCompetitionTypeName, bo.getCompetitionTypeName());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), Competition::getStatus, bo.getStatus());
        return lqw;
    }

    /**
     * 新增竞赛类型
     */
    @Override
    public Boolean insertByBo(CompetitionBo bo) {
        Competition add = MapstructUtils.convert(bo, Competition.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setCompetitionTypeId(add.getCompetitionTypeId());
        }
        return flag;
    }

    /**
     * 修改竞赛类型
     */
    @Override
    public Boolean updateByBo(CompetitionBo bo) {
        Competition update = MapstructUtils.convert(bo, Competition.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private void validEntityBeforeSave(Competition entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除竞赛类型
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}

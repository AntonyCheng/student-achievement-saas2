package top.sharehome.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.dromara.common.core.constant.HttpStatus;
import org.dromara.common.core.exception.base.BaseException;
import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.satoken.utils.LoginHelper;
import org.dromara.common.tenant.helper.TenantHelper;
import org.dromara.system.api.RemoteDeptService;
import org.dromara.system.api.RemoteUserService;
import org.dromara.system.api.model.LoginUser;
import org.springframework.stereotype.Service;
import top.sharehome.base.api.RemoteCompetitionTypeService;
import top.sharehome.business.domain.Competition;
import top.sharehome.business.domain.bo.CompetitionBo;
import top.sharehome.business.domain.vo.CompetitionVo;
import top.sharehome.business.mapper.CompetitionMapper;
import top.sharehome.business.service.ICompetitionService;

import java.util.*;

/**
 * 在校竞赛管理Service业务层处理
 *
 * @author AntonyCheng
 * @date 2024-05-27
 */
@RequiredArgsConstructor
@Service
public class CompetitionServiceImpl implements ICompetitionService {

    private final CompetitionMapper baseMapper;

    @DubboReference
    private final RemoteUserService remoteUserService;

    @DubboReference
    private final RemoteDeptService remoteDeptService;

    @DubboReference
    private final RemoteCompetitionTypeService remoteCompetitionTypeService;

    /**
     * 查询在校竞赛管理
     */
    @Override
    public CompetitionVo queryById(Long competitionId) {
        CompetitionVo competitionVo = baseMapper.selectVoById(competitionId);
        competitionVo.setCompetitionTypeName(remoteCompetitionTypeService.queryCompetitionTypeNameById(competitionVo.getCompetitionTypeId()));
        competitionVo.setCompetitionStudentDeptName(remoteDeptService.selectDeptNameByIds(competitionVo.getCompetitionStudentDeptId().toString()));
        competitionVo.setCompetitionStudentName(remoteUserService.selectNicknameById(competitionVo.getCompetitionStudentId()));
        competitionVo.setCompetitionTeacherName(remoteUserService.selectNicknameById(competitionVo.getCompetitionTeacherId()));
        if (StringUtils.isNotEmpty(competitionVo.getCompetitionOtherStudentIds())) {
            String[] split = competitionVo.getCompetitionOtherStudentIds().split(",");
            List<String> nameList = new ArrayList<>();
            for (String s : split) {
                nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
            }
            competitionVo.setCompetitionOtherStudentNames(String.join(",", nameList));
        }
        if (StringUtils.isNotEmpty(competitionVo.getCompetitionOtherTeacherIds())) {
            String[] split = competitionVo.getCompetitionOtherTeacherIds().split(",");
            List<String> nameList = new ArrayList<>();
            for (String s : split) {
                nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
            }
            competitionVo.setCompetitionOtherTeacherNames(String.join(",", nameList));
        }
        return competitionVo;
    }

    /**
     * 查询在校竞赛管理列表
     */
    @Override
    public TableDataInfo<CompetitionVo> queryMyPageList(CompetitionBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<Competition> lqw = buildMyQueryWrapper(bo);
        Page<CompetitionVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        result.getRecords().forEach(competitionVo -> {
            competitionVo.setCompetitionTypeName(remoteCompetitionTypeService.queryCompetitionTypeNameById(competitionVo.getCompetitionTypeId()));
            competitionVo.setCompetitionStudentDeptName(remoteDeptService.selectDeptNameByIds(competitionVo.getCompetitionStudentDeptId().toString()));
            competitionVo.setCompetitionStudentName(remoteUserService.selectNicknameById(competitionVo.getCompetitionStudentId()));
            competitionVo.setCompetitionTeacherName(remoteUserService.selectNicknameById(competitionVo.getCompetitionTeacherId()));
            if (StringUtils.isNotEmpty(competitionVo.getCompetitionOtherStudentIds())) {
                String[] split = competitionVo.getCompetitionOtherStudentIds().split(",");
                List<String> nameList = new ArrayList<>();
                for (String s : split) {
                    nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
                }
                competitionVo.setCompetitionOtherStudentNames(String.join(",", nameList));
            }
            if (StringUtils.isNotEmpty(competitionVo.getCompetitionOtherTeacherIds())) {
                String[] split = competitionVo.getCompetitionOtherTeacherIds().split(",");
                List<String> nameList = new ArrayList<>();
                for (String s : split) {
                    nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
                }
                competitionVo.setCompetitionOtherTeacherNames(String.join(",", nameList));
            }
        });
        return TableDataInfo.build(result);
    }

    @Override
    public TableDataInfo<CompetitionVo> queryStuPageList(CompetitionBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<Competition> lqw = buildStuQueryWrapper(bo);
        Page<CompetitionVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        result.getRecords().forEach(competitionVo -> {
            competitionVo.setCompetitionTypeName(remoteCompetitionTypeService.queryCompetitionTypeNameById(competitionVo.getCompetitionTypeId()));
            competitionVo.setCompetitionStudentDeptName(remoteDeptService.selectDeptNameByIds(competitionVo.getCompetitionStudentDeptId().toString()));
            competitionVo.setCompetitionStudentName(remoteUserService.selectNicknameById(competitionVo.getCompetitionStudentId()));
            competitionVo.setCompetitionTeacherName(remoteUserService.selectNicknameById(competitionVo.getCompetitionTeacherId()));
            if (StringUtils.isNotEmpty(competitionVo.getCompetitionOtherStudentIds())) {
                String[] split = competitionVo.getCompetitionOtherStudentIds().split(",");
                List<String> nameList = new ArrayList<>();
                for (String s : split) {
                    nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
                }
                competitionVo.setCompetitionOtherStudentNames(String.join(",", nameList));
            }
            if (StringUtils.isNotEmpty(competitionVo.getCompetitionOtherTeacherIds())) {
                String[] split = competitionVo.getCompetitionOtherTeacherIds().split(",");
                List<String> nameList = new ArrayList<>();
                for (String s : split) {
                    nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
                }
                competitionVo.setCompetitionOtherTeacherNames(String.join(",", nameList));
            }
        });
        return TableDataInfo.build(result);
    }

    @Override
    public TableDataInfo<CompetitionVo> queryPageList(CompetitionBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<Competition> lqw = buildQueryWrapper(bo);
        Page<CompetitionVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        result.getRecords().forEach(competitionVo -> {
            competitionVo.setCompetitionTypeName(remoteCompetitionTypeService.queryCompetitionTypeNameById(competitionVo.getCompetitionTypeId()));
            competitionVo.setCompetitionStudentDeptName(remoteDeptService.selectDeptNameByIds(competitionVo.getCompetitionStudentDeptId().toString()));
            competitionVo.setCompetitionStudentName(remoteUserService.selectNicknameById(competitionVo.getCompetitionStudentId()));
            competitionVo.setCompetitionTeacherName(remoteUserService.selectNicknameById(competitionVo.getCompetitionTeacherId()));
            if (StringUtils.isNotEmpty(competitionVo.getCompetitionOtherStudentIds())) {
                String[] split = competitionVo.getCompetitionOtherStudentIds().split(",");
                List<String> nameList = new ArrayList<>();
                for (String s : split) {
                    nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
                }
                competitionVo.setCompetitionOtherStudentNames(String.join(",", nameList));
            }
            if (StringUtils.isNotEmpty(competitionVo.getCompetitionOtherTeacherIds())) {
                String[] split = competitionVo.getCompetitionOtherTeacherIds().split(",");
                List<String> nameList = new ArrayList<>();
                for (String s : split) {
                    nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
                }
                competitionVo.setCompetitionOtherTeacherNames(String.join(",", nameList));
            }
        });
        return TableDataInfo.build(result);
    }

    /**
     * 查询在校竞赛管理列表
     */
    @Override
    public List<CompetitionVo> queryMyList(CompetitionBo bo) {
        LambdaQueryWrapper<Competition> lqw = buildMyQueryWrapper(bo);
        List<CompetitionVo> competitionVos = baseMapper.selectVoList(lqw).stream().filter(competitionVo -> StringUtils.equals(competitionVo.getStatus(), "1")).toList();
        competitionVos.forEach(competitionVo -> {
            competitionVo.setCompetitionTypeName(remoteCompetitionTypeService.queryCompetitionTypeNameById(competitionVo.getCompetitionTypeId()));
            competitionVo.setCompetitionStudentDeptName(remoteDeptService.selectDeptNameByIds(competitionVo.getCompetitionStudentDeptId().toString()));
            competitionVo.setCompetitionStudentName(remoteUserService.selectNicknameById(competitionVo.getCompetitionStudentId()));
            competitionVo.setCompetitionTeacherName(remoteUserService.selectNicknameById(competitionVo.getCompetitionTeacherId()));
            if (StringUtils.isNotEmpty(competitionVo.getCompetitionOtherStudentIds())) {
                String[] split = competitionVo.getCompetitionOtherStudentIds().split(",");
                List<String> nameList = new ArrayList<>();
                for (String s : split) {
                    nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
                }
                competitionVo.setCompetitionOtherStudentNames(String.join(",", nameList));
            }
            if (StringUtils.isNotEmpty(competitionVo.getCompetitionOtherTeacherIds())) {
                String[] split = competitionVo.getCompetitionOtherTeacherIds().split(",");
                List<String> nameList = new ArrayList<>();
                for (String s : split) {
                    nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
                }
                competitionVo.setCompetitionOtherTeacherNames(String.join(",", nameList));
            }
        });
        return competitionVos;
    }

    @Override
    public List<CompetitionVo> queryStuList(CompetitionBo bo) {
        LambdaQueryWrapper<Competition> lqw = buildStuQueryWrapper(bo);
        List<CompetitionVo> competitionVos = baseMapper.selectVoList(lqw);
        competitionVos.forEach(competitionVo -> {
            competitionVo.setCompetitionTypeName(remoteCompetitionTypeService.queryCompetitionTypeNameById(competitionVo.getCompetitionTypeId()));
            competitionVo.setCompetitionStudentDeptName(remoteDeptService.selectDeptNameByIds(competitionVo.getCompetitionStudentDeptId().toString()));
            competitionVo.setCompetitionStudentName(remoteUserService.selectNicknameById(competitionVo.getCompetitionStudentId()));
            competitionVo.setCompetitionTeacherName(remoteUserService.selectNicknameById(competitionVo.getCompetitionTeacherId()));
            if (StringUtils.isNotEmpty(competitionVo.getCompetitionOtherStudentIds())) {
                String[] split = competitionVo.getCompetitionOtherStudentIds().split(",");
                List<String> nameList = new ArrayList<>();
                for (String s : split) {
                    nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
                }
                competitionVo.setCompetitionOtherStudentNames(String.join(",", nameList));
            }
            if (StringUtils.isNotEmpty(competitionVo.getCompetitionOtherTeacherIds())) {
                String[] split = competitionVo.getCompetitionOtherTeacherIds().split(",");
                List<String> nameList = new ArrayList<>();
                for (String s : split) {
                    nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
                }
                competitionVo.setCompetitionOtherTeacherNames(String.join(",", nameList));
            }
        });
        return competitionVos;
    }

    @Override
    public List<CompetitionVo> queryList(CompetitionBo bo) {
        LambdaQueryWrapper<Competition> lqw = buildQueryWrapper(bo);
        List<CompetitionVo> competitionVos = baseMapper.selectVoList(lqw);
        competitionVos.forEach(competitionVo -> {
            competitionVo.setCompetitionTypeName(remoteCompetitionTypeService.queryCompetitionTypeNameById(competitionVo.getCompetitionTypeId()));
            competitionVo.setCompetitionStudentDeptName(remoteDeptService.selectDeptNameByIds(competitionVo.getCompetitionStudentDeptId().toString()));
            competitionVo.setCompetitionStudentName(remoteUserService.selectNicknameById(competitionVo.getCompetitionStudentId()));
            competitionVo.setCompetitionTeacherName(remoteUserService.selectNicknameById(competitionVo.getCompetitionTeacherId()));
            if (StringUtils.isNotEmpty(competitionVo.getCompetitionOtherStudentIds())) {
                String[] split = competitionVo.getCompetitionOtherStudentIds().split(",");
                List<String> nameList = new ArrayList<>();
                for (String s : split) {
                    nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
                }
                competitionVo.setCompetitionOtherStudentNames(String.join(",", nameList));
            }
            if (StringUtils.isNotEmpty(competitionVo.getCompetitionOtherTeacherIds())) {
                String[] split = competitionVo.getCompetitionOtherTeacherIds().split(",");
                List<String> nameList = new ArrayList<>();
                for (String s : split) {
                    nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
                }
                competitionVo.setCompetitionOtherTeacherNames(String.join(",", nameList));
            }
        });
        return competitionVos;
    }

    private LambdaQueryWrapper<Competition> buildMyQueryWrapper(CompetitionBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<Competition> lqw = Wrappers.lambdaQuery();
        lqw.
            and(qw -> {
                qw.eq(Competition::getCompetitionStudentId, LoginHelper.getUserId())
                    .or()
                    .like(Competition::getCompetitionOtherStudentIds, LoginHelper.getUserId());
            })
            .and(ObjectUtils.anyNotNull(bo.getCompetitionTypeId(), bo.getCompetitionName(), bo.getCompetitionTeacherId(), bo.getCompetitionOtherStudentIds(), bo.getCompetitionOtherTeacherIds()),
                qw -> {
                    qw.eq(bo.getCompetitionTypeId() != null, Competition::getCompetitionTypeId, bo.getCompetitionTypeId());
                    qw.eq(bo.getCompetitionStudentDeptId() != null, Competition::getCompetitionStudentDeptId, bo.getCompetitionStudentDeptId());
                    qw.eq(bo.getCompetitionTeacherId() != null, Competition::getCompetitionTeacherId, bo.getCompetitionTeacherId());
                    qw.like(bo.getCompetitionName() != null, Competition::getCompetitionName, bo.getCompetitionName());
                    if (StringUtils.isNotBlank(bo.getCompetitionOtherStudentIds())) {
                        String[] split = bo.getCompetitionOtherStudentIds().split(",");
                        if (split.length == 1) {
                            qw.like(Competition::getCompetitionOtherStudentIds, bo.getCompetitionOtherStudentIds());
                        } else {
                            for (String s : split) {
                                qw.like(Competition::getCompetitionOtherStudentIds, s);
                            }
                        }
                    }
                    if (StringUtils.isNotBlank(bo.getCompetitionOtherTeacherIds())) {
                        String[] split = bo.getCompetitionOtherTeacherIds().split(",");
                        if (split.length == 1) {
                            qw.like(Competition::getCompetitionOtherTeacherIds, bo.getCompetitionOtherTeacherIds());
                        } else {
                            for (String s : split) {
                                qw.like(Competition::getCompetitionOtherTeacherIds, s);
                            }
                        }
                    }
                    qw.eq(StringUtils.isNotBlank(bo.getStatus()), Competition::getStatus, bo.getStatus());
                });
        return lqw;
    }

    private LambdaQueryWrapper<Competition> buildStuQueryWrapper(CompetitionBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<Competition> lqw = Wrappers.lambdaQuery();
        lqw.eq(Competition::getCompetitionTeacherId, LoginHelper.getUserId())
            .and(ObjectUtils.anyNotNull(bo.getCompetitionTypeId(), bo.getCompetitionName(), bo.getCompetitionStudentId(), bo.getCompetitionOtherStudentIds(), bo.getCompetitionOtherTeacherIds()),
                qw -> {
                    qw.eq(bo.getCompetitionTypeId() != null, Competition::getCompetitionTypeId, bo.getCompetitionTypeId());
                    qw.eq(bo.getCompetitionStudentDeptId() != null, Competition::getCompetitionStudentDeptId, bo.getCompetitionStudentDeptId());
                    qw.eq(bo.getCompetitionStudentId() != null, Competition::getCompetitionStudentId, bo.getCompetitionStudentId());
                    qw.like(bo.getCompetitionName() != null, Competition::getCompetitionName, bo.getCompetitionName());
                    if (StringUtils.isNotBlank(bo.getCompetitionOtherStudentIds())) {
                        String[] split = bo.getCompetitionOtherStudentIds().split(",");
                        if (split.length == 1) {
                            qw.like(Competition::getCompetitionOtherStudentIds, bo.getCompetitionOtherStudentIds());
                        } else {
                            for (String s : split) {
                                qw.like(Competition::getCompetitionOtherStudentIds, s);
                            }
                        }
                    }
                    if (StringUtils.isNotBlank(bo.getCompetitionOtherTeacherIds())) {
                        String[] split = bo.getCompetitionOtherTeacherIds().split(",");
                        if (split.length == 1) {
                            qw.like(Competition::getCompetitionOtherTeacherIds, bo.getCompetitionOtherTeacherIds());
                        } else {
                            for (String s : split) {
                                qw.like(Competition::getCompetitionOtherTeacherIds, s);
                            }
                        }
                    }
                    qw.eq(StringUtils.isNotBlank(bo.getStatus()), Competition::getStatus, bo.getStatus());
                });
        return lqw;
    }

    private LambdaQueryWrapper<Competition> buildQueryWrapper(CompetitionBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<Competition> lqw = Wrappers.lambdaQuery();
        lqw.and(ObjectUtils.anyNotNull(bo.getCompetitionTypeId(), bo.getCompetitionName(), bo.getCompetitionStudentId(), bo.getCompetitionTeacherId(), bo.getCompetitionOtherStudentIds(), bo.getCompetitionOtherTeacherIds()),
            qw -> {
                qw.eq(bo.getCompetitionTypeId() != null, Competition::getCompetitionTypeId, bo.getCompetitionTypeId());
                qw.eq(bo.getCompetitionStudentId() != null, Competition::getCompetitionStudentId, bo.getCompetitionStudentId());
                qw.eq(bo.getCompetitionStudentDeptId() != null, Competition::getCompetitionStudentDeptId, bo.getCompetitionStudentDeptId());
                qw.eq(bo.getCompetitionTeacherId() != null, Competition::getCompetitionTeacherId, bo.getCompetitionTeacherId());
                qw.like(bo.getCompetitionName() != null, Competition::getCompetitionName, bo.getCompetitionName());
                if (StringUtils.isNotBlank(bo.getCompetitionOtherStudentIds())) {
                    String[] split = bo.getCompetitionOtherStudentIds().split(",");
                    if (split.length == 1) {
                        qw.like(Competition::getCompetitionOtherStudentIds, bo.getCompetitionOtherStudentIds());
                    } else {
                        for (String s : split) {
                            qw.like(Competition::getCompetitionOtherStudentIds, s);
                        }
                    }
                }
                if (StringUtils.isNotBlank(bo.getCompetitionOtherTeacherIds())) {
                    String[] split = bo.getCompetitionOtherTeacherIds().split(",");
                    if (split.length == 1) {
                        qw.like(Competition::getCompetitionOtherTeacherIds, bo.getCompetitionOtherTeacherIds());
                    } else {
                        for (String s : split) {
                            qw.like(Competition::getCompetitionOtherTeacherIds, s);
                        }
                    }
                }
                qw.eq(StringUtils.isNotBlank(bo.getStatus()), Competition::getStatus, bo.getStatus());
            });
        return lqw;
    }

    /**
     * 新增在校竞赛管理
     */
    @Override
    public Boolean insertByBo(CompetitionBo bo) {
        Competition add = MapstructUtils.convert(bo, Competition.class);
        LoginUser loginUser = LoginHelper.getLoginUser();
        add.setCompetitionStudentId(loginUser.getUserId());
        add.setCompetitionStudentDeptId(loginUser.getDeptId());
        String validRes = validMyEntityBeforeSave(add);
        if (Objects.nonNull(validRes)) {
            throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST), validRes);
        }
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setCompetitionId(add.getCompetitionId());
        }
        return flag;
    }

    /**
     * 修改在校竞赛管理
     */
    @Override
    public Boolean updateMyByBo(CompetitionBo bo) {
        Competition update = MapstructUtils.convert(bo, Competition.class);
        String validRes = validMyEntityBeforeSave(update);
        if (Objects.nonNull(validRes)) {
            throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST), validRes);
        }
        return baseMapper.updateById(update) > 0;
    }

    @Override
    public Boolean updateStuByBo(CompetitionBo bo) {
        Competition update = MapstructUtils.convert(bo, Competition.class);
        String validRes = validStuEntityBeforeSave(update);
        if (Objects.nonNull(validRes)) {
            throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST), validRes);
        }
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private String validMyEntityBeforeSave(Competition entity) {
        if (!Objects.equals(entity.getCompetitionStudentId(), LoginHelper.getUserId())) {
            return "你不是第一作者，无法修改";
        }
        if (Objects.nonNull(entity.getStatus()) && !StringUtils.equals(entity.getStatus(), "0")) {
            return "该数据已经审核完成，无法重复修改";
        }
        List<String> errorTeacherNames = new ArrayList<>();
        List<String> errorStudentNames = new ArrayList<>();
        Long competitionTeacherId = entity.getCompetitionTeacherId();
        String competitionOtherTeacherIds = entity.getCompetitionOtherTeacherIds();
        String competitionOtherStudentIds = entity.getCompetitionOtherStudentIds();
        LoginUser userInfo = remoteUserService.getUserInfo(competitionTeacherId, TenantHelper.getTenantId());
        userInfo.getRoles().forEach(roleDTO -> {
            boolean isStudent = Objects.equals("本科生", roleDTO.getRoleName()) || Objects.equals("研究生", roleDTO.getRoleName());
            if (isStudent) {
                errorTeacherNames.add(userInfo.getNickname());
            }
        });
        if (StringUtils.isNotEmpty(competitionOtherTeacherIds)) {
            List<String> collect = Arrays.stream(competitionOtherTeacherIds.split(",")).toList();
            if (collect.contains(String.valueOf(competitionTeacherId))) {
                return "第一指导老师不能位于“其他老师”中";
            }
            for (String s : collect) {
                LoginUser info = remoteUserService.getUserInfo(Long.valueOf(s), TenantHelper.getTenantId());
                info.getRoles().forEach(roleDTO -> {
                    boolean isStudent = Objects.equals("本科生", roleDTO.getRoleName()) || Objects.equals("研究生", roleDTO.getRoleName());
                    if (isStudent) {
                        errorTeacherNames.add(info.getNickname());
                    }
                });
            }
        }
        if (StringUtils.isNotEmpty(competitionOtherStudentIds)) {
            List<String> collect = Arrays.stream(competitionOtherStudentIds.split(",")).toList();
            Long userId = LoginHelper.getUserId();
            if (collect.contains(String.valueOf(userId))) {
                return "自己不能位于“其他成员”中";
            }
            for (String s : collect) {
                LoginUser info = remoteUserService.getUserInfo(Long.valueOf(s), TenantHelper.getTenantId());
                info.getRoles().forEach(roleDTO -> {
                    boolean isStudent = Objects.equals("本科生", roleDTO.getRoleName()) || Objects.equals("研究生", roleDTO.getRoleName());
                    if (!isStudent) {
                        errorStudentNames.add(info.getNickname());
                    }
                });
            }
        }
        if (!errorTeacherNames.isEmpty()) {
            String joinRes = String.join(",", errorTeacherNames);
            return joinRes + "不是老师";
        } else if (!errorStudentNames.isEmpty()) {
            String joinRes = String.join(",", errorStudentNames);
            return joinRes + "不是学生";
        }
        return null;
    }

    private String validStuEntityBeforeSave(Competition entity) {
        if (!Objects.equals(entity.getCompetitionTeacherId(), LoginHelper.getUserId())) {
            return "你不是第一指导老师，无法修改";
        }
        Competition competition = baseMapper.selectById(entity.getCompetitionId());
        if (Objects.nonNull(entity.getStatus()) && !StringUtils.equals(competition.getStatus(), "0")) {
            return "该数据已经审核完成，无法重复修改";
        }
        return null;
    }

    /**
     * 批量删除在校竞赛管理
     */
    @Override
    public Boolean deleteMyWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if (isValid) {
            List<CompetitionVo> competitionVos = baseMapper.selectVoBatchIds(ids);
            for (CompetitionVo competitionVo : competitionVos) {
                if (!Objects.equals(competitionVo.getCompetitionStudentId(), LoginHelper.getUserId())) {
                    throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST), "你不是第一作者，无法删除");
                }
                if (StringUtils.equals(competitionVo.getStatus(), "0")) {
                    throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST), "竞赛还未审核，无法删除");
                }
                if (StringUtils.equals(competitionVo.getStatus(), "1")) {
                    throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST), "竞赛审核通过，已存档，无法删除");
                }
            }
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }

    @Override
    public Boolean deleteWithValidByIds(List<Long> ids, Boolean isValid) {
        if (isValid) {
            // 权限较高的系统使用者删除数据不需要进行限制
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}

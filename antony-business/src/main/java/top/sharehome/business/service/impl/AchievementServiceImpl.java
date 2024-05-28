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
import top.sharehome.base.api.RemoteAchievementTypeService;
import top.sharehome.business.domain.Achievement;
import top.sharehome.business.domain.bo.AchievementBo;
import top.sharehome.business.domain.vo.AchievementVo;
import top.sharehome.business.mapper.AchievementMapper;
import top.sharehome.business.service.IAchievementService;

import java.util.*;

/**
 * 在校成果管理Service业务层处理
 *
 * @author AntonyCheng
 * @date 2024-05-27
 */
@RequiredArgsConstructor
@Service
public class AchievementServiceImpl implements IAchievementService {

    private final AchievementMapper baseMapper;

    @DubboReference
    private final RemoteUserService remoteUserService;

    @DubboReference
    private final RemoteDeptService remoteDeptService;

    @DubboReference
    private final RemoteAchievementTypeService remoteAchievementTypeService;

    /**
     * 查询在校成果管理
     */
    @Override
    public AchievementVo queryById(Long achievementId) {
        AchievementVo achievementVo = baseMapper.selectVoById(achievementId);
        achievementVo.setAchievementTypeName(remoteAchievementTypeService.queryAchievementTypeNameById(achievementVo.getAchievementTypeId()));
        achievementVo.setAchievementStudentDeptName(remoteDeptService.selectDeptNameByIds(achievementVo.getAchievementStudentDeptId().toString()));
        achievementVo.setAchievementStudentName(remoteUserService.selectNicknameById(achievementVo.getAchievementStudentId()));
        achievementVo.setAchievementTeacherName(remoteUserService.selectNicknameById(achievementVo.getAchievementTeacherId()));
        if (StringUtils.isNotEmpty(achievementVo.getAchievementOtherStudentIds())) {
            String[] split = achievementVo.getAchievementOtherStudentIds().split(",");
            List<String> nameList = new ArrayList<>();
            for (String s : split) {
                nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
            }
            achievementVo.setAchievementOtherStudentNames(String.join(",", nameList));
        }
        if (StringUtils.isNotEmpty(achievementVo.getAchievementOtherTeacherIds())) {
            String[] split = achievementVo.getAchievementOtherTeacherIds().split(",");
            List<String> nameList = new ArrayList<>();
            for (String s : split) {
                nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
            }
            achievementVo.setAchievementOtherTeacherNames(String.join(",", nameList));
        }
        return achievementVo;
    }

    /**
     * 查询在校成果管理列表
     */
    @Override
    public TableDataInfo<AchievementVo> queryMyPageList(AchievementBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<Achievement> lqw = buildMyQueryWrapper(bo);
        Page<AchievementVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        result.getRecords().forEach(achievementVo -> {
            achievementVo.setAchievementTypeName(remoteAchievementTypeService.queryAchievementTypeNameById(achievementVo.getAchievementTypeId()));
            achievementVo.setAchievementStudentDeptName(remoteDeptService.selectDeptNameByIds(achievementVo.getAchievementStudentDeptId().toString()));
            achievementVo.setAchievementStudentName(remoteUserService.selectNicknameById(achievementVo.getAchievementStudentId()));
            achievementVo.setAchievementTeacherName(remoteUserService.selectNicknameById(achievementVo.getAchievementTeacherId()));
            if (StringUtils.isNotEmpty(achievementVo.getAchievementOtherStudentIds())) {
                String[] split = achievementVo.getAchievementOtherStudentIds().split(",");
                List<String> nameList = new ArrayList<>();
                for (String s : split) {
                    nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
                }
                achievementVo.setAchievementOtherStudentNames(String.join(",", nameList));
            }
            if (StringUtils.isNotEmpty(achievementVo.getAchievementOtherTeacherIds())) {
                String[] split = achievementVo.getAchievementOtherTeacherIds().split(",");
                List<String> nameList = new ArrayList<>();
                for (String s : split) {
                    nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
                }
                achievementVo.setAchievementOtherTeacherNames(String.join(",", nameList));
            }
        });
        return TableDataInfo.build(result);
    }

    @Override
    public TableDataInfo<AchievementVo> queryStuPageList(AchievementBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<Achievement> lqw = buildStuQueryWrapper(bo);
        Page<AchievementVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        result.getRecords().forEach(achievementVo -> {
            achievementVo.setAchievementTypeName(remoteAchievementTypeService.queryAchievementTypeNameById(achievementVo.getAchievementTypeId()));
            achievementVo.setAchievementStudentDeptName(remoteDeptService.selectDeptNameByIds(achievementVo.getAchievementStudentDeptId().toString()));
            achievementVo.setAchievementStudentName(remoteUserService.selectNicknameById(achievementVo.getAchievementStudentId()));
            achievementVo.setAchievementTeacherName(remoteUserService.selectNicknameById(achievementVo.getAchievementTeacherId()));
            if (StringUtils.isNotEmpty(achievementVo.getAchievementOtherStudentIds())) {
                String[] split = achievementVo.getAchievementOtherStudentIds().split(",");
                List<String> nameList = new ArrayList<>();
                for (String s : split) {
                    nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
                }
                achievementVo.setAchievementOtherStudentNames(String.join(",", nameList));
            }
            if (StringUtils.isNotEmpty(achievementVo.getAchievementOtherTeacherIds())) {
                String[] split = achievementVo.getAchievementOtherTeacherIds().split(",");
                List<String> nameList = new ArrayList<>();
                for (String s : split) {
                    nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
                }
                achievementVo.setAchievementOtherTeacherNames(String.join(",", nameList));
            }
        });
        return TableDataInfo.build(result);
    }

    @Override
    public TableDataInfo<AchievementVo> queryPageList(AchievementBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<Achievement> lqw = buildQueryWrapper(bo);
        Page<AchievementVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        result.getRecords().forEach(achievementVo -> {
            achievementVo.setAchievementTypeName(remoteAchievementTypeService.queryAchievementTypeNameById(achievementVo.getAchievementTypeId()));
            achievementVo.setAchievementStudentDeptName(remoteDeptService.selectDeptNameByIds(achievementVo.getAchievementStudentDeptId().toString()));
            achievementVo.setAchievementStudentName(remoteUserService.selectNicknameById(achievementVo.getAchievementStudentId()));
            achievementVo.setAchievementTeacherName(remoteUserService.selectNicknameById(achievementVo.getAchievementTeacherId()));
            if (StringUtils.isNotEmpty(achievementVo.getAchievementOtherStudentIds())) {
                String[] split = achievementVo.getAchievementOtherStudentIds().split(",");
                List<String> nameList = new ArrayList<>();
                for (String s : split) {
                    nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
                }
                achievementVo.setAchievementOtherStudentNames(String.join(",", nameList));
            }
            if (StringUtils.isNotEmpty(achievementVo.getAchievementOtherTeacherIds())) {
                String[] split = achievementVo.getAchievementOtherTeacherIds().split(",");
                List<String> nameList = new ArrayList<>();
                for (String s : split) {
                    nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
                }
                achievementVo.setAchievementOtherTeacherNames(String.join(",", nameList));
            }
        });
        return TableDataInfo.build(result);
    }

    /**
     * 查询在校成果管理列表
     */
    @Override
    public List<AchievementVo> queryMyList(AchievementBo bo) {
        LambdaQueryWrapper<Achievement> lqw = buildMyQueryWrapper(bo);
        List<AchievementVo> achievementVos = baseMapper.selectVoList(lqw).stream().filter(achievementVo -> StringUtils.equals(achievementVo.getStatus(), "1")).toList();
        achievementVos.forEach(achievementVo -> {
            achievementVo.setAchievementTypeName(remoteAchievementTypeService.queryAchievementTypeNameById(achievementVo.getAchievementTypeId()));
            achievementVo.setAchievementStudentDeptName(remoteDeptService.selectDeptNameByIds(achievementVo.getAchievementStudentDeptId().toString()));
            achievementVo.setAchievementStudentName(remoteUserService.selectNicknameById(achievementVo.getAchievementStudentId()));
            achievementVo.setAchievementTeacherName(remoteUserService.selectNicknameById(achievementVo.getAchievementTeacherId()));
            if (StringUtils.isNotEmpty(achievementVo.getAchievementOtherStudentIds())) {
                String[] split = achievementVo.getAchievementOtherStudentIds().split(",");
                List<String> nameList = new ArrayList<>();
                for (String s : split) {
                    nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
                }
                achievementVo.setAchievementOtherStudentNames(String.join(",", nameList));
            }
            if (StringUtils.isNotEmpty(achievementVo.getAchievementOtherTeacherIds())) {
                String[] split = achievementVo.getAchievementOtherTeacherIds().split(",");
                List<String> nameList = new ArrayList<>();
                for (String s : split) {
                    nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
                }
                achievementVo.setAchievementOtherTeacherNames(String.join(",", nameList));
            }
        });
        return achievementVos;
    }

    @Override
    public List<AchievementVo> queryStuList(AchievementBo bo) {
        LambdaQueryWrapper<Achievement> lqw = buildStuQueryWrapper(bo);
        List<AchievementVo> achievementVos = baseMapper.selectVoList(lqw);
        achievementVos.forEach(achievementVo -> {
            achievementVo.setAchievementTypeName(remoteAchievementTypeService.queryAchievementTypeNameById(achievementVo.getAchievementTypeId()));
            achievementVo.setAchievementStudentDeptName(remoteDeptService.selectDeptNameByIds(achievementVo.getAchievementStudentDeptId().toString()));
            achievementVo.setAchievementStudentName(remoteUserService.selectNicknameById(achievementVo.getAchievementStudentId()));
            achievementVo.setAchievementTeacherName(remoteUserService.selectNicknameById(achievementVo.getAchievementTeacherId()));
            if (StringUtils.isNotEmpty(achievementVo.getAchievementOtherStudentIds())) {
                String[] split = achievementVo.getAchievementOtherStudentIds().split(",");
                List<String> nameList = new ArrayList<>();
                for (String s : split) {
                    nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
                }
                achievementVo.setAchievementOtherStudentNames(String.join(",", nameList));
            }
            if (StringUtils.isNotEmpty(achievementVo.getAchievementOtherTeacherIds())) {
                String[] split = achievementVo.getAchievementOtherTeacherIds().split(",");
                List<String> nameList = new ArrayList<>();
                for (String s : split) {
                    nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
                }
                achievementVo.setAchievementOtherTeacherNames(String.join(",", nameList));
            }
        });
        return achievementVos;
    }

    @Override
    public List<AchievementVo> queryList(AchievementBo bo) {
        LambdaQueryWrapper<Achievement> lqw = buildQueryWrapper(bo);
        List<AchievementVo> achievementVos = baseMapper.selectVoList(lqw);
        achievementVos.forEach(achievementVo -> {
            achievementVo.setAchievementTypeName(remoteAchievementTypeService.queryAchievementTypeNameById(achievementVo.getAchievementTypeId()));
            achievementVo.setAchievementStudentDeptName(remoteDeptService.selectDeptNameByIds(achievementVo.getAchievementStudentDeptId().toString()));
            achievementVo.setAchievementStudentName(remoteUserService.selectNicknameById(achievementVo.getAchievementStudentId()));
            achievementVo.setAchievementTeacherName(remoteUserService.selectNicknameById(achievementVo.getAchievementTeacherId()));
            if (StringUtils.isNotEmpty(achievementVo.getAchievementOtherStudentIds())) {
                String[] split = achievementVo.getAchievementOtherStudentIds().split(",");
                List<String> nameList = new ArrayList<>();
                for (String s : split) {
                    nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
                }
                achievementVo.setAchievementOtherStudentNames(String.join(",", nameList));
            }
            if (StringUtils.isNotEmpty(achievementVo.getAchievementOtherTeacherIds())) {
                String[] split = achievementVo.getAchievementOtherTeacherIds().split(",");
                List<String> nameList = new ArrayList<>();
                for (String s : split) {
                    nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
                }
                achievementVo.setAchievementOtherTeacherNames(String.join(",", nameList));
            }
        });
        return achievementVos;
    }

    private LambdaQueryWrapper<Achievement> buildMyQueryWrapper(AchievementBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<Achievement> lqw = Wrappers.lambdaQuery();
        lqw.
            and(qw -> {
                qw.eq(Achievement::getAchievementStudentId, LoginHelper.getUserId())
                    .or()
                    .like(Achievement::getAchievementOtherStudentIds, LoginHelper.getUserId());
            })
            .and(ObjectUtils.anyNotNull(bo.getAchievementTypeId(), bo.getAchievementName(), bo.getAchievementTeacherId(), bo.getAchievementOtherStudentIds(), bo.getAchievementOtherTeacherIds()),
                qw -> {
                    qw.eq(bo.getAchievementTypeId() != null, Achievement::getAchievementTypeId, bo.getAchievementTypeId());
                    qw.eq(bo.getAchievementStudentDeptId() != null, Achievement::getAchievementStudentDeptId, bo.getAchievementStudentDeptId());
                    qw.eq(bo.getAchievementTeacherId() != null, Achievement::getAchievementTeacherId, bo.getAchievementTeacherId());
                    qw.like(bo.getAchievementName() != null, Achievement::getAchievementName, bo.getAchievementName());
                    if (StringUtils.isNotBlank(bo.getAchievementOtherStudentIds())) {
                        String[] split = bo.getAchievementOtherStudentIds().split(",");
                        if (split.length == 1) {
                            qw.like(Achievement::getAchievementOtherStudentIds, bo.getAchievementOtherStudentIds());
                        } else {
                            for (String s : split) {
                                qw.like(Achievement::getAchievementOtherStudentIds, s);
                            }
                        }
                    }
                    if (StringUtils.isNotBlank(bo.getAchievementOtherTeacherIds())) {
                        String[] split = bo.getAchievementOtherTeacherIds().split(",");
                        if (split.length == 1) {
                            qw.like(Achievement::getAchievementOtherTeacherIds, bo.getAchievementOtherTeacherIds());
                        } else {
                            for (String s : split) {
                                qw.like(Achievement::getAchievementOtherTeacherIds, s);
                            }
                        }
                    }
                    qw.eq(StringUtils.isNotBlank(bo.getStatus()), Achievement::getStatus, bo.getStatus());
                });
        return lqw;
    }

    private LambdaQueryWrapper<Achievement> buildStuQueryWrapper(AchievementBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<Achievement> lqw = Wrappers.lambdaQuery();
        lqw.eq(Achievement::getAchievementTeacherId, LoginHelper.getUserId())
            .and(ObjectUtils.anyNotNull(bo.getAchievementTypeId(), bo.getAchievementName(), bo.getAchievementTeacherId(), bo.getAchievementOtherStudentIds(), bo.getAchievementOtherTeacherIds()),
                qw -> {
                    qw.eq(bo.getAchievementTypeId() != null, Achievement::getAchievementTypeId, bo.getAchievementTypeId());
                    qw.eq(bo.getAchievementStudentDeptId() != null, Achievement::getAchievementStudentDeptId, bo.getAchievementStudentDeptId());
                    qw.eq(bo.getAchievementTeacherId() != null, Achievement::getAchievementTeacherId, bo.getAchievementTeacherId());
                    qw.like(bo.getAchievementName() != null, Achievement::getAchievementName, bo.getAchievementName());
                    if (StringUtils.isNotBlank(bo.getAchievementOtherStudentIds())) {
                        String[] split = bo.getAchievementOtherStudentIds().split(",");
                        if (split.length == 1) {
                            qw.like(Achievement::getAchievementOtherStudentIds, bo.getAchievementOtherStudentIds());
                        } else {
                            for (String s : split) {
                                qw.like(Achievement::getAchievementOtherStudentIds, s);
                            }
                        }
                    }
                    if (StringUtils.isNotBlank(bo.getAchievementOtherTeacherIds())) {
                        String[] split = bo.getAchievementOtherTeacherIds().split(",");
                        if (split.length == 1) {
                            qw.like(Achievement::getAchievementOtherTeacherIds, bo.getAchievementOtherTeacherIds());
                        } else {
                            for (String s : split) {
                                qw.like(Achievement::getAchievementOtherTeacherIds, s);
                            }
                        }
                    }
                    qw.eq(StringUtils.isNotBlank(bo.getStatus()), Achievement::getStatus, bo.getStatus());
                });
        return lqw;
    }

    private LambdaQueryWrapper<Achievement> buildQueryWrapper(AchievementBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<Achievement> lqw = Wrappers.lambdaQuery();
        lqw.and(ObjectUtils.anyNotNull(bo.getAchievementTypeId(), bo.getAchievementName(), bo.getAchievementTeacherId(), bo.getAchievementOtherStudentIds(), bo.getAchievementOtherTeacherIds()),
                qw -> {
                    qw.eq(bo.getAchievementTypeId() != null, Achievement::getAchievementTypeId, bo.getAchievementTypeId());
                    qw.eq(bo.getAchievementStudentDeptId() != null, Achievement::getAchievementStudentDeptId, bo.getAchievementStudentDeptId());
                    qw.eq(bo.getAchievementTeacherId() != null, Achievement::getAchievementTeacherId, bo.getAchievementTeacherId());
                    qw.like(bo.getAchievementName() != null, Achievement::getAchievementName, bo.getAchievementName());
                    if (StringUtils.isNotBlank(bo.getAchievementOtherStudentIds())) {
                        String[] split = bo.getAchievementOtherStudentIds().split(",");
                        if (split.length == 1) {
                            qw.like(Achievement::getAchievementOtherStudentIds, bo.getAchievementOtherStudentIds());
                        } else {
                            for (String s : split) {
                                qw.like(Achievement::getAchievementOtherStudentIds, s);
                            }
                        }
                    }
                    if (StringUtils.isNotBlank(bo.getAchievementOtherTeacherIds())) {
                        String[] split = bo.getAchievementOtherTeacherIds().split(",");
                        if (split.length == 1) {
                            qw.like(Achievement::getAchievementOtherTeacherIds, bo.getAchievementOtherTeacherIds());
                        } else {
                            for (String s : split) {
                                qw.like(Achievement::getAchievementOtherTeacherIds, s);
                            }
                        }
                    }
                    qw.eq(StringUtils.isNotBlank(bo.getStatus()), Achievement::getStatus, bo.getStatus());
                });
        return lqw;
    }

    /**
     * 新增在校成果管理
     */
    @Override
    public Boolean insertByBo(AchievementBo bo) {
        Achievement add = MapstructUtils.convert(bo, Achievement.class);
        LoginUser loginUser = LoginHelper.getLoginUser();
        add.setAchievementStudentId(loginUser.getUserId());
        add.setAchievementStudentDeptId(loginUser.getDeptId());
        String validRes = validMyEntityBeforeSave(add);
        if (Objects.nonNull(validRes)) {
            throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST), validRes);
        }
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setAchievementId(add.getAchievementId());
        }
        return flag;
    }

    /**
     * 修改在校成果管理
     */
    @Override
    public Boolean updateMyByBo(AchievementBo bo) {
        Achievement update = MapstructUtils.convert(bo, Achievement.class);
        String validRes = validMyEntityBeforeSave(update);
        if (Objects.nonNull(validRes)) {
            throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST), validRes);
        }
        return baseMapper.updateById(update) > 0;
    }

    @Override
    public Boolean updateStuByBo(AchievementBo bo) {
        Achievement update = MapstructUtils.convert(bo, Achievement.class);
        String validRes = validStuEntityBeforeSave(update);
        if (Objects.nonNull(validRes)) {
            throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST), validRes);
        }
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private String validMyEntityBeforeSave(Achievement entity) {
        if (!Objects.equals(entity.getAchievementStudentId(), LoginHelper.getUserId())) {
            return "你不是第一作者，无法修改";
        }
        if (!StringUtils.equals(entity.getStatus(), "0")) {
            return "该数据已经审核完成，无法重复修改";
        }
        List<String> errorTeacherNames = new ArrayList<>();
        List<String> errorStudentNames = new ArrayList<>();
        Long achievementTeacherId = entity.getAchievementTeacherId();
        String achievementOtherTeacherIds = entity.getAchievementOtherTeacherIds();
        String achievementOtherStudentIds = entity.getAchievementOtherStudentIds();
        LoginUser userInfo = remoteUserService.getUserInfo(achievementTeacherId, TenantHelper.getTenantId());
        userInfo.getRoles().forEach(roleDTO -> {
            boolean isStudent = Objects.equals("本科生", roleDTO.getRoleName()) || Objects.equals("研究生", roleDTO.getRoleName());
            if (isStudent) {
                errorTeacherNames.add(userInfo.getNickname());
            }
        });
        if (StringUtils.isNotEmpty(achievementOtherTeacherIds)) {
            List<String> collect = Arrays.stream(achievementOtherTeacherIds.split(",")).toList();
            if (collect.contains(String.valueOf(achievementTeacherId))) {
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
        if (StringUtils.isNotEmpty(achievementOtherStudentIds)) {
            List<String> collect = Arrays.stream(achievementOtherStudentIds.split(",")).toList();
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

    private String validStuEntityBeforeSave(Achievement entity) {
        if (!Objects.equals(entity.getAchievementTeacherId(), LoginHelper.getUserId())) {
            return "你不是第一指导老师，无法修改";
        }
        Achievement achievement = baseMapper.selectById(entity.getAchievementId());
        if (!StringUtils.equals(achievement.getStatus(), "0")) {
            return "该数据已经审核完成，无法重复修改";
        }
        return null;
    }

    /**
     * 批量删除在校成果管理
     */
    @Override
    public Boolean deleteMyWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if (isValid) {
            List<AchievementVo> achievementVos = baseMapper.selectVoBatchIds(ids);
            for (AchievementVo achievementVo : achievementVos) {
                if (!Objects.equals(achievementVo.getAchievementStudentId(), LoginHelper.getUserId())) {
                    throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST), "你不是第一作者，无法删除");
                }
                if (StringUtils.equals(achievementVo.getStatus(), "0")) {
                    throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST), "成果还未审核，无法删除");
                }
                if (StringUtils.equals(achievementVo.getStatus(), "1")) {
                    throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST), "成果审核通过，已存档，无法删除");
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

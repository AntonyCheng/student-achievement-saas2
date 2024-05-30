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
import top.sharehome.base.api.RemoteHonorTypeService;
import top.sharehome.business.domain.Honor;
import top.sharehome.business.domain.bo.HonorBo;
import top.sharehome.business.domain.vo.HonorVo;
import top.sharehome.business.mapper.HonorMapper;
import top.sharehome.business.service.IHonorService;

import java.util.*;

/**
 * 在校荣誉管理Service业务层处理
 *
 * @author AntonyCheng
 * @date 2024-05-27
 */
@RequiredArgsConstructor
@Service
public class HonorServiceImpl implements IHonorService {

    private final HonorMapper baseMapper;

    @DubboReference
    private final RemoteUserService remoteUserService;

    @DubboReference
    private final RemoteDeptService remoteDeptService;

    @DubboReference
    private final RemoteHonorTypeService remoteHonorTypeService;

    /**
     * 查询在校荣誉管理
     */
    @Override
    public HonorVo queryById(Long honorId) {
        HonorVo honorVo = baseMapper.selectVoById(honorId);
        honorVo.setHonorTypeName(remoteHonorTypeService.queryHonorTypeNameById(honorVo.getHonorTypeId()));
        honorVo.setHonorStudentDeptName(remoteDeptService.selectDeptNameByIds(honorVo.getHonorStudentDeptId().toString()));
        honorVo.setHonorStudentName(remoteUserService.selectNicknameById(honorVo.getHonorStudentId()));
        honorVo.setHonorTeacherName(remoteUserService.selectNicknameById(honorVo.getHonorTeacherId()));
        if (StringUtils.isNotEmpty(honorVo.getHonorOtherStudentIds())) {
            String[] split = honorVo.getHonorOtherStudentIds().split(",");
            List<String> nameList = new ArrayList<>();
            for (String s : split) {
                nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
            }
            honorVo.setHonorOtherStudentNames(String.join(",", nameList));
        }
        if (StringUtils.isNotEmpty(honorVo.getHonorOtherTeacherIds())) {
            String[] split = honorVo.getHonorOtherTeacherIds().split(",");
            List<String> nameList = new ArrayList<>();
            for (String s : split) {
                nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
            }
            honorVo.setHonorOtherTeacherNames(String.join(",", nameList));
        }
        return honorVo;
    }

    /**
     * 查询在校荣誉管理列表
     */
    @Override
    public TableDataInfo<HonorVo> queryMyPageList(HonorBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<Honor> lqw = buildMyQueryWrapper(bo);
        Page<HonorVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        result.getRecords().forEach(honorVo -> {
            honorVo.setHonorTypeName(remoteHonorTypeService.queryHonorTypeNameById(honorVo.getHonorTypeId()));
            honorVo.setHonorStudentDeptName(remoteDeptService.selectDeptNameByIds(honorVo.getHonorStudentDeptId().toString()));
            honorVo.setHonorStudentName(remoteUserService.selectNicknameById(honorVo.getHonorStudentId()));
            honorVo.setHonorTeacherName(remoteUserService.selectNicknameById(honorVo.getHonorTeacherId()));
            if (StringUtils.isNotEmpty(honorVo.getHonorOtherStudentIds())) {
                String[] split = honorVo.getHonorOtherStudentIds().split(",");
                List<String> nameList = new ArrayList<>();
                for (String s : split) {
                    nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
                }
                honorVo.setHonorOtherStudentNames(String.join(",", nameList));
            }
            if (StringUtils.isNotEmpty(honorVo.getHonorOtherTeacherIds())) {
                String[] split = honorVo.getHonorOtherTeacherIds().split(",");
                List<String> nameList = new ArrayList<>();
                for (String s : split) {
                    nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
                }
                honorVo.setHonorOtherTeacherNames(String.join(",", nameList));
            }
        });
        return TableDataInfo.build(result);
    }

    @Override
    public TableDataInfo<HonorVo> queryStuPageList(HonorBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<Honor> lqw = buildStuQueryWrapper(bo);
        Page<HonorVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        result.getRecords().forEach(honorVo -> {
            honorVo.setHonorTypeName(remoteHonorTypeService.queryHonorTypeNameById(honorVo.getHonorTypeId()));
            honorVo.setHonorStudentDeptName(remoteDeptService.selectDeptNameByIds(honorVo.getHonorStudentDeptId().toString()));
            honorVo.setHonorStudentName(remoteUserService.selectNicknameById(honorVo.getHonorStudentId()));
            honorVo.setHonorTeacherName(remoteUserService.selectNicknameById(honorVo.getHonorTeacherId()));
            if (StringUtils.isNotEmpty(honorVo.getHonorOtherStudentIds())) {
                String[] split = honorVo.getHonorOtherStudentIds().split(",");
                List<String> nameList = new ArrayList<>();
                for (String s : split) {
                    nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
                }
                honorVo.setHonorOtherStudentNames(String.join(",", nameList));
            }
            if (StringUtils.isNotEmpty(honorVo.getHonorOtherTeacherIds())) {
                String[] split = honorVo.getHonorOtherTeacherIds().split(",");
                List<String> nameList = new ArrayList<>();
                for (String s : split) {
                    nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
                }
                honorVo.setHonorOtherTeacherNames(String.join(",", nameList));
            }
        });
        return TableDataInfo.build(result);
    }

    @Override
    public TableDataInfo<HonorVo> queryPageList(HonorBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<Honor> lqw = buildQueryWrapper(bo);
        Page<HonorVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        result.getRecords().forEach(honorVo -> {
            honorVo.setHonorTypeName(remoteHonorTypeService.queryHonorTypeNameById(honorVo.getHonorTypeId()));
            honorVo.setHonorStudentDeptName(remoteDeptService.selectDeptNameByIds(honorVo.getHonorStudentDeptId().toString()));
            honorVo.setHonorStudentName(remoteUserService.selectNicknameById(honorVo.getHonorStudentId()));
            honorVo.setHonorTeacherName(remoteUserService.selectNicknameById(honorVo.getHonorTeacherId()));
            if (StringUtils.isNotEmpty(honorVo.getHonorOtherStudentIds())) {
                String[] split = honorVo.getHonorOtherStudentIds().split(",");
                List<String> nameList = new ArrayList<>();
                for (String s : split) {
                    nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
                }
                honorVo.setHonorOtherStudentNames(String.join(",", nameList));
            }
            if (StringUtils.isNotEmpty(honorVo.getHonorOtherTeacherIds())) {
                String[] split = honorVo.getHonorOtherTeacherIds().split(",");
                List<String> nameList = new ArrayList<>();
                for (String s : split) {
                    nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
                }
                honorVo.setHonorOtherTeacherNames(String.join(",", nameList));
            }
        });
        return TableDataInfo.build(result);
    }

    /**
     * 查询在校荣誉管理列表
     */
    @Override
    public List<HonorVo> queryMyList(HonorBo bo) {
        LambdaQueryWrapper<Honor> lqw = buildMyQueryWrapper(bo);
        List<HonorVo> honorVos = baseMapper.selectVoList(lqw).stream().filter(honorVo -> StringUtils.equals(honorVo.getStatus(), "1")).toList();
        honorVos.forEach(honorVo -> {
            honorVo.setHonorTypeName(remoteHonorTypeService.queryHonorTypeNameById(honorVo.getHonorTypeId()));
            honorVo.setHonorStudentDeptName(remoteDeptService.selectDeptNameByIds(honorVo.getHonorStudentDeptId().toString()));
            honorVo.setHonorStudentName(remoteUserService.selectNicknameById(honorVo.getHonorStudentId()));
            honorVo.setHonorTeacherName(remoteUserService.selectNicknameById(honorVo.getHonorTeacherId()));
            if (StringUtils.isNotEmpty(honorVo.getHonorOtherStudentIds())) {
                String[] split = honorVo.getHonorOtherStudentIds().split(",");
                List<String> nameList = new ArrayList<>();
                for (String s : split) {
                    nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
                }
                honorVo.setHonorOtherStudentNames(String.join(",", nameList));
            }
            if (StringUtils.isNotEmpty(honorVo.getHonorOtherTeacherIds())) {
                String[] split = honorVo.getHonorOtherTeacherIds().split(",");
                List<String> nameList = new ArrayList<>();
                for (String s : split) {
                    nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
                }
                honorVo.setHonorOtherTeacherNames(String.join(",", nameList));
            }
        });
        return honorVos;
    }

    @Override
    public List<HonorVo> queryStuList(HonorBo bo) {
        LambdaQueryWrapper<Honor> lqw = buildStuQueryWrapper(bo);
        List<HonorVo> honorVos = baseMapper.selectVoList(lqw);
        honorVos.forEach(honorVo -> {
            honorVo.setHonorTypeName(remoteHonorTypeService.queryHonorTypeNameById(honorVo.getHonorTypeId()));
            honorVo.setHonorStudentDeptName(remoteDeptService.selectDeptNameByIds(honorVo.getHonorStudentDeptId().toString()));
            honorVo.setHonorStudentName(remoteUserService.selectNicknameById(honorVo.getHonorStudentId()));
            honorVo.setHonorTeacherName(remoteUserService.selectNicknameById(honorVo.getHonorTeacherId()));
            if (StringUtils.isNotEmpty(honorVo.getHonorOtherStudentIds())) {
                String[] split = honorVo.getHonorOtherStudentIds().split(",");
                List<String> nameList = new ArrayList<>();
                for (String s : split) {
                    nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
                }
                honorVo.setHonorOtherStudentNames(String.join(",", nameList));
            }
            if (StringUtils.isNotEmpty(honorVo.getHonorOtherTeacherIds())) {
                String[] split = honorVo.getHonorOtherTeacherIds().split(",");
                List<String> nameList = new ArrayList<>();
                for (String s : split) {
                    nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
                }
                honorVo.setHonorOtherTeacherNames(String.join(",", nameList));
            }
        });
        return honorVos;
    }

    @Override
    public List<HonorVo> queryList(HonorBo bo) {
        LambdaQueryWrapper<Honor> lqw = buildQueryWrapper(bo);
        List<HonorVo> honorVos = baseMapper.selectVoList(lqw);
        honorVos.forEach(honorVo -> {
            honorVo.setHonorTypeName(remoteHonorTypeService.queryHonorTypeNameById(honorVo.getHonorTypeId()));
            honorVo.setHonorStudentDeptName(remoteDeptService.selectDeptNameByIds(honorVo.getHonorStudentDeptId().toString()));
            honorVo.setHonorStudentName(remoteUserService.selectNicknameById(honorVo.getHonorStudentId()));
            honorVo.setHonorTeacherName(remoteUserService.selectNicknameById(honorVo.getHonorTeacherId()));
            if (StringUtils.isNotEmpty(honorVo.getHonorOtherStudentIds())) {
                String[] split = honorVo.getHonorOtherStudentIds().split(",");
                List<String> nameList = new ArrayList<>();
                for (String s : split) {
                    nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
                }
                honorVo.setHonorOtherStudentNames(String.join(",", nameList));
            }
            if (StringUtils.isNotEmpty(honorVo.getHonorOtherTeacherIds())) {
                String[] split = honorVo.getHonorOtherTeacherIds().split(",");
                List<String> nameList = new ArrayList<>();
                for (String s : split) {
                    nameList.add(remoteUserService.selectNicknameById(Long.valueOf(s)));
                }
                honorVo.setHonorOtherTeacherNames(String.join(",", nameList));
            }
        });
        return honorVos;
    }

    private LambdaQueryWrapper<Honor> buildMyQueryWrapper(HonorBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<Honor> lqw = Wrappers.lambdaQuery();
        lqw.
            and(qw -> {
                qw.eq(Honor::getHonorStudentId, LoginHelper.getUserId())
                    .or()
                    .like(Honor::getHonorOtherStudentIds, LoginHelper.getUserId());
            })
            .and(ObjectUtils.anyNotNull(bo.getHonorTypeId(), bo.getHonorName(), bo.getHonorTeacherId(), bo.getHonorOtherStudentIds(), bo.getHonorOtherTeacherIds()),
                qw -> {
                    qw.eq(bo.getHonorTypeId() != null, Honor::getHonorTypeId, bo.getHonorTypeId());
                    qw.eq(bo.getHonorStudentDeptId() != null, Honor::getHonorStudentDeptId, bo.getHonorStudentDeptId());
                    qw.eq(bo.getHonorTeacherId() != null, Honor::getHonorTeacherId, bo.getHonorTeacherId());
                    qw.like(bo.getHonorName() != null, Honor::getHonorName, bo.getHonorName());
                    if (StringUtils.isNotBlank(bo.getHonorOtherStudentIds())) {
                        String[] split = bo.getHonorOtherStudentIds().split(",");
                        if (split.length == 1) {
                            qw.like(Honor::getHonorOtherStudentIds, bo.getHonorOtherStudentIds());
                        } else {
                            for (String s : split) {
                                qw.like(Honor::getHonorOtherStudentIds, s);
                            }
                        }
                    }
                    if (StringUtils.isNotBlank(bo.getHonorOtherTeacherIds())) {
                        String[] split = bo.getHonorOtherTeacherIds().split(",");
                        if (split.length == 1) {
                            qw.like(Honor::getHonorOtherTeacherIds, bo.getHonorOtherTeacherIds());
                        } else {
                            for (String s : split) {
                                qw.like(Honor::getHonorOtherTeacherIds, s);
                            }
                        }
                    }
                    qw.eq(StringUtils.isNotBlank(bo.getStatus()), Honor::getStatus, bo.getStatus());
                });
        return lqw;
    }

    private LambdaQueryWrapper<Honor> buildStuQueryWrapper(HonorBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<Honor> lqw = Wrappers.lambdaQuery();
        lqw.eq(Honor::getHonorTeacherId, LoginHelper.getUserId())
            .and(ObjectUtils.anyNotNull(bo.getHonorTypeId(), bo.getHonorName(), bo.getHonorStudentId(), bo.getHonorOtherStudentIds(), bo.getHonorOtherTeacherIds()),
                qw -> {
                    qw.eq(bo.getHonorTypeId() != null, Honor::getHonorTypeId, bo.getHonorTypeId());
                    qw.eq(bo.getHonorStudentDeptId() != null, Honor::getHonorStudentDeptId, bo.getHonorStudentDeptId());
                    qw.eq(bo.getHonorStudentId() != null, Honor::getHonorStudentId, bo.getHonorStudentId());
                    qw.like(bo.getHonorName() != null, Honor::getHonorName, bo.getHonorName());
                    if (StringUtils.isNotBlank(bo.getHonorOtherStudentIds())) {
                        String[] split = bo.getHonorOtherStudentIds().split(",");
                        if (split.length == 1) {
                            qw.like(Honor::getHonorOtherStudentIds, bo.getHonorOtherStudentIds());
                        } else {
                            for (String s : split) {
                                qw.like(Honor::getHonorOtherStudentIds, s);
                            }
                        }
                    }
                    if (StringUtils.isNotBlank(bo.getHonorOtherTeacherIds())) {
                        String[] split = bo.getHonorOtherTeacherIds().split(",");
                        if (split.length == 1) {
                            qw.like(Honor::getHonorOtherTeacherIds, bo.getHonorOtherTeacherIds());
                        } else {
                            for (String s : split) {
                                qw.like(Honor::getHonorOtherTeacherIds, s);
                            }
                        }
                    }
                    qw.eq(StringUtils.isNotBlank(bo.getStatus()), Honor::getStatus, bo.getStatus());
                });
        return lqw;
    }

    private LambdaQueryWrapper<Honor> buildQueryWrapper(HonorBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<Honor> lqw = Wrappers.lambdaQuery();
        lqw.and(ObjectUtils.anyNotNull(bo.getHonorTypeId(), bo.getHonorName(), bo.getHonorStudentId(), bo.getHonorTeacherId(), bo.getHonorOtherStudentIds(), bo.getHonorOtherTeacherIds()),
            qw -> {
                qw.eq(bo.getHonorTypeId() != null, Honor::getHonorTypeId, bo.getHonorTypeId());
                qw.eq(bo.getHonorStudentId() != null, Honor::getHonorStudentId, bo.getHonorStudentId());
                qw.eq(bo.getHonorStudentDeptId() != null, Honor::getHonorStudentDeptId, bo.getHonorStudentDeptId());
                qw.eq(bo.getHonorTeacherId() != null, Honor::getHonorTeacherId, bo.getHonorTeacherId());
                qw.like(bo.getHonorName() != null, Honor::getHonorName, bo.getHonorName());
                if (StringUtils.isNotBlank(bo.getHonorOtherStudentIds())) {
                    String[] split = bo.getHonorOtherStudentIds().split(",");
                    if (split.length == 1) {
                        qw.like(Honor::getHonorOtherStudentIds, bo.getHonorOtherStudentIds());
                    } else {
                        for (String s : split) {
                            qw.like(Honor::getHonorOtherStudentIds, s);
                        }
                    }
                }
                if (StringUtils.isNotBlank(bo.getHonorOtherTeacherIds())) {
                    String[] split = bo.getHonorOtherTeacherIds().split(",");
                    if (split.length == 1) {
                        qw.like(Honor::getHonorOtherTeacherIds, bo.getHonorOtherTeacherIds());
                    } else {
                        for (String s : split) {
                            qw.like(Honor::getHonorOtherTeacherIds, s);
                        }
                    }
                }
                qw.eq(StringUtils.isNotBlank(bo.getStatus()), Honor::getStatus, bo.getStatus());
            });
        return lqw;
    }

    /**
     * 新增在校荣誉管理
     */
    @Override
    public Boolean insertByBo(HonorBo bo) {
        Honor add = MapstructUtils.convert(bo, Honor.class);
        LoginUser loginUser = LoginHelper.getLoginUser();
        add.setHonorStudentId(loginUser.getUserId());
        add.setHonorStudentDeptId(loginUser.getDeptId());
        String validRes = validMyEntityBeforeSave(add);
        if (Objects.nonNull(validRes)) {
            throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST), validRes);
        }
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setHonorId(add.getHonorId());
        }
        return flag;
    }

    /**
     * 修改在校荣誉管理
     */
    @Override
    public Boolean updateMyByBo(HonorBo bo) {
        Honor update = MapstructUtils.convert(bo, Honor.class);
        String validRes = validMyEntityBeforeSave(update);
        if (Objects.nonNull(validRes)) {
            throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST), validRes);
        }
        return baseMapper.updateById(update) > 0;
    }

    @Override
    public Boolean updateStuByBo(HonorBo bo) {
        Honor update = MapstructUtils.convert(bo, Honor.class);
        String validRes = validStuEntityBeforeSave(update);
        if (Objects.nonNull(validRes)) {
            throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST), validRes);
        }
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     */
    private String validMyEntityBeforeSave(Honor entity) {
        if (!Objects.equals(entity.getHonorStudentId(), LoginHelper.getUserId())) {
            return "你不是第一作者，无法修改";
        }
        if (Objects.nonNull(entity.getStatus()) && !StringUtils.equals(entity.getStatus(), "0")) {
            return "该数据已经审核完成，无法重复修改";
        }
        List<String> errorTeacherNames = new ArrayList<>();
        List<String> errorStudentNames = new ArrayList<>();
        Long honorTeacherId = entity.getHonorTeacherId();
        String honorOtherTeacherIds = entity.getHonorOtherTeacherIds();
        String honorOtherStudentIds = entity.getHonorOtherStudentIds();
        LoginUser userInfo = remoteUserService.getUserInfo(honorTeacherId, TenantHelper.getTenantId());
        userInfo.getRoles().forEach(roleDTO -> {
            boolean isStudent = Objects.equals("本科生", roleDTO.getRoleName()) || Objects.equals("研究生", roleDTO.getRoleName());
            if (isStudent) {
                errorTeacherNames.add(userInfo.getNickname());
            }
        });
        if (StringUtils.isNotEmpty(honorOtherTeacherIds)) {
            List<String> collect = Arrays.stream(honorOtherTeacherIds.split(",")).toList();
            if (collect.contains(String.valueOf(honorTeacherId))) {
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
        if (StringUtils.isNotEmpty(honorOtherStudentIds)) {
            List<String> collect = Arrays.stream(honorOtherStudentIds.split(",")).toList();
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

    private String validStuEntityBeforeSave(Honor entity) {
        if (!Objects.equals(entity.getHonorTeacherId(), LoginHelper.getUserId())) {
            return "你不是第一指导老师，无法修改";
        }
        Honor honor = baseMapper.selectById(entity.getHonorId());
        if (Objects.nonNull(entity.getStatus()) && !StringUtils.equals(honor.getStatus(), "0")) {
            return "该数据已经审核完成，无法重复修改";
        }
        return null;
    }

    /**
     * 批量删除在校荣誉管理
     */
    @Override
    public Boolean deleteMyWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if (isValid) {
            List<HonorVo> honorVos = baseMapper.selectVoBatchIds(ids);
            for (HonorVo honorVo : honorVos) {
                if (!Objects.equals(honorVo.getHonorStudentId(), LoginHelper.getUserId())) {
                    throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST), "你不是第一作者，无法删除");
                }
                if (StringUtils.equals(honorVo.getStatus(), "0")) {
                    throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST), "荣誉还未审核，无法删除");
                }
                if (StringUtils.equals(honorVo.getStatus(), "1")) {
                    throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST), "荣誉审核通过，已存档，无法删除");
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

package org.dromara.system.controller.system;

import cn.dev33.satoken.annotation.SaCheckPermission;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.constant.UserConstants;
import org.dromara.common.core.domain.R;
import org.dromara.common.excel.utils.ExcelUtil;
import org.dromara.common.log.annotation.Log;
import org.dromara.common.log.enums.BusinessType;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.web.core.BaseController;
import org.dromara.system.domain.bo.SysDictDataBo;
import org.dromara.system.domain.bo.SysPostBo;
import org.dromara.system.domain.vo.SysDictDataVo;
import org.dromara.system.domain.vo.SysPostVo;
import org.dromara.system.service.ISysDictDataService;
import org.dromara.system.service.ISysPostService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 岗位信息操作处理
 *
 * @author Lion Li
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class SysPostController extends BaseController {

    private final ISysPostService postService;
    private final ISysDictDataService dictDataService;

    /**
     * 获取岗位列表
     */
    @SaCheckPermission("system:post:list")
    @GetMapping("/list")
    public TableDataInfo<SysPostVo> list(SysPostBo post, PageQuery pageQuery) {
        return postService.selectPagePostList(post, pageQuery);
    }

    /**
     * 导出岗位列表
     */
    @Log(title = "岗位管理", businessType = BusinessType.EXPORT)
    @SaCheckPermission("system:post:export")
    @PostMapping("/export")
    public void export(SysPostBo post, HttpServletResponse response) {
        List<SysPostVo> list = postService.selectPostList(post);
        ExcelUtil.exportExcel(list, "岗位数据", SysPostVo.class, response);
    }

    /**
     * 根据岗位编号获取详细信息
     *
     * @param postId 岗位ID
     */
    @SaCheckPermission("system:post:query")
    @GetMapping(value = "/{postId}")
    public R<SysPostVo> getInfo(@PathVariable Long postId) {
        return R.ok(postService.selectPostById(postId));
    }

    /**
     * 新增岗位
     */
    @SaCheckPermission("system:post:add")
    @Log(title = "岗位管理", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@Validated @RequestBody SysPostBo post) {
        if (!postService.checkPostNameUnique(post)) {
            return R.fail("新增岗位'" + post.getPostName() + "'失败，岗位名称已存在");
        } else if (!postService.checkPostCodeUnique(post)) {
            return R.fail("新增岗位'" + post.getPostName() + "'失败，岗位编码已存在");
        }
        SysDictDataBo bo = new SysDictDataBo();
        bo.setDictType("sys_post_type");
        bo.setDictSort(0);
        bo.setDictLabel(post.getPostName());
        bo.setDictValue(post.getPostCode());
        bo.setListClass("default");
        bo.setRemark(post.getRemark());
        dictDataService.insertDictData(bo);
        return toAjax(postService.insertPost(post));
    }

    /**
     * 修改岗位
     */
    @SaCheckPermission("system:post:edit")
    @Log(title = "岗位管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@Validated @RequestBody SysPostBo post) {
        if (!postService.checkPostNameUnique(post)) {
            return R.fail("修改岗位'" + post.getPostName() + "'失败，岗位名称已存在");
        } else if (!postService.checkPostCodeUnique(post)) {
            return R.fail("修改岗位'" + post.getPostName() + "'失败，岗位编码已存在");
        } else if (UserConstants.POST_DISABLE.equals(post.getStatus())
            && postService.countUserPostById(post.getPostId()) > 0) {
            return R.fail("该岗位下存在已分配用户，不能禁用!");
        }
        SysPostVo sysPostVo = postService.selectPostById(post.getPostId());
        SysDictDataVo sysDictDataVo = dictDataService.selectDictDataByLabelAndValue(sysPostVo.getPostName(), sysPostVo.getPostCode());
        SysDictDataBo bo = new SysDictDataBo();
        bo.setDictCode(sysDictDataVo.getDictCode());
        bo.setDictType("sys_post_type");
        bo.setDictLabel(post.getPostName());
        bo.setDictValue(post.getPostCode());
        bo.setRemark(post.getRemark());
        dictDataService.updateDictData(bo);
        return toAjax(postService.updatePost(post));
    }

    /**
     * 删除岗位
     *
     * @param postIds 岗位ID串
     */
    @SaCheckPermission("system:post:remove")
    @Log(title = "岗位管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{postIds}")
    public R<Void> remove(@PathVariable Long[] postIds) {
        SysDictDataBo dictData = new SysDictDataBo();
        dictData.setDictType("sys_post_type");
        List<SysDictDataVo> sysDictDataVos = dictDataService.selectDictDataList(dictData);
        Long[] codes = new Long[postIds.length];
        int i = 0;
        for (Long postId : postIds) {
            SysPostVo sysPostVo = postService.selectPostById(postId);
            for (SysDictDataVo sysDictDataVo : sysDictDataVos) {
                if (sysDictDataVo.getDictValue().equals(sysPostVo.getPostCode())) {
                    codes[i++] = sysDictDataVo.getDictCode();
                }
            }
        }
        dictDataService.deleteDictDataByIds(codes);
        return toAjax(postService.deletePostByIds(postIds));
    }

    /**
     * 获取岗位选择框列表
     */
    @GetMapping("/optionselect")
    public R<List<SysPostVo>> optionselect() {
        SysPostBo postBo = new SysPostBo();
        postBo.setStatus(UserConstants.POST_NORMAL);
        List<SysPostVo> posts = postService.selectPostList(postBo);
        return R.ok(posts);
    }
}

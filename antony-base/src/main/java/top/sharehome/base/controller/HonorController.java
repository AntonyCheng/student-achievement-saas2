package top.sharehome.base.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.dromara.common.idempotent.annotation.RepeatSubmit;
import org.dromara.common.log.annotation.Log;
import org.dromara.common.web.core.BaseController;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.core.domain.R;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.log.enums.BusinessType;
import org.dromara.common.excel.utils.ExcelUtil;
import top.sharehome.base.domain.vo.HonorVo;
import top.sharehome.base.domain.bo.HonorBo;
import top.sharehome.base.service.IHonorService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 荣誉类型
 * 前端访问路由地址为:/base/honor
 *
 * @author AntonyCheng
 * @date 2024-04-15
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/honor")
public class HonorController extends BaseController {

    private final IHonorService honorService;

    /**
     * 查询荣誉类型列表
     */
    @SaCheckPermission("base:honor:list")
    @GetMapping("/list")
    public TableDataInfo<HonorVo> list(HonorBo bo, PageQuery pageQuery) {
        return honorService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出荣誉类型列表
     */
    @SaCheckPermission("base:honor:export")
    @Log(title = "荣誉类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HonorBo bo, HttpServletResponse response) {
        List<HonorVo> list = honorService.queryList(bo);
        ExcelUtil.exportExcel(list, "荣誉类型", HonorVo.class, response);
    }

    /**
     * 获取荣誉类型详细信息
     *
     * @param honorId 主键
     */
    @SaCheckPermission("base:honor:query")
    @GetMapping("/{honorId}")
    public R<HonorVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long honorId) {
        return R.ok(honorService.queryById(honorId));
    }

    /**
     * 新增荣誉类型
     */
    @SaCheckPermission("base:honor:add")
    @Log(title = "荣誉类型", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody HonorBo bo) {
        return toAjax(honorService.insertByBo(bo));
    }

    /**
     * 修改荣誉类型
     */
    @SaCheckPermission("base:honor:edit")
    @Log(title = "荣誉类型", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody HonorBo bo) {
        return toAjax(honorService.updateByBo(bo));
    }

    /**
     * 删除荣誉类型
     *
     * @param honorIds 主键串
     */
    @SaCheckPermission("base:honor:remove")
    @Log(title = "荣誉类型", businessType = BusinessType.DELETE)
    @DeleteMapping("/{honorIds}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] honorIds) {
        return toAjax(honorService.deleteWithValidByIds(List.of(honorIds), true));
    }
}

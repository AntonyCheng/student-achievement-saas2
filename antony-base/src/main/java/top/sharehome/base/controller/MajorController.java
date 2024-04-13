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
import top.sharehome.base.domain.vo.MajorVo;
import top.sharehome.base.domain.bo.MajorBo;
import top.sharehome.base.service.IMajorService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 专业
 * 前端访问路由地址为:/base/major
 *
 * @author AntonyCheng
 * @date 2024-04-13
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/major")
public class MajorController extends BaseController {

    private final IMajorService majorService;

    /**
     * 查询专业列表
     */
    @SaCheckPermission("base:major:list")
    @GetMapping("/list")
    public TableDataInfo<MajorVo> list(MajorBo bo, PageQuery pageQuery) {
        return majorService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出专业列表
     */
    @SaCheckPermission("base:major:export")
    @Log(title = "专业", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(MajorBo bo, HttpServletResponse response) {
        List<MajorVo> list = majorService.queryList(bo);
        ExcelUtil.exportExcel(list, "专业", MajorVo.class, response);
    }

    /**
     * 获取专业详细信息
     *
     * @param majorId 主键
     */
    @SaCheckPermission("base:major:query")
    @GetMapping("/{majorId}")
    public R<MajorVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long majorId) {
        return R.ok(majorService.queryById(majorId));
    }

    /**
     * 新增专业
     */
    @SaCheckPermission("base:major:add")
    @Log(title = "专业", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody MajorBo bo) {
        return toAjax(majorService.insertByBo(bo));
    }

    /**
     * 修改专业
     */
    @SaCheckPermission("base:major:edit")
    @Log(title = "专业", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody MajorBo bo) {
        return toAjax(majorService.updateByBo(bo));
    }

    /**
     * 删除专业
     *
     * @param majorIds 主键串
     */
    @SaCheckPermission("base:major:remove")
    @Log(title = "专业", businessType = BusinessType.DELETE)
    @DeleteMapping("/{majorIds}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] majorIds) {
        return toAjax(majorService.deleteWithValidByIds(List.of(majorIds), true));
    }
}

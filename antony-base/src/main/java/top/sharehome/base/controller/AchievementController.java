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
import top.sharehome.base.domain.vo.AchievementVo;
import top.sharehome.base.domain.bo.AchievementBo;
import top.sharehome.base.service.IAchievementService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 成果类型
 * 前端访问路由地址为:/base/achievement
 *
 * @author AntonyCheng
 * @date 2024-04-15
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/achievement")
public class AchievementController extends BaseController {

    private final IAchievementService achievementService;

    /**
     * 查询成果类型列表
     */
    @SaCheckPermission("base:achievement:list")
    @GetMapping("/list")
    public TableDataInfo<AchievementVo> list(AchievementBo bo, PageQuery pageQuery) {
        return achievementService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出成果类型列表
     */
    @SaCheckPermission("base:achievement:export")
    @Log(title = "成果类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(AchievementBo bo, HttpServletResponse response) {
        List<AchievementVo> list = achievementService.queryList(bo);
        ExcelUtil.exportExcel(list, "成果类型", AchievementVo.class, response);
    }

    /**
     * 获取成果类型详细信息
     *
     * @param achievementId 主键
     */
    @SaCheckPermission("base:achievement:query")
    @GetMapping("/{achievementId}")
    public R<AchievementVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long achievementId) {
        return R.ok(achievementService.queryById(achievementId));
    }

    /**
     * 新增成果类型
     */
    @SaCheckPermission("base:achievement:add")
    @Log(title = "成果类型", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody AchievementBo bo) {
        return toAjax(achievementService.insertByBo(bo));
    }

    /**
     * 修改成果类型
     */
    @SaCheckPermission("base:achievement:edit")
    @Log(title = "成果类型", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody AchievementBo bo) {
        return toAjax(achievementService.updateByBo(bo));
    }

    /**
     * 删除成果类型
     *
     * @param achievementIds 主键串
     */
    @SaCheckPermission("base:achievement:remove")
    @Log(title = "成果类型", businessType = BusinessType.DELETE)
    @DeleteMapping("/{achievementIds}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] achievementIds) {
        return toAjax(achievementService.deleteWithValidByIds(List.of(achievementIds), true));
    }
}

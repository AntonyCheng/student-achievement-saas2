package top.sharehome.base.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.*;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.dromara.common.core.constant.UserConstants;
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
import top.sharehome.base.domain.bo.AchievementBo;
import top.sharehome.base.domain.vo.AchievementVo;
import top.sharehome.base.domain.vo.CompetitionVo;
import top.sharehome.base.domain.bo.CompetitionBo;
import top.sharehome.base.service.ICompetitionService;
import org.dromara.common.mybatis.core.page.TableDataInfo;

/**
 * 竞赛类型
 * 前端访问路由地址为:/base/competition
 *
 * @author AntonyCheng
 * @date 2024-04-15
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/competition")
public class CompetitionController extends BaseController {

    private final ICompetitionService competitionService;

    /**
     * 查询竞赛类型列表
     */
    @SaCheckPermission("base:competition:list")
    @GetMapping("/list")
    public TableDataInfo<CompetitionVo> list(CompetitionBo bo, PageQuery pageQuery) {
        return competitionService.queryPageList(bo, pageQuery);
    }

    /**
     * 查询有效竞赛类型列表
     */
    @SaCheckPermission("base:competition:list")
    @GetMapping("/list/available")
    public R<List<CompetitionVo>> listAvailable(){
        CompetitionBo bo = new CompetitionBo();
        bo.setStatus(UserConstants.COMPETITION_NORMAL);
        return R.ok(competitionService.queryList(bo));
    }

    /**
     * 导出竞赛类型列表
     */
    @SaCheckPermission("base:competition:export")
    @Log(title = "竞赛类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(CompetitionBo bo, HttpServletResponse response) {
        List<CompetitionVo> list = competitionService.queryList(bo);
        ExcelUtil.exportExcel(list, "竞赛类型", CompetitionVo.class, response);
    }

    /**
     * 获取竞赛类型详细信息
     *
     * @param competitionId 主键
     */
    @SaCheckPermission("base:competition:query")
    @GetMapping("/{competitionId}")
    public R<CompetitionVo> getInfo(@NotNull(message = "主键不能为空")
                                     @PathVariable Long competitionId) {
        return R.ok(competitionService.queryById(competitionId));
    }

    /**
     * 新增竞赛类型
     */
    @SaCheckPermission("base:competition:add")
    @Log(title = "竞赛类型", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody CompetitionBo bo) {
        return toAjax(competitionService.insertByBo(bo));
    }

    /**
     * 修改竞赛类型
     */
    @SaCheckPermission("base:competition:edit")
    @Log(title = "竞赛类型", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody CompetitionBo bo) {
        return toAjax(competitionService.updateByBo(bo));
    }

    /**
     * 删除竞赛类型
     *
     * @param competitionIds 主键串
     */
    @SaCheckPermission("base:competition:remove")
    @Log(title = "竞赛类型", businessType = BusinessType.DELETE)
    @DeleteMapping("/{competitionIds}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] competitionIds) {
        return toAjax(competitionService.deleteWithValidByIds(List.of(competitionIds), true));
    }
}

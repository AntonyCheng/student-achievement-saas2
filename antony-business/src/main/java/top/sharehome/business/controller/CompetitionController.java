package top.sharehome.business.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.hutool.core.io.FileUtil;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboReference;
import org.dromara.common.core.domain.R;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.core.utils.file.MimeTypeUtils;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.excel.utils.ExcelUtil;
import org.dromara.common.idempotent.annotation.RepeatSubmit;
import org.dromara.common.log.annotation.Log;
import org.dromara.common.log.enums.BusinessType;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.common.web.core.BaseController;
import org.dromara.resource.api.RemoteFileService;
import org.dromara.resource.api.domain.RemoteFile;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.sharehome.business.domain.bo.CompetitionBo;
import top.sharehome.business.domain.vo.CompetitionVo;
import top.sharehome.business.service.ICompetitionService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 在校竞赛管理
 * 前端访问路由地址为:/business/competition
 *
 * @author AntonyCheng
 * @date 2024-05-27
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/competition")
public class CompetitionController extends BaseController {

    private final ICompetitionService competitionService;

    @DubboReference
    private final RemoteFileService remoteFileService;

    /**
     * 查询在校竞赛管理列表
     */
    @SaCheckPermission("business:myCompetition:list")
    @GetMapping("/my/list")
    public TableDataInfo<CompetitionVo> myList(CompetitionBo bo, PageQuery pageQuery) {
        return competitionService.queryMyPageList(bo, pageQuery);
    }

    @SaCheckPermission("business:stuCompetition:list")
    @GetMapping("/stu/list")
    public TableDataInfo<CompetitionVo> stuList(CompetitionBo bo, PageQuery pageQuery) {
        return competitionService.queryStuPageList(bo, pageQuery);
    }

    @SaCheckPermission("business:competition:list")
    @GetMapping("/list")
    public TableDataInfo<CompetitionVo> list(CompetitionBo bo, PageQuery pageQuery) {
        return competitionService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出在校竞赛管理列表
     */
    @SaCheckPermission("business:myCompetition:export")
    @Log(title = "在校竞赛管理", businessType = BusinessType.EXPORT)
    @PostMapping("/my/export")
    public void myExport(CompetitionBo bo, HttpServletResponse response) {
        List<CompetitionVo> list = competitionService.queryMyList(bo);
        ExcelUtil.exportExcel(list, "我的竞赛", CompetitionVo.class, response);
    }

    @SaCheckPermission("business:stuCompetition:export")
    @Log(title = "在校竞赛管理", businessType = BusinessType.EXPORT)
    @PostMapping("/stu/export")
    public void stuExport(CompetitionBo bo, HttpServletResponse response) {
        List<CompetitionVo> list = competitionService.queryStuList(bo);
        ExcelUtil.exportExcel(list, "学生竞赛", CompetitionVo.class, response);
    }

    @SaCheckPermission("business:competition:export")
    @Log(title = "在校竞赛管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(CompetitionBo bo, HttpServletResponse response) {
        List<CompetitionVo> list = competitionService.queryList(bo);
        ExcelUtil.exportExcel(list, "竞赛管理", CompetitionVo.class, response);
    }

    /**
     * 获取在校竞赛管理详细信息
     *
     * @param competitionId 主键
     */
    @SaCheckPermission("business:myCompetition:query")
    @GetMapping("/my/{competitionId}")
    public R<CompetitionVo> getMyInfo(@NotNull(message = "主键不能为空")
                                    @PathVariable Long competitionId) {
        return R.ok(competitionService.queryById(competitionId));
    }

    @SaCheckPermission("business:stuCompetition:query")
    @GetMapping("/stu/{competitionId}")
    public R<CompetitionVo> getStuInfo(@NotNull(message = "主键不能为空")
                                    @PathVariable Long competitionId) {
        return R.ok(competitionService.queryById(competitionId));
    }

    @SaCheckPermission("business:competition:query")
    @GetMapping("/{competitionId}")
    public R<CompetitionVo> getInfo(@NotNull(message = "主键不能为空")
                                       @PathVariable Long competitionId) {
        return R.ok(competitionService.queryById(competitionId));
    }

    /**
     * 新增在校竞赛管理
     */
    @SaCheckPermission("business:myCompetition:add")
    @Log(title = "在校竞赛管理", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping("/my")
    public R<Void> add(@Validated(AddGroup.class) @RequestBody CompetitionBo bo) {
        return toAjax(competitionService.insertByBo(bo));
    }

    /**
     * 修改在校竞赛管理
     */
    @SaCheckPermission("business:myCompetition:edit")
    @Log(title = "在校竞赛管理", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping("/my")
    public R<Void> myEdit(@Validated(EditGroup.class) @RequestBody CompetitionBo bo) {
        return toAjax(competitionService.updateMyByBo(bo));
    }

    @SaCheckPermission("business:stuCompetition:edit")
    @Log(title = "在校竞赛管理", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping("/stu")
    public R<Void> stuEdit(@Validated(EditGroup.class) @RequestBody CompetitionBo bo) {
        return toAjax(competitionService.updateStuByBo(bo));
    }

    /**
     * 删除在校竞赛管理
     *
     * @param competitionIds 主键串
     */
    @SaCheckPermission("business:myCompetition:remove")
    @Log(title = "在校竞赛管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/my/{competitionIds}")
    public R<Void> removeMy(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] competitionIds) {
        return toAjax(competitionService.deleteMyWithValidByIds(List.of(competitionIds), true));
    }

    @SaCheckPermission("business:competition:remove")
    @Log(title = "在校竞赛管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{competitionIds}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] competitionIds) {
        return toAjax(competitionService.deleteWithValidByIds(List.of(competitionIds), true));
    }

    /**
     * 佐证材料上传
     *
     * @param file 佐证材料
     */
    @SaCheckPermission("business:myCompetition:edit")
    @Log(title = "佐证材料", businessType = BusinessType.UPDATE)
    @PostMapping(value = "/my/file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public R<String> file(@RequestPart("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            String extension = FileUtil.extName(file.getOriginalFilename());
            if (!StringUtils.equalsAnyIgnoreCase(extension, MimeTypeUtils.DEFAULT_ALLOWED_EXTENSION)) {
                return R.fail("文件格式不正确，请上传" + Arrays.toString(MimeTypeUtils.DEFAULT_ALLOWED_EXTENSION) + "格式");
            }
            RemoteFile oss = remoteFileService.upload(file.getName(), file.getOriginalFilename(), file.getContentType(), file.getBytes());
            String avatar = oss.getUrl();
            return R.ok(avatar);
        }
        return R.fail("上传图片异常，请联系管理员");
    }
}

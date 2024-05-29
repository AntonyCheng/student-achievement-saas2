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
import top.sharehome.business.domain.bo.AchievementBo;
import top.sharehome.business.domain.vo.AchievementVo;
import top.sharehome.business.service.IAchievementService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 在校成果管理
 * 前端访问路由地址为:/business/achievement
 *
 * @author AntonyCheng
 * @date 2024-05-27
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/achievement")
public class AchievementController extends BaseController {

    private final IAchievementService achievementService;

    @DubboReference
    private final RemoteFileService remoteFileService;

    /**
     * 查询在校成果管理列表
     */
    @SaCheckPermission("business:myAchievement:list")
    @GetMapping("/my/list")
    public TableDataInfo<AchievementVo> myList(AchievementBo bo, PageQuery pageQuery) {
        return achievementService.queryMyPageList(bo, pageQuery);
    }

    @SaCheckPermission("business:stuAchievement:list")
    @GetMapping("/stu/list")
    public TableDataInfo<AchievementVo> stuList(AchievementBo bo, PageQuery pageQuery) {
        return achievementService.queryStuPageList(bo, pageQuery);
    }

    @SaCheckPermission("business:achievement:list")
    @GetMapping("/list")
    public TableDataInfo<AchievementVo> list(AchievementBo bo, PageQuery pageQuery) {
        return achievementService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出在校成果管理列表
     */
    @SaCheckPermission("business:myAchievement:export")
    @Log(title = "在校成果管理", businessType = BusinessType.EXPORT)
    @PostMapping("/my/export")
    public void myExport(AchievementBo bo, HttpServletResponse response) {
        List<AchievementVo> list = achievementService.queryMyList(bo);
        ExcelUtil.exportExcel(list, "我的成果", AchievementVo.class, response);
    }

    @SaCheckPermission("business:stuAchievement:export")
    @Log(title = "在校成果管理", businessType = BusinessType.EXPORT)
    @PostMapping("/stu/export")
    public void stuExport(AchievementBo bo, HttpServletResponse response) {
        List<AchievementVo> list = achievementService.queryStuList(bo);
        ExcelUtil.exportExcel(list, "学生成果", AchievementVo.class, response);
    }

    @SaCheckPermission("business:achievement:export")
    @Log(title = "在校成果管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(AchievementBo bo, HttpServletResponse response) {
        List<AchievementVo> list = achievementService.queryList(bo);
        ExcelUtil.exportExcel(list, "成果管理", AchievementVo.class, response);
    }

    /**
     * 获取在校成果管理详细信息
     *
     * @param achievementId 主键
     */
    @SaCheckPermission("business:myAchievement:query")
    @GetMapping("/my/{achievementId}")
    public R<AchievementVo> getMyInfo(@NotNull(message = "主键不能为空")
                                    @PathVariable Long achievementId) {
        return R.ok(achievementService.queryById(achievementId));
    }

    @SaCheckPermission("business:stuAchievement:query")
    @GetMapping("/stu/{achievementId}")
    public R<AchievementVo> getStuInfo(@NotNull(message = "主键不能为空")
                                    @PathVariable Long achievementId) {
        return R.ok(achievementService.queryById(achievementId));
    }

    @SaCheckPermission("business:achievement:query")
    @GetMapping("/{achievementId}")
    public R<AchievementVo> getInfo(@NotNull(message = "主键不能为空")
                                       @PathVariable Long achievementId) {
        return R.ok(achievementService.queryById(achievementId));
    }

    /**
     * 新增在校成果管理
     */
    @SaCheckPermission("business:myAchievement:add")
    @Log(title = "在校成果管理", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping("/my")
    public R<Void> add(@Validated(AddGroup.class) @RequestBody AchievementBo bo) {
        return toAjax(achievementService.insertByBo(bo));
    }

    /**
     * 修改在校成果管理
     */
    @SaCheckPermission("business:myAchievement:edit")
    @Log(title = "在校成果管理", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping("/my")
    public R<Void> myEdit(@Validated(EditGroup.class) @RequestBody AchievementBo bo) {
        return toAjax(achievementService.updateMyByBo(bo));
    }

    @SaCheckPermission("business:stuAchievement:edit")
    @Log(title = "在校成果管理", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping("/stu")
    public R<Void> stuEdit(@Validated(EditGroup.class) @RequestBody AchievementBo bo) {
        return toAjax(achievementService.updateStuByBo(bo));
    }

    /**
     * 删除在校成果管理
     *
     * @param achievementIds 主键串
     */
    @SaCheckPermission("business:myAchievement:remove")
    @Log(title = "在校成果管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/my/{achievementIds}")
    public R<Void> removeMy(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] achievementIds) {
        return toAjax(achievementService.deleteMyWithValidByIds(List.of(achievementIds), true));
    }

    @SaCheckPermission("business:achievement:remove")
    @Log(title = "在校成果管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{achievementIds}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] achievementIds) {
        return toAjax(achievementService.deleteWithValidByIds(List.of(achievementIds), true));
    }

    /**
     * 佐证材料上传
     *
     * @param file 佐证材料
     */
    @SaCheckPermission("business:myAchievement:edit")
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

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
import top.sharehome.business.domain.bo.HonorBo;
import top.sharehome.business.domain.vo.HonorVo;
import top.sharehome.business.service.IHonorService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 在校荣誉管理
 * 前端访问路由地址为:/business/honor
 *
 * @author AntonyCheng
 * @date 2024-05-27
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/honor")
public class HonorController extends BaseController {

    private final IHonorService honorService;

    @DubboReference
    private final RemoteFileService remoteFileService;

    /**
     * 查询在校荣誉管理列表
     */
    @SaCheckPermission("business:myHonor:list")
    @GetMapping("/my/list")
    public TableDataInfo<HonorVo> myList(HonorBo bo, PageQuery pageQuery) {
        return honorService.queryMyPageList(bo, pageQuery);
    }

    @SaCheckPermission("business:stuHonor:list")
    @GetMapping("/stu/list")
    public TableDataInfo<HonorVo> stuList(HonorBo bo, PageQuery pageQuery) {
        return honorService.queryStuPageList(bo, pageQuery);
    }

    @SaCheckPermission("business:honor:list")
    @GetMapping("/list")
    public TableDataInfo<HonorVo> list(HonorBo bo, PageQuery pageQuery) {
        return honorService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出在校荣誉管理列表
     */
    @SaCheckPermission("business:myHonor:export")
    @Log(title = "在校荣誉管理", businessType = BusinessType.EXPORT)
    @PostMapping("/my/export")
    public void myExport(HonorBo bo, HttpServletResponse response) {
        List<HonorVo> list = honorService.queryMyList(bo);
        ExcelUtil.exportExcel(list, "我的荣誉", HonorVo.class, response);
    }

    @SaCheckPermission("business:stuHonor:export")
    @Log(title = "在校荣誉管理", businessType = BusinessType.EXPORT)
    @PostMapping("/stu/export")
    public void stuExport(HonorBo bo, HttpServletResponse response) {
        List<HonorVo> list = honorService.queryStuList(bo);
        ExcelUtil.exportExcel(list, "学生荣誉", HonorVo.class, response);
    }

    @SaCheckPermission("business:honor:export")
    @Log(title = "在校荣誉管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HonorBo bo, HttpServletResponse response) {
        List<HonorVo> list = honorService.queryList(bo);
        ExcelUtil.exportExcel(list, "荣誉管理", HonorVo.class, response);
    }

    /**
     * 获取在校荣誉管理详细信息
     *
     * @param honorId 主键
     */
    @SaCheckPermission("business:myHonor:query")
    @GetMapping("/my/{honorId}")
    public R<HonorVo> getMyInfo(@NotNull(message = "主键不能为空")
                                    @PathVariable Long honorId) {
        return R.ok(honorService.queryById(honorId));
    }

    @SaCheckPermission("business:stuHonor:query")
    @GetMapping("/stu/{honorId}")
    public R<HonorVo> getStuInfo(@NotNull(message = "主键不能为空")
                                    @PathVariable Long honorId) {
        return R.ok(honorService.queryById(honorId));
    }

    @SaCheckPermission("business:honor:query")
    @GetMapping("/{honorId}")
    public R<HonorVo> getInfo(@NotNull(message = "主键不能为空")
                                       @PathVariable Long honorId) {
        return R.ok(honorService.queryById(honorId));
    }

    /**
     * 新增在校荣誉管理
     */
    @SaCheckPermission("business:myHonor:add")
    @Log(title = "在校荣誉管理", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping("/my")
    public R<Void> add(@Validated(AddGroup.class) @RequestBody HonorBo bo) {
        return toAjax(honorService.insertByBo(bo));
    }

    /**
     * 修改在校荣誉管理
     */
    @SaCheckPermission("business:myHonor:edit")
    @Log(title = "在校荣誉管理", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping("/my")
    public R<Void> myEdit(@Validated(EditGroup.class) @RequestBody HonorBo bo) {
        return toAjax(honorService.updateMyByBo(bo));
    }

    @SaCheckPermission("business:stuHonor:edit")
    @Log(title = "在校荣誉管理", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping("/stu")
    public R<Void> stuEdit(@Validated(EditGroup.class) @RequestBody HonorBo bo) {
        return toAjax(honorService.updateStuByBo(bo));
    }

    /**
     * 删除在校荣誉管理
     *
     * @param honorIds 主键串
     */
    @SaCheckPermission("business:myHonor:remove")
    @Log(title = "在校荣誉管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/my/{honorIds}")
    public R<Void> removeMy(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] honorIds) {
        return toAjax(honorService.deleteMyWithValidByIds(List.of(honorIds), true));
    }

    @SaCheckPermission("business:honor:remove")
    @Log(title = "在校荣誉管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{honorIds}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] honorIds) {
        return toAjax(honorService.deleteWithValidByIds(List.of(honorIds), true));
    }

    /**
     * 佐证材料上传
     *
     * @param file 佐证材料
     */
    @SaCheckPermission("business:myHonor:edit")
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

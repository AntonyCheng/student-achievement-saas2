package top.sharehome.base.domain.bo;

import top.sharehome.base.domain.Major;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 专业业务对象 t_major
 *
 * @author AntonyCheng
 * @date 2024-04-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = Major.class, reverseConvertGenerate = false)
public class MajorBo extends BaseEntity {

    /**
     * 专业id
     */
    private Long majorId;

    /**
     * 部门id
     */
    @NotNull(message = "部门id不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long deptId;

    /**
     * 专业名称
     */
    @NotBlank(message = "专业名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String majorName;

    /**
     * 专业年级
     */
    @NotBlank(message = "专业年级不能为空", groups = { AddGroup.class, EditGroup.class })
    private String majorGrade;

    /**
     * 专业状态（0正常 1停用）
     */
    @NotBlank(message = "专业状态（0正常 1停用）不能为空", groups = { AddGroup.class, EditGroup.class })
    private String status;


}

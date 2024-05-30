package top.sharehome.business.domain.bo;

import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import top.sharehome.business.domain.Honor;

/**
 * 在校荣誉管理业务对象 business_honor
 *
 * @author AntonyCheng
 * @date 2024-05-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = Honor.class, reverseConvertGenerate = false)
public class HonorBo extends BaseEntity {

    /**
     * 荣誉id
     */
    @NotNull(message = "荣誉id不能为空", groups = { EditGroup.class })
    private Long honorId;

    /**
     * 荣誉类型
     */
    @NotNull(message = "荣誉类型不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long honorTypeId;

    /**
     * 荣誉名称
     */
    @NotNull(message = "荣誉名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String honorName;

    /**
     * 第一作者
     */
//    @NotNull(message = "第一作者不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long honorStudentId;

    /**
     * 第一作者所属部门
     */
//    @NotNull(message = "第一作者所属部门不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long honorStudentDeptId;

    /**
     * 第一指导老师
     */
    @NotNull(message = "第一指导老师不能为空", groups = { AddGroup.class })
    private Long honorTeacherId;

    /**
     * 其他成员
     */
//    @NotBlank(message = "其他成员不能为空", groups = { AddGroup.class, EditGroup.class })
    private String honorOtherStudentIds;

    /**
     * 其他老师
     */
//    @NotBlank(message = "其他老师不能为空", groups = { AddGroup.class, EditGroup.class })
    private String honorOtherTeacherIds;

    /**
     * 佐证材料
     */
    @NotBlank(message = "佐证材料不能为空", groups = { AddGroup.class, EditGroup.class })
    private String honorEvidenceUrl;

    /**
     * 审核反馈
     */
    private String honorFeedback;

    /**
     * 荣誉状态（0待审核 1审核通过 2审核不通过）
     */
    private String status;

    /**
     * 备注
     */
    private String remark;


}

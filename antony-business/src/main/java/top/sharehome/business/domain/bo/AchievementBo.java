package top.sharehome.business.domain.bo;

import top.sharehome.business.domain.Achievement;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 在校成果管理业务对象 business_achievement
 *
 * @author AntonyCheng
 * @date 2024-05-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = Achievement.class, reverseConvertGenerate = false)
public class AchievementBo extends BaseEntity {

    /**
     * 成果id
     */
    @NotNull(message = "成果id不能为空", groups = { EditGroup.class })
    private Long achievementId;

    /**
     * 成果类型
     */
    @NotNull(message = "成果类型不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long achievementTypeId;

    /**
     * 成果名称
     */
    @NotNull(message = "成果名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String achievementName;

    /**
     * 第一作者
     */
//    @NotNull(message = "第一作者不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long achievementStudentId;

    /**
     * 第一作者所属部门
     */
//    @NotNull(message = "第一作者所属部门不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long achievementStudentDeptId;

    /**
     * 第一指导老师
     */
    @NotNull(message = "第一指导老师不能为空", groups = { AddGroup.class })
    private Long achievementTeacherId;

    /**
     * 其他成员
     */
//    @NotBlank(message = "其他成员不能为空", groups = { AddGroup.class, EditGroup.class })
    private String achievementOtherStudentIds;

    /**
     * 其他老师
     */
//    @NotBlank(message = "其他老师不能为空", groups = { AddGroup.class, EditGroup.class })
    private String achievementOtherTeacherIds;

    /**
     * 佐证材料
     */
    @NotBlank(message = "佐证材料不能为空", groups = { AddGroup.class, EditGroup.class })
    private String achievementEvidenceUrl;

    /**
     * 审核反馈
     */
    private String achievementFeedback;

    /**
     * 成果状态（0待审核 1审核通过 2审核不通过）
     */
    private String status;

    /**
     * 备注
     */
    private String remark;


}

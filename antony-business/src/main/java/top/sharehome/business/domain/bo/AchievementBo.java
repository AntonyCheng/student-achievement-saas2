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
 * 成果业务对象 business_achievement
 *
 * @author AntonyCheng
 * @date 2024-04-21
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
     * 成果类型id
     */
    @NotNull(message = "成果类型id不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long achievementTypeId;

    /**
     * 成果第一作者id
     */
    @NotNull(message = "成果第一作者id不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long achievementStudentId;

    /**
     * 成果第一指导老师id
     */
    @NotNull(message = "成果第一指导老师id不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long achievementTeacherId;

    /**
     * 成果其他作者id JSON
     */
    @NotBlank(message = "成果其他作者id JSON不能为空", groups = { AddGroup.class, EditGroup.class })
    private String achievementOtherStudentIds;

    /**
     * 成果其他指导老师id JSON
     */
    @NotBlank(message = "成果其他指导老师id JSON不能为空", groups = { AddGroup.class, EditGroup.class })
    private String achievementOtherTeacherIds;

    /**
     * 成果作证材料URL
     */
    @NotBlank(message = "成果作证材料URL不能为空", groups = { AddGroup.class, EditGroup.class })
    private String achievementEvidenceUrl;

    /**
     * 成果审核反馈
     */
    @NotBlank(message = "成果审核反馈不能为空", groups = { AddGroup.class, EditGroup.class })
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

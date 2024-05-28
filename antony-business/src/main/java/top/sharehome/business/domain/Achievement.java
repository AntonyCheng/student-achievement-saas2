package top.sharehome.business.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 在校成果管理对象 business_achievement
 *
 * @author AntonyCheng
 * @date 2024-05-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("business_achievement")
public class Achievement extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 成果id
     */
    @TableId(value = "achievement_id")
    private Long achievementId;

    /**
     * 成果类型
     */
    private Long achievementTypeId;

    /**
     * 成果名称
     */
    private String achievementName;

    /**
     * 第一作者
     */
    private Long achievementStudentId;

    /**
     * 第一作者所属部门
     */
    private Long achievementStudentDeptId;

    /**
     * 第一指导老师
     */
    private Long achievementTeacherId;

    /**
     * 其他成员
     */
    private String achievementOtherStudentIds;

    /**
     * 其他老师
     */
    private String achievementOtherTeacherIds;

    /**
     * 佐证材料
     */
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
     * 删除标志（0代表存在 2代表删除）
     */
    @TableLogic
    private String delFlag;

    /**
     * 备注
     */
    private String remark;


}

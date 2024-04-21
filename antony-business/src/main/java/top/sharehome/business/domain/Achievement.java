package top.sharehome.business.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 成果对象 business_achievement
 *
 * @author AntonyCheng
 * @date 2024-04-21
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
     * 成果类型id
     */
    private Long achievementTypeId;

    /**
     * 成果第一作者id
     */
    private Long achievementStudentId;

    /**
     * 成果第一指导老师id
     */
    private Long achievementTeacherId;

    /**
     * 成果其他作者id JSON
     */
    private String achievementOtherStudentIds;

    /**
     * 成果其他指导老师id JSON
     */
    private String achievementOtherTeacherIds;

    /**
     * 成果作证材料URL
     */
    private String achievementEvidenceUrl;

    /**
     * 成果审核反馈
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

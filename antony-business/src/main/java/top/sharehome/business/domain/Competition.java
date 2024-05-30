package top.sharehome.business.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.tenant.core.TenantEntity;

import java.io.Serial;

/**
 * 在校竞赛管理对象 business_competition
 *
 * @author AntonyCheng
 * @date 2024-05-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("business_competition")
public class Competition extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 竞赛id
     */
    @TableId(value = "competition_id")
    private Long competitionId;

    /**
     * 竞赛类型
     */
    private Long competitionTypeId;

    /**
     * 竞赛名称
     */
    private String competitionName;

    /**
     * 第一作者
     */
    private Long competitionStudentId;

    /**
     * 第一作者所属部门
     */
    private Long competitionStudentDeptId;

    /**
     * 第一指导老师
     */
    private Long competitionTeacherId;

    /**
     * 其他成员
     */
    private String competitionOtherStudentIds;

    /**
     * 其他老师
     */
    private String competitionOtherTeacherIds;

    /**
     * 佐证材料
     */
    private String competitionEvidenceUrl;

    /**
     * 审核反馈
     */
    private String competitionFeedback;

    /**
     * 竞赛状态（0待审核 1审核通过 2审核不通过）
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

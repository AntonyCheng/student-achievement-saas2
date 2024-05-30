package top.sharehome.business.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.tenant.core.TenantEntity;

import java.io.Serial;

/**
 * 在校荣誉管理对象 business_honor
 *
 * @author AntonyCheng
 * @date 2024-05-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("business_honor")
public class Honor extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 荣誉id
     */
    @TableId(value = "honor_id")
    private Long honorId;

    /**
     * 荣誉类型
     */
    private Long honorTypeId;

    /**
     * 荣誉名称
     */
    private String honorName;

    /**
     * 第一作者
     */
    private Long honorStudentId;

    /**
     * 第一作者所属部门
     */
    private Long honorStudentDeptId;

    /**
     * 第一指导老师
     */
    private Long honorTeacherId;

    /**
     * 其他成员
     */
    private String honorOtherStudentIds;

    /**
     * 其他老师
     */
    private String honorOtherTeacherIds;

    /**
     * 佐证材料
     */
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
     * 删除标志（0代表存在 2代表删除）
     */
    @TableLogic
    private String delFlag;

    /**
     * 备注
     */
    private String remark;


}

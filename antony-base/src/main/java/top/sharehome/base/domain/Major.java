package top.sharehome.base.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 专业对象 t_major
 *
 * @author AntonyCheng
 * @date 2024-04-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_major")
public class Major extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 专业id
     */
    @TableId(value = "major_id")
    private Long majorId;

    /**
     * 部门id
     */
    private Long deptId;

    /**
     * 专业名称
     */
    private String majorName;

    /**
     * 专业年级
     */
    private String majorGrade;

    /**
     * 专业状态（0正常 1停用）
     */
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @TableLogic
    private String delFlag;


}

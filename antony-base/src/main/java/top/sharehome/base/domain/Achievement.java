package top.sharehome.base.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 成果类型对象 t_achievement
 *
 * @author AntonyCheng
 * @date 2024-04-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("base_achievement")
public class Achievement extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 成果id
     */
    @TableId(value = "achievement_id")
    private Long achievementId;

    /**
     * 成果名称
     */
    private String achievementName;

    /**
     * 成果状态（0正常 1停用）
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

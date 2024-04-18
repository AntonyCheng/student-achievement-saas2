package top.sharehome.base.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 竞赛类型对象 t_competition
 *
 * @author AntonyCheng
 * @date 2024-04-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("base_competition")
public class Competition extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 竞赛id
     */
    @TableId(value = "competition_id")
    private Long competitionId;

    /**
     * 竞赛名称
     */
    private String competitionName;

    /**
     * 竞赛状态（0正常 1停用）
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

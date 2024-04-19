package top.sharehome.base.domain;

import org.dromara.common.tenant.core.TenantEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 荣誉类型对象 t_honor
 *
 * @author AntonyCheng
 * @date 2024-04-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("base_honor_type")
public class Honor extends TenantEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 荣誉类型id
     */
    @TableId(value = "honor_type_id")
    private Long honorTypeId;

    /**
     * 荣誉类型名称
     */
    private String honorTypeName;

    /**
     * 荣誉类型状态（0正常 1停用）
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

package top.sharehome.base.domain.bo;

import top.sharehome.base.domain.Honor;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 荣誉类型业务对象 t_honor
 *
 * @author AntonyCheng
 * @date 2024-04-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = Honor.class, reverseConvertGenerate = false)
public class HonorBo extends BaseEntity {

    /**
     * 荣誉id
     */
    @NotNull(message = "荣誉id不能为空", groups = { EditGroup.class })
    private Long honorId;

    /**
     * 荣誉名称
     */
    @NotBlank(message = "荣誉名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String honorName;

    /**
     * 荣誉状态（0正常 1停用）
     */
    @NotBlank(message = "荣誉状态（0正常 1停用）不能为空", groups = { AddGroup.class, EditGroup.class })
    private String status;

    /**
     * 备注
     */
    private String remark;


}

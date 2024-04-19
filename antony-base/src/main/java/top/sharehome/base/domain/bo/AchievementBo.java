package top.sharehome.base.domain.bo;

import top.sharehome.base.domain.Achievement;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 成果类型业务对象 t_achievement
 *
 * @author AntonyCheng
 * @date 2024-04-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = Achievement.class, reverseConvertGenerate = false)
public class AchievementBo extends BaseEntity {

    /**
     * 成果类型id
     */
    @NotNull(message = "成果类型id不能为空", groups = { EditGroup.class })
    private Long achievementTypeId;

    /**
     * 成果类型名称
     */
    @NotBlank(message = "成果类型名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String achievementTypeName;

    /**
     * 成果类型状态（0正常 1停用）
     */
    @NotBlank(message = "成果类型状态（0正常 1停用）不能为空", groups = { AddGroup.class, EditGroup.class })
    private String status;

    /**
     * 备注
     */
    private String remark;


}

package top.sharehome.base.domain.bo;

import top.sharehome.base.domain.Competition;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;

/**
 * 竞赛类型业务对象 t_competition
 *
 * @author AntonyCheng
 * @date 2024-04-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = Competition.class, reverseConvertGenerate = false)
public class CompetitionBo extends BaseEntity {

    /**
     * 竞赛id
     */
    @NotNull(message = "竞赛id不能为空", groups = { EditGroup.class })
    private Long competitionId;

    /**
     * 竞赛名称
     */
    @NotBlank(message = "竞赛名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String competitionName;

    /**
     * 竞赛状态（0正常 1停用）
     */
    @NotBlank(message = "竞赛状态（0正常 1停用）不能为空", groups = { AddGroup.class, EditGroup.class })
    private String status;


}

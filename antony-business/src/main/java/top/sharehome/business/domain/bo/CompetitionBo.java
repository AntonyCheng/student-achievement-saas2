package top.sharehome.business.domain.bo;

import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import top.sharehome.business.domain.Competition;

/**
 * 在校竞赛管理业务对象 business_competition
 *
 * @author AntonyCheng
 * @date 2024-05-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = Competition.class, reverseConvertGenerate = false)
public class CompetitionBo extends BaseEntity {

    /**
     * 竞赛id
     */
    @NotNull(message = "竞赛id不能为空", groups = {EditGroup.class})
    private Long competitionId;

    /**
     * 竞赛类型
     */
    @NotNull(message = "竞赛类型不能为空", groups = {AddGroup.class, EditGroup.class})
    private Long competitionTypeId;

    /**
     * 竞赛名称
     */
    @NotNull(message = "竞赛名称不能为空", groups = {AddGroup.class, EditGroup.class})
    private String competitionName;

    /**
     * 第一作者
     */
//    @NotNull(message = "第一作者不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long competitionStudentId;

    /**
     * 第一作者所属部门
     */
//    @NotNull(message = "第一作者所属部门不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long competitionStudentDeptId;

    /**
     * 第一指导老师
     */
    @NotNull(message = "第一指导老师不能为空", groups = {AddGroup.class})
    private Long competitionTeacherId;

    /**
     * 其他成员
     */
//    @NotBlank(message = "其他成员不能为空", groups = { AddGroup.class, EditGroup.class })
    private String competitionOtherStudentIds;

    /**
     * 其他老师
     */
//    @NotBlank(message = "其他老师不能为空", groups = { AddGroup.class, EditGroup.class })
    private String competitionOtherTeacherIds;

    /**
     * 佐证材料
     */
    @NotBlank(message = "佐证材料不能为空", groups = {AddGroup.class, EditGroup.class})
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
     * 备注
     */
    private String remark;


}

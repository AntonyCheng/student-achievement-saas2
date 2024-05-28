package top.sharehome.business.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;
import top.sharehome.business.domain.Achievement;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;


/**
 * 在校成果管理视图对象 business_achievement
 *
 * @author AntonyCheng
 * @date 2024-05-27
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = Achievement.class)
public class AchievementVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 成果id
     */
    @ExcelProperty(value = "成果id")
    private Long achievementId;

    /**
     * 成果类型id
     */
    @ExcelIgnore
    private Long achievementTypeId;

    /**
     * 成果类型
     */
    @ExcelProperty(value = "成果类型")
    private String achievementTypeName;

    /**
     * 成果名称
     */
    @ExcelProperty(value = "成果名称")
    private String achievementName;

    /**
     * 第一作者id
     */
    @ExcelIgnore
    private Long achievementStudentId;

    /**
     * 第一作者
     */
    @ExcelProperty(value = "第一作者")
    private String achievementStudentName;

    /**
     * 第一作者所属部门id
     */
    @ExcelIgnore
    private Long achievementStudentDeptId;

    /**
     * 第一作者所属部门
     */
    @ExcelProperty(value = "所属部门")
    private String achievementStudentDeptName;

    /**
     * 第一指导老师id
     */
    @ExcelIgnore
    private Long achievementTeacherId;

    /**
     * 第一指导老师
     */
    @ExcelProperty(value = "第一指导老师")
    private String achievementTeacherName;

    /**
     * 其他成员id JSON
     */
    @ExcelIgnore
    private String achievementOtherStudentIds;

    /**
     * 其他成员 String
     */
    @ExcelProperty(value = "其他成员")
    private String achievementOtherStudentNames;

    /**
     * 其他老师id JSON
     */
    @ExcelIgnore
    private String achievementOtherTeacherIds;

    /**
     * 其他老师 String
     */
    @ExcelProperty(value = "其他老师")
    private String achievementOtherTeacherNames;

    /**
     * 佐证材料
     */
    @ExcelProperty(value = "佐证材料")
    private String achievementEvidenceUrl;

    /**
     * 审核反馈
     */
    @ExcelProperty(value = "审核反馈")
    private String achievementFeedback;

    /**
     * 成果状态（0待审核 1审核通过 2审核不通过）
     */
    @ExcelProperty(value = "成果状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "business_experience_type")
    private String status;

    /**
     * 创建时间
     */
    @ExcelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;


}

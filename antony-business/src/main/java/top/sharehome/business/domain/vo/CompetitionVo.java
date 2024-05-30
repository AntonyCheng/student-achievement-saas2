package top.sharehome.business.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;
import top.sharehome.business.domain.Competition;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;


/**
 * 在校竞赛管理视图对象 business_competition
 *
 * @author AntonyCheng
 * @date 2024-05-27
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = Competition.class)
public class CompetitionVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 竞赛id
     */
    @ExcelProperty(value = "竞赛id")
    private Long competitionId;

    /**
     * 竞赛类型id
     */
    @ExcelIgnore
    private Long competitionTypeId;

    /**
     * 竞赛类型
     */
    @ExcelProperty(value = "竞赛类型")
    private String competitionTypeName;

    /**
     * 竞赛名称
     */
    @ExcelProperty(value = "竞赛名称")
    private String competitionName;

    /**
     * 第一作者id
     */
    @ExcelIgnore
    private Long competitionStudentId;

    /**
     * 第一作者
     */
    @ExcelProperty(value = "第一作者")
    private String competitionStudentName;

    /**
     * 第一作者所属部门id
     */
    @ExcelIgnore
    private Long competitionStudentDeptId;

    /**
     * 第一作者所属部门
     */
    @ExcelProperty(value = "所属部门")
    private String competitionStudentDeptName;

    /**
     * 第一指导老师id
     */
    @ExcelIgnore
    private Long competitionTeacherId;

    /**
     * 第一指导老师
     */
    @ExcelProperty(value = "第一指导老师")
    private String competitionTeacherName;

    /**
     * 其他成员id JSON
     */
    @ExcelIgnore
    private String competitionOtherStudentIds;

    /**
     * 其他成员 String
     */
    @ExcelProperty(value = "其他成员")
    private String competitionOtherStudentNames;

    /**
     * 其他老师id JSON
     */
    @ExcelIgnore
    private String competitionOtherTeacherIds;

    /**
     * 其他老师 String
     */
    @ExcelProperty(value = "其他老师")
    private String competitionOtherTeacherNames;

    /**
     * 佐证材料
     */
    @ExcelProperty(value = "佐证材料")
    private String competitionEvidenceUrl;

    /**
     * 审核反馈
     */
    @ExcelProperty(value = "审核反馈")
    private String competitionFeedback;

    /**
     * 竞赛状态（0待审核 1审核通过 2审核不通过）
     */
    @ExcelProperty(value = "竞赛状态", converter = ExcelDictConvert.class)
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

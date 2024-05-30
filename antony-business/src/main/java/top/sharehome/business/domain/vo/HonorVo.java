package top.sharehome.business.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;
import top.sharehome.business.domain.Honor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;


/**
 * 在校荣誉管理视图对象 business_honor
 *
 * @author AntonyCheng
 * @date 2024-05-27
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = Honor.class)
public class HonorVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 荣誉id
     */
    @ExcelProperty(value = "荣誉id")
    private Long honorId;

    /**
     * 荣誉类型id
     */
    @ExcelIgnore
    private Long honorTypeId;

    /**
     * 荣誉类型
     */
    @ExcelProperty(value = "荣誉类型")
    private String honorTypeName;

    /**
     * 荣誉名称
     */
    @ExcelProperty(value = "荣誉名称")
    private String honorName;

    /**
     * 第一作者id
     */
    @ExcelIgnore
    private Long honorStudentId;

    /**
     * 第一作者
     */
    @ExcelProperty(value = "第一作者")
    private String honorStudentName;

    /**
     * 第一作者所属部门id
     */
    @ExcelIgnore
    private Long honorStudentDeptId;

    /**
     * 第一作者所属部门
     */
    @ExcelProperty(value = "所属部门")
    private String honorStudentDeptName;

    /**
     * 第一指导老师id
     */
    @ExcelIgnore
    private Long honorTeacherId;

    /**
     * 第一指导老师
     */
    @ExcelProperty(value = "第一指导老师")
    private String honorTeacherName;

    /**
     * 其他成员id JSON
     */
    @ExcelIgnore
    private String honorOtherStudentIds;

    /**
     * 其他成员 String
     */
    @ExcelProperty(value = "其他成员")
    private String honorOtherStudentNames;

    /**
     * 其他老师id JSON
     */
    @ExcelIgnore
    private String honorOtherTeacherIds;

    /**
     * 其他老师 String
     */
    @ExcelProperty(value = "其他老师")
    private String honorOtherTeacherNames;

    /**
     * 佐证材料
     */
    @ExcelProperty(value = "佐证材料")
    private String honorEvidenceUrl;

    /**
     * 审核反馈
     */
    @ExcelProperty(value = "审核反馈")
    private String honorFeedback;

    /**
     * 荣誉状态（0待审核 1审核通过 2审核不通过）
     */
    @ExcelProperty(value = "荣誉状态", converter = ExcelDictConvert.class)
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

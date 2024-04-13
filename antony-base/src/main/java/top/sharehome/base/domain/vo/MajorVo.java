package top.sharehome.base.domain.vo;

import top.sharehome.base.domain.Major;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;



/**
 * 专业视图对象 t_major
 *
 * @author AntonyCheng
 * @date 2024-04-13
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = Major.class)
public class MajorVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 专业id
     */
    @ExcelProperty(value = "专业id")
    private Long majorId;

    /**
     * 部门id
     */
    @ExcelProperty(value = "部门id")
    private Long deptId;

    /**
     * 专业名称
     */
    @ExcelProperty(value = "专业名称")
    private String majorName;

    /**
     * 专业年级
     */
    @ExcelProperty(value = "专业年级", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "base_major_grade")
    private String majorGrade;

    /**
     * 专业状态（0正常 1停用）
     */
    @ExcelProperty(value = "专业状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sys_normal_disable")
    private String status;

    /**
     * 创建时间
     */
    @ExcelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @ExcelProperty(value = "更新时间")
    private Date updateTime;


}

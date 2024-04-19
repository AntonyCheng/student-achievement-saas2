package top.sharehome.base.domain.vo;

import top.sharehome.base.domain.Honor;
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
 * 荣誉类型视图对象 t_honor
 *
 * @author AntonyCheng
 * @date 2024-04-15
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = Honor.class)
public class HonorVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 荣誉类型id
     */
    @ExcelProperty(value = "荣誉类型id")
    private Long honorTypeId;

    /**
     * 荣誉类型名称
     */
    @ExcelProperty(value = "荣誉类型名称")
    private String honorTypeName;

    /**
     * 荣誉类型状态（0正常 1停用）
     */
    @ExcelProperty(value = "荣誉类型状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sys_normal_disable")
    private String status;

    /**
     * 备注
     */
    @ExcelProperty(value = "备注")
    private String remark;

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

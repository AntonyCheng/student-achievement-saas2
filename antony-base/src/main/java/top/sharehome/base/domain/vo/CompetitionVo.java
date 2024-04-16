package top.sharehome.base.domain.vo;

import top.sharehome.base.domain.Competition;
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
 * 竞赛类型视图对象 t_competition
 *
 * @author AntonyCheng
 * @date 2024-04-15
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
     * 竞赛名称
     */
    @ExcelProperty(value = "竞赛名称")
    private String competitionName;

    /**
     * 竞赛状态（0正常 1停用）
     */
    @ExcelProperty(value = "竞赛状态", converter = ExcelDictConvert.class)
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

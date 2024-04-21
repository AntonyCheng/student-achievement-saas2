package top.sharehome.business.domain.vo;

import top.sharehome.business.domain.Achievement;
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
 * 成果视图对象 business_achievement
 *
 * @author AntonyCheng
 * @date 2024-04-21
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
    @ExcelProperty(value = "成果类型id")
    private Long achievementTypeId;

    /**
     * 成果第一作者id
     */
    @ExcelProperty(value = "成果第一作者id")
    private Long achievementStudentId;

    /**
     * 成果第一指导老师id
     */
    @ExcelProperty(value = "成果第一指导老师id")
    private Long achievementTeacherId;

    /**
     * 成果其他作者id JSON
     */
    @ExcelProperty(value = "成果其他作者id JSON")
    private String achievementOtherStudentIds;

    /**
     * 成果其他指导老师id JSON
     */
    @ExcelProperty(value = "成果其他指导老师id JSON")
    private String achievementOtherTeacherIds;

    /**
     * 成果作证材料URL
     */
    @ExcelProperty(value = "成果作证材料URL")
    private String achievementEvidenceUrl;

    /**
     * 成果审核反馈
     */
    @ExcelProperty(value = "成果审核反馈")
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

package org.dromara.system.domain.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;

import java.io.Serial;
import java.io.Serializable;


/**
 * 用户对象导入VO
 *
 * @author Lion Li
 */

@Data
@NoArgsConstructor
// @Accessors(chain = true) // 导入不允许使用 会找不到set方法
public class SysUserImportVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @ExcelProperty(value = "用户序号(工号/学号)")
    private Long userId;

    /**
     * 部门ID
     */
    @ExcelProperty(value = "部门编号（见第一行）")
    private Long deptId;


    public SysUserImportVo(Long deptId) {
        this.deptId = deptId;
    }

    /**
     * 用户账号
     */
    @ExcelProperty(value = "用户账号\n（名字拼音小写首字母+手机后四位\n例如张三/13100001234：zs1234）")
    private String userName;

    /**
     * 用户昵称
     */
    @ExcelProperty(value = "用户名字")
    private String nickName;

    /**
     * 用户角色
     */
    @ExcelProperty(value = "角色")
    @ExcelDictFormat(dictType = "sys_role_type")
    private String role;

    /**
     * 用户岗位
     */
    @ExcelProperty(value = "岗位")
    @ExcelDictFormat(dictType = "sys_post_type")
    private String post;

    /**
     * 用户邮箱
     */
    @ExcelProperty(value = "用户邮箱")
    private String email;

    /**
     * 手机号码
     */
    @ExcelProperty(value = "手机号码")
    private String phonenumber;

    /**
     * 用户性别
     */
    @ExcelProperty(value = "用户性别", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sys_user_sex")
    private String sex;

    /**
     * 帐号状态（0正常 1停用）
     */
    @ExcelProperty(value = "帐号状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sys_normal_disable")
    private String status;

}

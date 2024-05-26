package org.dromara.system.domain.vo;

import lombok.Data;
import org.dromara.common.sensitive.annotation.Sensitive;
import org.dromara.common.sensitive.core.SensitiveStrategy;

import java.io.Serial;
import java.io.Serializable;


/**
 * 用户通过昵称查询对象 sys_user
 *
 * @author Michelle.Chung
 */
@Data
public class SysUserNickNameVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 手机号码
     */
    private String phonenumber;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 角色对象
     */
    private String roleNames;

}

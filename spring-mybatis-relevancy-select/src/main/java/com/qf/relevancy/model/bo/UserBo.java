package com.qf.relevancy.model.bo;

import com.qf.relevancy.model.po.Role;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserBo implements Serializable {
    /**
     * 用户id
     */

    private Integer uId;

    /**
     * 用户姓名
     */

    private String uUsername;

    /**
     * 用户密码
     */

    private String uPassword;

    /**
     * 用户性别
     */

    private String uSex;

    /**
     * 用户年龄
     */

    private Integer uAge;

    /**
     * 用户号码
     */

    private String uPhone;

    /**
     * 用户邮箱账号
     */

    private String uEmail;

    /**
     * 用户角色id
     */

    private Integer roleId;

    /**
     * 假删除字段
     */

    private Integer isDelete;

    private Role  role;
}

package com.qf.relevancy.model.po;


import lombok.Data;

import java.io.Serializable;

/**
    * 角色表
    */
@Data
public class Role  implements Serializable {
    /**
     * 角色id
     */
    private Integer rId;

    /**
     * 角色名称
     */
    private String rName;

    /**
     * 父角色id
     */
    private Integer parentId;

    /**
     * 角色假删除字段
     */
    private Integer isDelete;
}
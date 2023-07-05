package com.qf.relevancy.model.po;


import lombok.Data;

import java.io.Serializable;

/**
    * 权限表
    */
@Data
public class Power implements Serializable {
    private Integer pId;

    private String pName;

    private Integer parentId;

    private Integer isDelete;
}
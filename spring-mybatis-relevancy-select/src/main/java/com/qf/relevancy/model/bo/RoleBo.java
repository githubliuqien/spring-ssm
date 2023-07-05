package com.qf.relevancy.model.bo;

import com.qf.relevancy.model.po.Power;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class RoleBo  implements Serializable {
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

    private List<Power> power;
}

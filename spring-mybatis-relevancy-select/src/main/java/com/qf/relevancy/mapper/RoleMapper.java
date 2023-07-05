package com.qf.relevancy.mapper;

import com.qf.relevancy.model.bo.RoleBo;
import com.qf.relevancy.model.po.Role;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {

    /**
     * 根据角色 id 查询当前角色信息(包含权限)
     * @param id
     * @return
     */
    RoleBo selectBeanRoleId(@Param("id") Integer id);

    /**
     * 根据角色 id 查询当前角色信息(包含权限信息和用户信息)
     * @param id
     * @return
     */
}
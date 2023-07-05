package com.qf.relevancy.mapper;

import com.qf.relevancy.model.po.Power;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PowerMapper {
    /**
     * 根据角色 id 查询权限对象集合
     * @param id
     * @return
     */
    List<Power> selectListByRoleId(@Param("id") Integer id);


    /**
     * 根据 角色ID查询 权限信息
     */

    Power  selectByRoleID(@Param("rid") int rid);

}
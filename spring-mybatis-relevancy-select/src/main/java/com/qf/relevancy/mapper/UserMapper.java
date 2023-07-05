package com.qf.relevancy.mapper;

import com.qf.relevancy.model.bo.UserBo;
import com.qf.relevancy.model.bo.UserBoTo;
import com.qf.relevancy.model.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> selectAll();


    /**
     * 根据角色 id 查询对应的用户对象集合
     * @param id
     * @return
     */
    List<User>  selectByRoleID(@Param("rid") int id);


    /**
     * 根据用户指定信息获取用户所有信息
     * @param user
     * @return
     */

    List<User>  selectBean(@Param("user")User user);

    /**
     * 根据用户 id 查询用户信息(包含角色信息)
     * @param id
     * @return
     */

    UserBo selectByID(@Param("id") int id);


    /**
     * 根据  用户查询出 角色 权限（信息）
     */


    UserBoTo  selectByIdToAllInfo(@Param("id") int id);








}
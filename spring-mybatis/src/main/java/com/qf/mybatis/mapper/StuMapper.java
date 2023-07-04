package com.qf.mybatis.mapper;

import com.qf.mybatis.model.Stu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuMapper {
    int insert(Stu record);

    int insertSelective(Stu record);

    /**
     * 根据 不同的条件进行查询
     */
    List<Stu>  queryMultiple(@Param("stu") Stu stu);


    int deleteBatch(@Param("list") List<Integer> list);


    int  update(@Param("stu") Stu stu);

}
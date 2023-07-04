package com.qf.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//提供无参构造方法
@NoArgsConstructor
//提供存在所有参数的有参构造方法
@AllArgsConstructor
//给所有的属性添加 get()/set() 方法，重写 equals()/hashCode()/toString()
@Data
//允许实体类通过建造者模式创建对象
@Builder
public class Stu {

    private Integer sid;

    private String sName;

    private Integer age;

    private String gender;


}
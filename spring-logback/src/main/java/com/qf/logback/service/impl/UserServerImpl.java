package com.qf.logback.service.impl;

import com.qf.logback.model.User;
import com.qf.logback.service.UserServer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Slf4j
public class UserServerImpl  implements UserServer {


   @Override
    public void   addUser(User user){
       
       if (StringUtils.isAnyBlank(user.getUserName(),user.getUserPassWord(),user.getCheckPassWord())){
           log.error("用户名称、密码或者校验密码为空");
       }
       
       //校验用户名是否符合规范
       //匹配规则
       String regex = "[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
       Matcher matcher = Pattern.compile(regex).matcher(user.getUserName());
       if (matcher.find()){
           log.error("用户名不符合命名规则");
           return;
       }
       
       if (!user.getUserPassWord().equals(user.getCheckPassWord())){
           log.error("密码和校验密码不一致");
           return;
       }

       //MD5加密密码
       String digestAsHex = DigestUtils.md5DigestAsHex(user.getUserPassWord().getBytes());


       log.info("登录成功");


   }
}

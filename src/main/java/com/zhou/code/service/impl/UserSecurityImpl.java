package com.zhou.code.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.zhou.code.bean.User;
import com.zhou.code.bean.UserDetail;
import com.zhou.code.service.IUserService;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserSecurityImpl implements UserDetailsService {
    @Autowired
    IUserService userService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.getById(StringUtils.stringToInteger(s));
        if(user==null) {
            return null;
        }
        UserDetails userDetails = new UserDetail(user.getUserId().toString(),user.getUserPwd());
        return userDetails;
    }
}

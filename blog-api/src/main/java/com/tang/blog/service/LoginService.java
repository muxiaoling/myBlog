package com.tang.blog.service;

import com.tang.blog.dao.pojo.SysUser;
import com.tang.blog.vo.Result;
import com.tang.blog.vo.params.LoginParam;

public interface LoginService {
    //登录功能
    Result login(LoginParam loginParam);

    SysUser checkToken(String token);

    Result logout(String token);

    //注册
    Result register(LoginParam registerParam);
}

package com.tang.blog.service;

import com.tang.blog.dao.pojo.SysUser;
import com.tang.blog.vo.Result;
import com.tang.blog.vo.UserVo;

public interface SysUserService {

    UserVo findUserVoById(Long id);

    SysUser findUserById(Long id);

    SysUser findUser(String account, String password);

    //根据Token查询用户
    Result getUserInfoByToken(String token);

    //根据账户查找用户
    SysUser findUserByAccount(String account);

    //注册时保存用户
    void save(SysUser sysUser);
}

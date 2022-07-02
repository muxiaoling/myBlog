package com.tang.blog.dao.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class SysUser {

    @TableId
    private Long id;

    private String account; //账号

    private Integer admin;  //是否管理员

    private String avatar; //头像

    private Long createDate; //注册时间

    private Integer deleted; //是否删除

    private String email; //邮箱

    private Long lastLogin; //最后登录时间

    private String mobilePhoneNumber; //手机号

    private String nickname;  //昵称

    private String password; //密码

    private String salt;  //盐值

    private String status; //状态
}



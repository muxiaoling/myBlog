package com.tang.blog.vo;

import lombok.Data;

@Data
public class LoginUserVo {
    private Long id;
    private String account;
    private String nickName;
    private String avatar;
}

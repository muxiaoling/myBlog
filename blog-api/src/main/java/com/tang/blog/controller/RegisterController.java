package com.tang.blog.controller;

import com.tang.blog.service.LoginService;
import com.tang.blog.vo.Result;
import com.tang.blog.vo.params.LoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("register")
public class RegisterController {
    @Autowired
    private LoginService registerService;

    @PostMapping
    public Result register(@RequestBody LoginParam registerParam) {
        return registerService.register(registerParam);
    }
}

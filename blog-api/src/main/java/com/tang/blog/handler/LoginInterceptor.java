package com.tang.blog.handler;

import com.alibaba.fastjson.JSON;
import com.tang.blog.dao.pojo.SysUser;
import com.tang.blog.service.LoginService;
import com.tang.blog.utils.UserThreadLocal;
import com.tang.blog.vo.ErrorCode;
import com.tang.blog.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private LoginService loginService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /**
         * 判断请求路径是否是HandlerMethod（Controller方法）
         * 判断token是否为空，如果为空，未登录
         * 如果token 不为空 登录验证loginService checkToken
         * 如果认证成功，放行
         */
        if (!(handler instanceof HandlerMethod)) {
            return true; //访问资源
        }
        String token = request.getHeader("Authorization");

        log.info("=================request 开始===========================");
        String requestURI = request.getRequestURI();
        log.info("request uri:{}",requestURI);
        log.info("request method:{}",request.getMethod());
        log.info("token:{}", token);
        log.info("=================request 结束===========================");

        if (StringUtils.isBlank(token)) {
            Result result = Result.fail(ErrorCode.NO_LOGIN.getCode(), "未登录");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            return false;
        }
        SysUser sysUser = loginService.checkToken(token);
        if (null == sysUser) {
            Result result = Result.fail(ErrorCode.NO_LOGIN.getCode(), "未登录");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            return false;
        }
        UserThreadLocal.put(sysUser);
        return true;
    }

    @Override
    public void afterCompletion (HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //防止内存泄漏的风险
        UserThreadLocal.remove();
    }
}

package com.wangzk.im.controller;

import com.wangzk.im.bean.User;
import com.wangzk.im.dto.Resp;
import com.wangzk.im.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Title: UserController
 * @ProjectName: im
 * @PackageName: com.wangzk.im.controller
 * @Description: TODO
 * @author: wangzk
 * @date: 2019-08-27 15:30
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    /**
     * 用户登录
     *
     * @return 操作结果
     * @throws AuthenticationException 错误信息
     */
    @PostMapping(value = "/login")
    public Resp getToken(@RequestBody User user) throws Exception {
        String token = userService.login(user.getUserName(), user.getPassWord());
        if (StringUtils.isEmpty(token)){
            return new Resp().file("token 获取失败");
        }
        return new Resp().success(token);
    }

    /**
     * 用户注册
     *
     * @param user 用户信息
     * @return 操作结果
     * @throws AuthenticationException 错误信息
     */
    @PostMapping(value = "/register")
    public Resp register(@RequestBody User user) throws AuthenticationException {
        String register = userService.register(user);
        if ("success".equals(register)){
            return new Resp().success();
        }
        return new Resp().file(register);
    }

}

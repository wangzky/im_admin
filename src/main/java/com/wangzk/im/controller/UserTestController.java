package com.wangzk.im.controller;

import com.wangzk.im.bean.User;
import com.wangzk.im.repository.UserRepository;
import com.wangzk.im.service.impl.UserServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Title: UserTestController
 * @ProjectName: im
 * @PackageName: com.wangzk.im.controller
 * @Description: TODO
 * @author: wangzk
 * @date: 2019-08-27 15:36
 */
@Log4j2
@RestController
@RequestMapping("/test")
public class UserTestController {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/getInfoById", params = {"id"} )
    public User findById(Long id){
        User userInfo= new User("123","456");
//        User userInfo=this.userService.findById(id);
        return userInfo;
    }

    @PostMapping(value = "/findByUsername", params = {"username"} )
    public User findByUsername(String username){
        User userInfo=this.userRepository.findByUsername(username);
        return userInfo;
    }
}

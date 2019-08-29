package com.wangzk.im.service.impl;

import com.wangzk.im.bean.User;
import com.wangzk.im.jwt.JwtTokenUtil;
import com.wangzk.im.jwt.JwtUserDetailsServiceImpl;
import com.wangzk.im.repository.UserRepository;
import com.wangzk.im.service.IUserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Title: IUserServiceImpl
 * @ProjectName: im
 * @PackageName: com.wangzk.im.service.impl
 * @Description: TODO
 * @author: wangzk
 * @date: 2019-08-27 15:20
 */
@Log4j2
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private AuthenticationManager authenticationManager;
    private JwtUserDetailsServiceImpl jwtUserDetailsService;
    private JwtTokenUtil jwtTokenUtil;
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(JwtUserDetailsServiceImpl jwtUserDetailsService, JwtTokenUtil jwtTokenUtil, UserRepository userRepository) {
        this.jwtUserDetailsService = jwtUserDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userRepository = userRepository;
    }

    @Override
    public String login(String username, String password) throws Exception {
        log.info("=======登录========");
        try {
            if (userRepository.findByUsername(username) == null) {
                throw new Exception("=======登录异常========用户不存在");
            }

            UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
            Authentication authentication = authenticationManager.authenticate(upToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(username);
            return jwtTokenUtil.generateToken(userDetails);
        } catch (Exception e) {
            log.error("=======登录异常========" + e.getMessage());
            throw new Exception("=======登录异常========" + e.getMessage());
        }
    }

    @Override
    public String register(User user) {
        String username = user.getUserName();
        if (userRepository.findByUsername(username) != null) {
            return "用户已存在";
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = user.getPassWord();
        log.info("=======注册========");
        user.setPassWord(encoder.encode(rawPassword));
        userRepository.save(user);
        return "success";
    }


}

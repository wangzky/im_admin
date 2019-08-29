package com.wangzk.im.jwt;

import com.wangzk.im.bean.User;
import com.wangzk.im.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Title: JwtUserDetailsServiceImpl
 * @ProjectName: im
 * @PackageName: com.wangzk.im.jwt
 * @Description: TODO
 * @author: wangzk
 * @date: 2019-08-27 15:10
 */
@Service
public class JwtUserDetailsServiceImpl  implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =userRepository.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("用户不存在");
        }else{
            // 用户存在，给用户授权
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            return new JwtUser(user.getUserName(), user.getPassWord(), authorities);
        }
    }
}

package com.wangzk.im.config;

import com.wangzk.im.jwt.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created with IntelliJ IDEA.
 * Description: 安全配置类
 *
 * @Title: WebSecurityConfig
 * @ProjectName: im
 * @PackageName: com.wangzk.im.config
 * @Description: TODO
 * @author: wangzk
 * @date: 2019-08-27 15:15
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public WebSecurityConfig(UserDetailsService userDetailsService, JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter) {
        this.userDetailsService = userDetailsService;
        this.jwtAuthenticationTokenFilter = jwtAuthenticationTokenFilter;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests()
                .antMatchers("/user/**").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/im/**").permitAll()
                .antMatchers("/templates/**").permitAll()
                // 所有请求都需要认证
                .anyRequest().authenticated();
        httpSecurity.headers().cacheControl();
        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}

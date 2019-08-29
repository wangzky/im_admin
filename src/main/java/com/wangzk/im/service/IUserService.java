package com.wangzk.im.service;


import com.wangzk.im.bean.User;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Title: IUserService
 * @ProjectName: im
 * @PackageName: com.wangzk.im.service
 * @Description: TODO
 * @author: wangzk
 * @date: 2019-08-27 15:19
 */
public interface IUserService {
    /**
     * 用户登录
     *
     * @param userName 用户名
     * @param passWord 密码
     * @return 操作结果
     */
    String login(String userName, String passWord) throws Exception;

    /**
     * 用户注册
     *
     * @param user 用户信息
     * @return 操作结果
     */
    String register(User user);

}

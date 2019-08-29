package com.wangzk.im.repository;

import com.wangzk.im.bean.User;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Title: User
 * @ProjectName: im
 * @PackageName: com.wangzk.im.repository
 * @Description: TODO
 * @author: wangzk
 * @date: 2019-08-27 15:02
 */
public interface UserRepository {
    User findByUsername(String username);
    void save(User user);
}

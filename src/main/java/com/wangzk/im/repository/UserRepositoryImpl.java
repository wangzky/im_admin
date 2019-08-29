package com.wangzk.im.repository;

import com.wangzk.im.bean.User;
import com.wangzk.im.dao.UserDao;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Title: UserRepositoryImpl
 * @ProjectName: im
 * @PackageName: com.wangzk.im.repository
 * @Description: TODO
 * @author: wangzk
 * @date: 2019-08-27 15:40
 */
@Log4j2
@Service
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    UserDao userDao;

    @Override
    public User findByUsername(String username) {
        return userDao.findByUserName(username);
    }

    @Override
    public void save(User user) {
        log.info("注册==>"+user.toString());
        userDao.save(user);
    }
}

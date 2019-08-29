package com.wangzk.im.dao;

import com.wangzk.im.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Title: UserDao
 * @ProjectName: im
 * @PackageName: com.wangzk.im.dao
 * @Description: TODO
 * @author: wangzk
 * @date: 2019-08-27 16:28
 */
@Component
public interface UserDao extends JpaRepository<User,Long> {

    @Query(value = "select * from user where user_name = :userName " , nativeQuery = true)
    User findByUserName(@Param("userName") String userName);
}

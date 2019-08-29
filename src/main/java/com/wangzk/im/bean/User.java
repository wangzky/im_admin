package com.wangzk.im.bean;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GenerationType;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Title: User
 * @ProjectName: im
 * @PackageName: com.wangzk.im.bean
 * @Description: TODO
 * @author: wangzk
 * @date: 2019-08-27 16:09
 */

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "pass_word")
    private String passWord;

    public User(String userName , String passWord){
        this.userName = userName;
        this.passWord = passWord;
    }

    public User(){

    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}

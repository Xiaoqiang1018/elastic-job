package com.it.xiao.elasticjob.service;

import com.it.xiao.elasticjob.dao.UserDao;
import com.it.xiao.elasticjob.pojo.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.time.LocalTime;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author: xiaoqiang
 * @Description:
 * @Date: 2021/7/29
 * @Version: 1.0
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public int addUser() throws InterruptedException, ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection root = DriverManager.getConnection("jdbc:mysql://localhost:3306/database0?characterEncoding=UTF-8&useUnicode=true&autoReconnect=true&useCursorFetch=true&defaultFetchSize=100&serverTimezone=UTC", "root", "123456");
//        root.prepareStatement()
//        System.out.println();
//        String s = UUID.randomUUID().toString();
//        System.out.println(LocalTime.now()+"添加数据库开始。。。。。。。"+s);
//
//        TUser tUser = new TUser();
//        tUser.setUsername("wqwq");
//        tUser.setPassword("pass");
//        int insert = userDao.insert(tUser);
//
//        System.out.println(LocalTime.now()+"添加数据库结束。。。。。。。。"+s);
//        TimeUnit.SECONDS.sleep(10);
//        System.out.println();
//        return insert;
        return 0;

    }
}

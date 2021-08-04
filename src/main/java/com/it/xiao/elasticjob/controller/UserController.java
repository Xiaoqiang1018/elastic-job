package com.it.xiao.elasticjob.controller;

import com.it.xiao.elasticjob.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;

/**
 * @Author: xiaoqiang
 * @Description:
 * @Date: 2021/7/29
 * @Version: 1.0
 */
@RestController
@RequestMapping("t")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("add")
    public int addUser() throws InterruptedException {
//        int i = userService.addUser();
        return 0;
    }



}

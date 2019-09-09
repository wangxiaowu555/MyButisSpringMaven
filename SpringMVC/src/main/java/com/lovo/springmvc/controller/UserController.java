package com.lovo.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping("loginUser")
    public String loginUser(String userName,String password){
        System.out.println(userName+"/"+password);
        return "index.jsp";
    }
}

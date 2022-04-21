
package com.study.studentsys.controller;

import com.study.studentsys.entity.User;
import com.study.studentsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class IndexController {

    // 自动注入userService
    @Autowired
    private UserService userService;

    @GetMapping("/detail.html")
    public String detail() {
        return "detail";
    }

    @GetMapping("/reset.html")
    public String resetPwd() {
        return "reset";
    }

    @GetMapping("/getAllUser")
    @ResponseBody //这个注解是让返回值以 json 的格式返回
    public List<User> getAllUser() {
        return userService.findAll();
    }

}

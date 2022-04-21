package com.study.studentsys.controller;

import com.study.studentsys.entity.User;
import com.study.studentsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/page")
public class PageController {

    @Autowired
    private UserService userService;

    @GetMapping("/home.html")
    public String homePage() {
        return "home";
    }

    @GetMapping("/registSuccess.html")
    public String registSuccessPage() {
        return "registSuccess";
    }

    @GetMapping("/login.html")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/regist.html")
    public String registPage() {
        return "regist";
    }

    @GetMapping("/reset.html")
    public String resetPage() {
        return "reset";
    }



    @GetMapping("/user.html")
    public String userPage(HttpSession session, Model model) {
        String email = (String) session.getAttribute("email");
        User user = userService.getByEmail(email);
        System.out.println(user);
        model.addAttribute("user", user);
        return "user";
    }


}
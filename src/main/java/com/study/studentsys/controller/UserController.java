package com.study.studentsys.controller;

import com.study.studentsys.constant.EmailConstant;
import com.study.studentsys.dto.ResetPwdDto;
import com.study.studentsys.entity.User;
import com.study.studentsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/resetpwd")
    @ResponseBody
    public Map resetpwd(@RequestBody ResetPwdDto resetPwdDto) {
        Map<String, String> result = new HashMap<>();
        String verificationCode = resetPwdDto.getVerificationCode();
        String resetMapCode = EmailConstant.EMAIL_CODE_MAP.get(resetPwdDto.getEmailAddress());
        // 验证码不正确
        if (StringUtils.isEmpty(verificationCode) || StringUtils.isEmpty(resetMapCode) || resetMapCode.startsWith(verificationCode + "_")) {
            result.put("code", "0");
            result.put("msg", "验证码不正确");
            return result;
        }
        if (!resetPwdDto.getConfirmPassword().equals(resetPwdDto.getPassword())) {
            result.put("code", "0");
            result.put("msg", "两次输入密码不对应");
            return result;
        }
        userService.resetPwd(resetPwdDto.getEmailAddress(), resetPwdDto.getPassword());
        result.put("code", "1");
        result.put("msg", "success");
        return result;
    }

    @PostMapping("/login")
    public String login(User user, HttpSession session) {
        String loginResult = userService.login(user);
        if (loginResult.contains("login successfully!")) {
            // login success
            session.setAttribute("email", user.getEmailAddress());
            return "redirect:/page/home.html";
        }
        return "login";
    }

    @PostMapping("/regist")
    public String regist(User user) {
        String emailAddress = user.getEmailAddress();
        String mapCode = EmailConstant.EMAIL_CODE_MAP.get(emailAddress);
        String registResult = userService.regist(user);
        if (StringUtils.isEmpty(mapCode) || !mapCode.split("_")[0].equalsIgnoreCase(user.getVerificationCode())) {
            System.out.println(mapCode + "_" + user.getVerificationCode());
            return "regist";
        }
        System.out.println(registResult);
        if ("registered successfully".equals(registResult)) {
            return "redirect:/page/registSuccess.html";
        }
        return "regist";
    }

    /**
     * 解决查询数据库中文出现乱码问题
     *
     * @return
     */
    @GetMapping(value = "/alluser", produces = "application/json;charset=UTF-8")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/updateInfo")
    @ResponseBody
    public String updateInfo(@RequestBody User user, HttpSession session) {
        user.setEmailAddress((String) session.getAttribute("email"));
        int i = userService.updateUserInfo(user);
        return i > 0 ? "success" : "fail";
    }

}
package com.study.studentsys.controller;

import com.study.studentsys.component.EmailComponent;
import com.study.studentsys.constant.EmailConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@RequestMapping("/email")
@RestController
public class EmailController {

    @Autowired
    private EmailComponent emailComponent;



    @GetMapping("/sendcode")
    public String sendCode(@RequestParam("email") String email) {
        String mapCode = EmailConstant.EMAIL_CODE_MAP.get(email);
        if (!StringUtils.isEmpty(mapCode)) {
            long currentTime = Long.parseLong(mapCode.split("_")[1]);
            if (System.currentTimeMillis() - currentTime < 60000) {
                // 60s内不能重复发送
                return "60s 内不能重复发送";
            }
        }

        String randomCode = getRandomCode();
        String mapStorage = randomCode + "_" + System.currentTimeMillis();
        EmailConstant.EMAIL_CODE_MAP.put(email, mapStorage);

        // 发送邮件
        if (emailComponent.sendEmail(email, randomCode)) {
            return "send success";
        }

        return "send fail";

    }
    @GetMapping("/sendresetpwdcode")
    public String sendResetPwdCode(@RequestParam("email") String email, HttpSession session) {
        String resetMapCode = EmailConstant.EMAIL_CODE_MAP.get(email);
        if (!StringUtils.isEmpty(resetMapCode)) {
            long currentTime = Long.parseLong(resetMapCode.split("_")[1]);
            if (System.currentTimeMillis() - currentTime < 60000) {
                return "60s 内不能重复发送";
            }
        }

        String code = getRandomCode();
        String resetMapStorage = code + "_" + System.currentTimeMillis();
        EmailConstant.EMAIL_CODE_MAP.put(email, resetMapStorage);

        if (emailComponent.sendEmail(email, code)) {
            return "send success";
        }
        return "send fail";
    }


    public static String getRandomCode() {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(4);
        for (int i = 0; i < 4; i++) {
            char ch = str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
        return sb.toString();
    }

}


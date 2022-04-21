package com.study.studentsys.component;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Component;

@Component
public class EmailComponent {


    private String username = "1026884229@qq.com";
    private String password = "rghorssmnckkbebd";
    private String hostname = "smtp.qq.com";
    private String from = "1026884229@qq.com";
    private String sendname = "studentsys";
    private String subject = "studentsys mailbox verification";

    /**
     * 发送邮件验证码
     * @param emailAddress 发送的邮件地址（收件人地址）
     * @param code 邮件验证码
     * @return boolean 是否发送成功
     */
    public boolean sendEmail(String emailAddress, String code) {
        //创建一个HtmlEmail实例对象
        HtmlEmail htmlEmail = new HtmlEmail();
        // 设置邮箱的SMTP服务器
        htmlEmail.setHostName(hostname);
        // 设置发送的字符类型
        htmlEmail.setCharset("utf-8");
        try {
            // 设置接收人
            htmlEmail.addTo(emailAddress);
            // 设置发送人
            htmlEmail.setFrom(from, sendname);
            // 设置邮箱地址和客户端授权码
            htmlEmail.setAuthentication(username, password);
            // 设置邮件主题
            htmlEmail.setSubject(subject);
            // 发送的内容
            htmlEmail.setMsg("亲爱的<b>" + emailAddress + "</b>，您的邮件验证码为： <b>" + code + "</b>");
            // 发送
            htmlEmail.send();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSendname() {
        return sendname;
    }

    public void setSendname(String sendname) {
        this.sendname = sendname;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


}

package com.study.studentsys.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {

    private String emailAddress; //邮箱
    private String username; // 用户名
    private String password; //密码
    private String gender; // 性别
    //    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday; // 生日
    private String confirmPassword;
    private String verificationCode;
    public User() {
    }

    public User(String emailAddress, String username, String password, String confirmPassword,String gender, Date birthday) {
        this.emailAddress = emailAddress;
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.gender = gender;
        this.birthday = birthday;
        this.verificationCode = verificationCode;
    }


    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getconfirmPassword() {
        return confirmPassword;
    }

    public void setconfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "emailAddress='" + emailAddress + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
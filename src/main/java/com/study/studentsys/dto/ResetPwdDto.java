package com.study.studentsys.dto;

public class ResetPwdDto {

    private String emailAddress;
    private String verificationCode;
    private String password;
    private String confirmPassword;

    public ResetPwdDto() {
    }

    public ResetPwdDto(String emailAddress, String verificationCode, String password, String confirmPassword) {
        this.emailAddress = emailAddress;
        this.verificationCode = verificationCode;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}

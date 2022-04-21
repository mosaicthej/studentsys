package com.study.studentsys.service;

import com.study.studentsys.entity.User;
import com.study.studentsys.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public String login(User user){
        //登录逻辑函数
        try{
            User userExistN = userMapper.findByEmailAddress(user.getEmailAddress());
            if(userExistN!=null){
                String userExistP = userMapper.findPswByEmailAddress(user.getEmailAddress());
                if(userExistP.equals(user.getPassword())){
                    return user.getEmailAddress()+"login successfully!";
                }else {
                    return "The login failed. The password is incorrect!";
                }
            }else {
                return "Login failed. The user does not exist!";
            }
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String personaluser(User user) {

        return null;
    }
    public String regist(User user){
        //注册逻辑函数
        try {
            User userExist = userMapper.findByEmailAddress(user.getEmailAddress());
            if (user.getEmailAddress().equals("")){
                return "Email address can not be empty";
            }else if (user.getPassword().equals("")){
                return "Password can not be empty";
            }else if (user.getconfirmPassword().equals("")){
                return "Password can not be empty";
            }else if (!user.getconfirmPassword().equals(user.getPassword())){
                return "The passwords are inconsistent ";
            }else if (userExist!=null){
                return "The email address has been registered";
            }else{
                userMapper.save(user);
                return "registered successfully";
            }
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }

    }

    public List<User> findAll() {
        List<User> list = userMapper.findAll();
        return list;
    }

    public User getByEmail(String email) {
        User user = userMapper.findByEmailAddress(email);
        user.setEmailAddress(email);
        return user;
    }

    public void resetPwd(String emailAddress, String password) {
        userMapper.resetPwd(emailAddress, password);
    }

    public int updateUserInfo(User user) {
        return userMapper.updateUserInfoByEmail(user);
    }
}
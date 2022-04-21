package com.study.studentsys.mapper;

import com.study.studentsys.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    List<User> findAll();

    User findByEmailAddress(String EmailAddress);

    String findPswByEmailAddress(String EmailAddress);

    void save(User user);

    void resetPwd(@Param("email") String emailAddress, @Param("password") String password);

    int updateUserInfoByEmail(User user);
}
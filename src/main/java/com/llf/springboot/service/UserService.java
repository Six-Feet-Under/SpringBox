package com.llf.springboot.service;

import com.llf.springboot.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserService {

    List<User> selectList(User user);

    int deleteByKey(Map map);

    int insertkey(Map map);

    Map checkkey(Map map);

    User login(String name, String pwd);

    User selectById(Long id);

    void deleteUserById(Long id);

    void registerUser(User user);

    int updateUser(User user);

    int updateByKey(Map map);

    int isTrue(Long id );

}

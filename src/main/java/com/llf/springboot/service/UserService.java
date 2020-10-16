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

    User selectUserById(Long id);

    void deleteUserById(int id);

    void registerUser(User user);

    void updateUser(User user);

    int updateByKey(Map map);
}

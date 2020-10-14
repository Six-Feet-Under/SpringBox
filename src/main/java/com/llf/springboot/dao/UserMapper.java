package com.llf.springboot.dao;

import com.llf.springboot.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {

    List<User> selectList(User user);

    int deleteByKey(Map map);

    int insertkey(Map map);
    
    Map checkkey(Map map);

    int updateByKey(Map map);

}

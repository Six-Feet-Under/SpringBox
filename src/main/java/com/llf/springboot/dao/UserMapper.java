package com.llf.springboot.dao;

import com.llf.springboot.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {

    List<User> selectList(User user);

    int deleteByKey(Map map);

    int insertkey(Map map);

    List<User>  selectPageAll(int pageNum,int countNum,String key);

    Integer count();

    Map checkkey(Map map);

    int updateByKey(Map map);

    User login(@Param("name") String name,@Param("pwd") String pwd);

    void deleteUserById(Long id);

    User selectById(Long id);

    void registerUser(User user);

    int updateUser(User user);

    int isTrue(Long id);

    void batchDeletes(List delList);

    int insertUser(Map map);
}

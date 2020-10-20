package com.llf.springboot.service;

import com.llf.springboot.dao.UserMapper;
import com.llf.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> selectList(User user) {
		return userMapper.selectList(user);
	}

	@Override
	public int deleteByKey(Map map) {
		return userMapper.deleteByKey(map);
	}

	@Override
	public int insertkey(Map map) {
		Map map1=checkkey(map);
		if (map1 == null) {
			userMapper.insertkey(map);
			return 1;
		} else {
			Long times = Long.valueOf(map1.get("time").toString());
			Long time =  Long.valueOf(map.get("time").toString());
			if(times<time) {
				userMapper.updateByKey(map);
				return 2;
			}else {
				return 0;
			}
		}
	}

	@Override
	public Map checkkey(Map map) {
		// TODO Auto-generated method stub
		return userMapper.checkkey(map);
	}

	@Override
	public User login(String name, String pwd) {
		return userMapper.login(name,pwd);
	}

	@Override
	public User selectById(Long id) {
		return userMapper.selectById(id);
	}


	@Override
	public void deleteUserById(Long id){
		userMapper.deleteUserById(id);
	}

	@Override
	public void registerUser(User user) {
		userMapper.registerUser(user);
	}

	@Override
	public int updateUser(User user) {
		try {
			userMapper.updateUser(user);
			return 1;
		}catch (Exception e){
			return 0 ;
	}}

	@Override
	public int updateByKey(Map map) {
		try {
			userMapper.updateByKey(map);
			return 1;
		} catch (Exception e){
			return 0;
		}
	}

	@Override
	public int isTrue(Long id) {
		return userMapper.isTrue(id);
	}

	@Override
	public void batchDeletes(List delList) {
		 userMapper.batchDeletes(delList);
	}

	@Override
	public int insertUser(Map map) {

		return	userMapper.insertUser(map);

	}
}

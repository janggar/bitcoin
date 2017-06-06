package com.yunhai.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunhai.dao.automatic.UserMapper;
import com.yunhai.model.automatic.User;
import com.yunhai.service.IUserService;


@Service
public class UserServiceImpl implements IUserService {

	private static Logger log =LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User getUserById(Long userId){
		return userMapper.selectByPrimaryKey(userId);
	}
	
	public static void main(String[] args) {
		log.debug("debug级别测试");
		log.info("info级别测试");
		log.warn("warn级别测试");
		log.error("error级别测试");
		log.trace("debug级别测试");
	}
}

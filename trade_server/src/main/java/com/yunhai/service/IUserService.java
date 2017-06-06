package com.yunhai.service;

import com.yunhai.model.automatic.User;

/**
 * 用户接口
 * @author Jiayanxing
 * @date 2017年1月22日 上午11:43:01
 */
public interface IUserService {

	/**
	 * 根据用户id获取用户
	 * 
	 * @param userId
	 *            用户id
	 * @return
	 */
	public User getUserById(Long userId);
}

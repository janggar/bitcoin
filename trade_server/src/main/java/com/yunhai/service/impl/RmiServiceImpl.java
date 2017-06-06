package com.yunhai.service.impl;

import org.springframework.stereotype.Service;

import com.yunhai.service.IRmiService;

@Service
public class RmiServiceImpl implements IRmiService {

	@Override
	public String testSpringRmi() {
		String str ="这是spring-rmi server端发送来的消息---------->>>>>>>>>>>>>>>学习spring rmi用。";
		return str;
	}
}

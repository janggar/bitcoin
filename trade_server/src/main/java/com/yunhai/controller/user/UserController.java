package com.yunhai.controller.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yunhai.controller.BaseController;
import com.yunhai.model.automatic.User;
import com.yunhai.service.IUserService;

@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController{

	private Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private IUserService userServiece;

	@RequestMapping(value = "/toUser")
	public String toUser(HttpServletRequest request, HttpServletResponse response) {
		log.info("UserController类的toUser方法：开始=====");
		log.info("UserController类的toUser方法：结束=====");
		request.setAttribute("name", "jiayanxing");
		return "user/user";
	}

	@RequestMapping(value = "/getUser")
	public void getUser(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("userId") long userId) throws IOException {
		log.info("UserController类的getUser方法：开始=====");
		List<User> userList = new ArrayList<User>();
		Map<String, Object> resultMap = new HashMap<String,Object>();
		User user;
		try {
			user = userServiece.getUserById(userId);
			userList.add(user);
			resultMap.put("success", true);
			resultMap.put("userList", userList);
			log.info("UserController类的getUser方法执行成功=====resultMap:  "+resultMap);
		} catch (Exception e) {
			resultMap.put("success", false);
			log.error("UserController类的getUser方法出现错误=====:  "+e);
			e.printStackTrace();
		}finally{
			this.printJson(userList, response);
		}
	}

}

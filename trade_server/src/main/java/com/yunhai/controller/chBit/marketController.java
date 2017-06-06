package com.yunhai.controller.chBit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yunhai.controller.BaseController;
import com.yunhai.model.automatic.User;

@Controller
@RequestMapping(value = "/market")
public class marketController extends BaseController{

	private Logger log = LoggerFactory.getLogger(marketController.class);

	@Autowired
//	private IUserService userServiece;

	@RequestMapping(value = "/toKline")
	public String toKline(HttpServletRequest request, HttpServletResponse response) {
		log.info("UserController类的toKline方法：开始=====");
		log.info("UserController类的toKline方法：结束=====");
		return "chBtc/market/kline";
	}

	@RequestMapping(value = "/getKlineData")
	public void getKlineData(HttpServletRequest request, HttpServletResponse response){
		log.info("getKlineData方法：开始=====");
		List<User> userList = new ArrayList<User>();
		Map<String, Object> resultMap = new HashMap<String,Object>();
		try {
			resultMap.put("success", true);
			log.info("getKlineData方法执行成功=====resultMap:  "+resultMap);
		} catch (Exception e) {
			resultMap.put("success", false);
			log.error("getKlineData方法出现错误=====:  "+e);
			e.printStackTrace();
		}finally{
			this.printJson(userList, response);
		}
	}

}

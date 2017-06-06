package com.yunhai.controller.capital;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yunhai.bitccy.service.IBtc38CapitalService;
import com.yunhai.controller.BaseController;
import com.yunhai.model.automatic.User;
import com.yunhai.vo.Btc38CapitalVO;

@Controller
@RequestMapping(value="/capital")
public class UserCapitalController extends BaseController{
	
	private Logger log = LoggerFactory.getLogger(UserCapitalController.class);
	
	@Resource
	private IBtc38CapitalService  btc38CapitalServiceImpl;
	/**
	 * 
	 * @description 跳转至用户资产页
	 * @param request
	 * @param response
	 * @return ModelAndView
	 */
	@RequestMapping("/toCapital")
	public String toUserCapital(HttpServletRequest request,HttpServletResponse response){
		return "capital/userCapital";
	}
	
	/**
	 * 
	 * @description 跳转至用户资产页
	 * @param request
	 * @param response
	 * @return ModelAndView
	 */
	@RequestMapping("/get/Capital/list")
	public void getCapitalList(HttpServletRequest request,HttpServletResponse response){
		log.info("UserCapitalController类的getCapitalList方法：开始=====");
		Map<String, Object> resultMap = new HashMap<String,Object>();
		try {
			List<Btc38CapitalVO> capitalList = btc38CapitalServiceImpl.getAccountBalance();
			resultMap.put("success", true);
			resultMap.put("capitalList", capitalList);
			log.info("UserCapitalController类的getCapitalList方法执行成功=====resultMap:  "+resultMap);
		} catch (Exception e) {
			resultMap.put("success", false);
			log.error("UserCapitalController类的getCapitalList方法出现错误=====:  "+e);
			e.printStackTrace();
		}finally{
			this.printJson(resultMap, response);
		}
	}
	
}

package com.yunhai.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunhai.controller.user.UserController;

/**
 * 所有action的基类，都要继承此类
 * @author Jiayanxing
 * @date 2017年2月24日 下午6:35:03
 */
public class BaseController {
	
	private Log log = LogFactory.getLog(UserController.class);
	
	protected ObjectMapper mapper = new ObjectMapper();
	
	/**
	 * 将对象转换成json对象输出，一般用于ajax请求返回数据至前端
	 * @param 
	 * @param object 返回的数据对象	
	 * @param response 请求对应的response
	 */
	public void printJson(Object object,HttpServletResponse response){
		OutputStream writer = null;
		try {
			StringWriter stringWriter = new StringWriter();
			mapper.writeValue(stringWriter, object);
			response.setContentType("text/html;charset=utf-8");
			writer = response.getOutputStream();
			writer.write(stringWriter.toString().getBytes("UTF-8"));
		} catch (IOException e) {
			log.error(e);
		} finally {
			if (null != writer) {
				try {
					writer.flush();
					writer.close();
				} catch (IOException e) {
					log.error(e);
				}
			}
		}
	}
	
	/**
	 * 获取session 对象
	 * @param 
	 * @param request
	 * @return
	 */
	public HttpSession getSession(HttpServletRequest request){
		return request.getSession();
	}
	
}

package user;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yunhai.model.automatic.User;
import com.yunhai.service.IUserService;

import common.BaseTest;

public class UserServiceTest extends BaseTest{
	
	private Logger log =LoggerFactory.getLogger(UserServiceTest.class);
	
	@Autowired
	private IUserService userServiece;
	
	@Test
	public void getUserById(){
		log.info("===============  getUserById 测试 start==============");
//		System.out.println("===============  getUserById 测试 start==============");
		User user = userServiece.getUserById(1l);
		System.out.println("===============测试 user:"+user.getLoginName());
//		System.out.println("===============  getUserById 测试  end==============");
		log.info("===============  getUserById 测试  end==============");
	}
}

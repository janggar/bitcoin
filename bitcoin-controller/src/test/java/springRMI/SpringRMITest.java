package springRMI;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yunhai.service.IRmiService;

import common.BaseTest;
import user.UserServiceTest;

public class SpringRMITest  extends BaseTest {

	private Logger log =LoggerFactory.getLogger(UserServiceTest.class);
	
	@Autowired
	private  IRmiService rmiServiceImpl;
	
	@Test
	public void rmiService(){
		log.info("===============  spring  rmi 测试 start==============");
		rmiServiceImpl.testSpringRmi();
		log.info("===============  spring  rmi 测试 end==============");
	}
}

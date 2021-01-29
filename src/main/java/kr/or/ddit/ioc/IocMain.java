package kr.or.ddit.ioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.repository.UserDao;
import kr.or.ddit.user.service.UserService;

public class IocMain {
    private static final Logger logger = LoggerFactory.getLogger(IocMain.class); 
	
	public static void main(String[] args) {
	    // 1. ������ ���� ������ �̿��Ͽ� ������ �����̳ʸ� ����(kr/or/ddit/ioc/ioc.xml)		
		// 2. ������ �����̳ʿ��� ������� ������ ��(��ü)�� ��û 
		//    DL(Dependency Lookup): ������ �����̳ʿ��� ������ ���� ��û�ϴ� ���� 
		//	  IOC, DL / DI
		// 3. ������ �����̳ʿ��� �����ǰ� �ִ� ���� �� ��������ִ��� Ȯ�� 
		
		// 1�� ���� 
		ApplicationContext context 
		= new ClassPathXmlApplicationContext("classpath:/kr/or/ddit/ioc/ioc.xml");
		
		// 2�� ���� DL
		UserDao userDao = (UserDao)context.getBean("userDao");
		UserVo userVo = userDao.getUser("brown");
		
		// 3�� ���� 
		logger.debug("userVo : {}", userVo );
		
		// ������ �����̳ʷκ��� userService ������ ���� DL�� ���� ��� ����,- getUser �޼ҵ带 call, -��ȯ�� �� (UserVo)�� logger�� ���� ���
		
	    UserService userService = (UserService)context.getBean("userService");
	    UserVo userVo1= userService.getUser("brown");
	    logger.debug("userVo1: {}", userVo1);
	    
	    
	    
	    for(String beanName:context.getBeanDefinitionNames()) {
	    	logger.debug("beanName : {}", beanName);
	    }
	}
}














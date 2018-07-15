package com.yang.myapp.spring4;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainByXml {
	
	@Test
	public void testMainByXml(){
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:META-INF/spring4/ch02-config.xml");
	
		AuthenticationService authSvc = 
				ctx.getBean("authenticationService", AuthenticationService.class);
		
		try {
			authSvc.authenticate("yang", "1234");
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		ctx.close();
	
	}
	
}

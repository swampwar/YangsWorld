package com.yang.myapp.spring4;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainByXml {
	
	@Test
	public void testMainByXml(){
		GenericXmlApplicationContext ctx =
//				new GenericXmlApplicationContext("classpath:/META-INF/spring4/ch02-config.xml");
				new GenericXmlApplicationContext("file:src/main/resources/META-INF/spring4/ch02-config.xml");
	
		AuthenticationService authSvc = 
				ctx.getBean("authenticationService", AuthenticationService.class);
		
		try {
			authSvc.authenticate("yang", "1234");
			runAuthAndCatchAuthEx(authSvc, "yang", "1234");
			runAuthAndCatchAuthEx(authSvc, "yang", "12345");
			
			PasswordChangeService pwChgSvc = ctx.getBean("pwChangeSvc", PasswordChangeService.class);
			pwChgSvc.changePassword("yang", "1234", "12345");
			runAuthAndCatchAuthEx(authSvc, "yang", "1234");
			runAuthAndCatchAuthEx(authSvc, "yang", "123");
			runAuthAndCatchAuthEx(authSvc, "yang", "123");
			runAuthAndCatchAuthEx(authSvc, "yang", "123");
			
			ctx.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		ctx.close();
	
	}
	
	private void runAuthAndCatchAuthEx(
			AuthenticationService svc, String id, String pw) {
		
		try {
			svc.authenticate(id, pw);
		} catch (Exception e) {
			
		}
		
		
	}
	
}

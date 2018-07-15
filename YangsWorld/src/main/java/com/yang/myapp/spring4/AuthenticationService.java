package com.yang.myapp.spring4;

import javax.security.sasl.AuthenticationException;

public class AuthenticationService {

	private UserRepository userRepository;
	private AuthFailLogger failLogger;
	
	public AuthInfo authenticate(String id, String password) throws Exception {
		User user = userRepository.findUserById(id);
		
		if(user == null) throw new Exception("아이디에 해당하는 사용자가 존재하지 않음");
		
		if(!user.mathPassword(password)) {
			failLogger.insertBadPw(user.getId(), password);
			throw new AuthenticationException();
		}
		
		return new AuthInfo(user.getId());
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void setFailLogger(AuthFailLogger failLogger) {
		this.failLogger = failLogger;
	}
	
}

package com.yang.myapp.spring4;

public class PasswordChangeService {

	private UserRepository userRepository;
	
	public PasswordChangeService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void changePassword(String userId, String oldPw, String newPw) throws Exception {
		User user = userRepository.findUserById(userId);
		if(user == null) throw new Exception("아이디에 해당하는 사용자가 존재하지 않음");
	
		user.changePassword(oldPw, newPw);
	}
}

package com.yang.myapp.spring4;

public class AuthFailLogger {

	private int threshold;
	private int failCounts;
	
	public int getFailCounts() {
		return failCounts;
	}

	public void setFailCounts(int failCounts) {
		this.failCounts = failCounts;
	}

	public int getThreshold() {
		return threshold;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

	public void insertBadPw(String userId, String userPw) {
		System.out.printf("AuthFail [type=badpw, userid=%s, pw=%s]\n", userId, userPw);
		failCounts++;
		
		if(threshold > 0 && failCounts > threshold) {
			notifyTooManyFail();
		}
	}
	
	private void notifyTooManyFail() {
		System.out.println("너무 많은 로그인 시도 실패");
	}
	
}

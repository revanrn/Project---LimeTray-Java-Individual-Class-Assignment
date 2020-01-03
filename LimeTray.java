package com.deloitte.library.model;

public class LimeTray {
	private String userName;
	private String userId;
	private String password;
	private long phone;
	private String email;

	@Override
	public String toString() {
		return "LimeTray [userName=" + userName + ", userId=" + userId + ", password=" + password + ", phone=" + phone
				+ ", email=" + email + "]";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

package com.deloitte.library.services;

import java.util.*;


import com.deloitte.library.dao.LimeTrayDAO;
import com.deloitte.library.model.LimeTray;

public class LimeTrayServiceImpl implements LimeTrayInterfaceServices {

	@Override
	public void createUsers(String name, String userId, String password, long number1, String email) {
		// TODO Auto-generated method stub
		LimeTray obj = new LimeTray();
		obj.setUserName(name);
		obj.setUserId(userId);
		obj.setPassword(password);
		obj.setPhone(number1);
		obj.setEmail(email);
		LimeTrayDAO.addUsers(obj);
	}

	@Override
	public boolean signIn(String userId, String password) {
		// TODO Auto-generated method stub
		return LimeTrayDAO.signIn(userId, password);
	}

	@Override
	public List<LimeTray> displayUsers() {
		// TODO Auto-generated method stub
		return LimeTrayDAO.displayUsers();
	}

}

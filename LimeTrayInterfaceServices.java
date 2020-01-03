package com.deloitte.library.services;

import java.util.*;

import com.deloitte.library.model.LimeTray;

public interface LimeTrayInterfaceServices {
	public void createUsers(String name, String userId, String password, long number, String email);

	public boolean signIn(String userId, String password);

	public List<LimeTray> displayUsers();
}

package com.deloitte.library.main;

import java.util.*;

import com.deloitte.library.model.LimeTray;
import com.deloitte.library.services.LimeTrayServiceImpl;

public class DemoLimeTray {
	public static void main(String atgs[]) {
		Scanner sc = new Scanner(System.in);
		List<LimeTray> list = new ArrayList<LimeTray>();
		while (true) {
			System.out.println("1.Sign up.");
			System.out.println("2.Sign in");
			System.out.println("3.Display all users.");
			System.out.println("4.Exit.");
			System.out.println("Please Enter your choice : ");
			String choice = sc.next();
			LimeTrayServiceImpl objmpl = new LimeTrayServiceImpl();
			switch (Integer.parseInt(choice)) {
			case 1:
				System.out.println("Enter User Name: ");
				String name = sc.next();
				System.out.println("Enter the User ID : ");
				String userId = sc.next();
				System.out.println("Enter Password: ");
				String password = sc.next();
				System.out.println("Enter the Phone Number : ");
				long phone = Long.parseLong(sc.next());
				System.out.println("Enter Email of the User: ");
				String email = sc.next();
				objmpl.createUsers(name, userId, password, phone, email);
				break;
			case 2:
				System.out.println("Enter the User ID : ");
				String userid = sc.next();
				System.out.println("Enter Password: ");
				String pasword = sc.next();
				boolean flag = objmpl.signIn(userid, pasword);
				if (flag)
					System.out.println("Welcome to LimeTray, hope you enjoy your meal! :)" + userid);
				else
					System.out.println("Invalid Details, please try with the correct username and password");
				break;
			case 3:
				list = objmpl.displayUsers();
				if(list.size()>0)
				{
				for (LimeTray obj : list) {
					System.out.println(obj);
				}}
				else
					System.out.println("No users in the database");
				break;
			case 4:
				sc.close();
				System.exit(0);
				break;

			}

		}
	}
}

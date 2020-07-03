package com.jfsfeb.assetmanagementsystem.factory;

import com.jfsfeb.assetmanagementsystem.dao.AdminDAO;
import com.jfsfeb.assetmanagementsystem.dao.AdminDAOImpl;
import com.jfsfeb.assetmanagementsystem.dao.UserDAO;
import com.jfsfeb.assetmanagementsystem.dao.UserDAOImpl;
import com.jfsfeb.assetmanagementsystem.services.AdminService;
import com.jfsfeb.assetmanagementsystem.services.AdminServiceImpl;
import com.jfsfeb.assetmanagementsystem.services.UserService;
import com.jfsfeb.assetmanagementsystem.services.UserServiceImpl;

public class Factory {
	private Factory() {
	}

	public static AdminDAO getAdminDAOImplInstance() {
		AdminDAO admindao = new AdminDAOImpl();
		return admindao;
	}

	public static UserDAO getUserDAOImplInstance() {
		UserDAO userdao = new UserDAOImpl();
		return userdao;
	}

	public static AdminService getAdminServiceImplInstance() {
		AdminService adminService = new AdminServiceImpl();
		return adminService;
	}

	public static UserService getUserServiceImplInstance() {
		UserService userService = new UserServiceImpl();
		return userService;
	}

}

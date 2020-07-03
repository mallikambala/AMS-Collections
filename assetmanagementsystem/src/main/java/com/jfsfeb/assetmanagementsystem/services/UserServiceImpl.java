package com.jfsfeb.assetmanagementsystem.services;

import java.util.ArrayList;
import java.util.List;

import com.jfsfeb.assetmanagementsystem.dao.UserDAO;
import com.jfsfeb.assetmanagementsystem.dao.UserDAOImpl;
import com.jfsfeb.assetmanagementsystem.dto.AssetInfoBean;
import com.jfsfeb.assetmanagementsystem.dto.RequestInfoBeans;
//import com.jfsfeb.assetmanagementsystem.dto.StatusBean;
import com.jfsfeb.assetmanagementsystem.dto.UserInfoBean;

public class UserServiceImpl implements UserService {
	private UserDAO dao = new UserDAOImpl();

	@Override
	public boolean registerUser(UserInfoBean user) {
		// TODO Auto-generated method stub
		return dao.registerUser(user);
	}

	@Override
	public UserInfoBean userAuthentication(String email, String password) {
		// TODO Auto-generated method stub
		return dao.userAuthentication(email, password);
	}

	@Override
	public ArrayList<AssetInfoBean> getAssetInfoBean() {
		// TODO Auto-generated method stub
		return dao.getAssetInfoBean();
	}

//	@Override
//	public StatusBean request(UserInfoBean user, AssetInfoBean asset) {
//		if (user != null && asset != null) {
//			return dao.request(user, asset);
//		}
//		return null;
//	}

	@Override
	public boolean requestAsset(int userId, String assetName, int quantity) {
		// TODO Auto-generated method stub
		return dao.requestAsset(userId, assetName, quantity);
	}

	@Override
	public List<RequestInfoBeans> viewAllAssets(int id) {
		return dao.viewAllAssets(id);
	}

}

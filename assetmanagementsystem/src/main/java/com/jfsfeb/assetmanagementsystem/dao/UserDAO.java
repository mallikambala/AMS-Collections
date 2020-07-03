package com.jfsfeb.assetmanagementsystem.dao;

import java.util.ArrayList;
import java.util.List;

import com.jfsfeb.assetmanagementsystem.dto.AssetInfoBean;
import com.jfsfeb.assetmanagementsystem.dto.RequestInfoBeans;
//import com.jfsfeb.assetmanagementsystem.dto.StatusBean;
import com.jfsfeb.assetmanagementsystem.dto.UserInfoBean;

public interface UserDAO {
	boolean registerUser(UserInfoBean user);

	UserInfoBean userAuthentication(String email, String password);

	ArrayList<AssetInfoBean> getAssetInfoBean();

	public boolean requestAsset(int userId, String assetName, int quantity);

	public List<RequestInfoBeans> viewAllAssets(int id);

	
}

package com.jfsfeb.assetmanagementsystem.services;

import java.util.List;

import com.jfsfeb.assetmanagementsystem.dto.AdminInfoBean;
import com.jfsfeb.assetmanagementsystem.dto.AssetInfoBean;
import com.jfsfeb.assetmanagementsystem.dto.RequestInfoBeans;
//import com.jfsfeb.assetmanagementsystem.dto.StatusBean;

public interface AdminService {
	public boolean validatedId(int id);

	public boolean validatedName(String name);

	public boolean validatedEmail(String email);

	public boolean validatedPassword(String password);

	boolean registerAdmin(AdminInfoBean admin);

	AdminInfoBean authenticateAdmin(String email, String password);

	boolean addAsset(AssetInfoBean assetinfobean);

	boolean removeAsset(int Asset_id);

	public List<AssetInfoBean> searchAsset(int id);

	public List<RequestInfoBeans> requestDetails();

	public boolean acceptRequest(int id, String name);



}

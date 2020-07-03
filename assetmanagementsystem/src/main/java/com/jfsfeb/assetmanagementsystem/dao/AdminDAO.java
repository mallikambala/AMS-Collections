package com.jfsfeb.assetmanagementsystem.dao;

import java.util.List;

import com.jfsfeb.assetmanagementsystem.dto.AdminInfoBean;
import com.jfsfeb.assetmanagementsystem.dto.AssetInfoBean;
//import com.jfsfeb.assetmanagementsystem.dto.StatusBean;
import com.jfsfeb.assetmanagementsystem.dto.RequestInfoBeans;

public interface AdminDAO {

	boolean registerAdmin(AdminInfoBean admin);

	AdminInfoBean authenticateAdmin(String email, String password);

	boolean addAsset(AssetInfoBean assetinfobean);

	boolean removeAsset(int Asset_id);

	List<AssetInfoBean> searchAsset(int id);

	public List<RequestInfoBeans> requestDetails();

	public boolean acceptRequest(int id, String name);

	// List<StatusBean> getStatusBean();

}

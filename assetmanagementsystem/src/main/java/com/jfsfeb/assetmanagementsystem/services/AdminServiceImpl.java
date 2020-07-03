package com.jfsfeb.assetmanagementsystem.services;

import java.util.List;

import com.jfsfeb.assetmanagementsystem.dao.AdminDAO;
import com.jfsfeb.assetmanagementsystem.dao.AdminDAOImpl;
import com.jfsfeb.assetmanagementsystem.dto.AdminInfoBean;
import com.jfsfeb.assetmanagementsystem.dto.AssetInfoBean;
import com.jfsfeb.assetmanagementsystem.dto.RequestInfoBeans;
//import com.jfsfeb.assetmanagementsystem.dto.StatusBean;
import com.jfsfeb.assetmanagementsystem.exception.AMSException;
import com.jfsfeb.assetmanagementsystem.validation.Validation;

public class AdminServiceImpl implements AdminService {
	private AdminDAO dao = new AdminDAOImpl();
	Validation valid = new Validation();

	@Override
	public boolean registerAdmin(AdminInfoBean admin) {
		return dao.registerAdmin(admin);
	}

	@Override
	public AdminInfoBean authenticateAdmin(String email, String password) {
		return dao.authenticateAdmin(email, password);
	}

	@Override
	public boolean addAsset(AssetInfoBean assetinfobean) {
		return dao.addAsset(assetinfobean);

	}

	@Override
	public boolean removeAsset(int Asset_id) {
		return dao.removeAsset(Asset_id);

	}

	@Override
	public boolean validatedId(int id) {
		return valid.validatedId(id);
	}

	@Override
	public boolean validatedName(String name) {
		return valid.validatedName(name);
	}

	@Override
	public boolean validatedEmail(String email) {
		return valid.validatedEmail(email);
	}

	@Override
	public boolean validatedPassword(String password) {
		return valid.validatedPassword(password);
	}

	@Override
	public List<AssetInfoBean> searchAsset(int id) {
		if (valid.validatedId(id)) {
			return dao.searchAsset(id);
		}
		throw new AMSException("Enter Correct Details");
	}

//	@Override
//	public List<StatusBean> getStatusBean() {
//
//		return dao.getStatusBean();
//	}

	@Override
	public List<RequestInfoBeans> requestDetails() {
		return dao.requestDetails();
	}

	@Override
	public boolean acceptRequest(int id, String name) {
		return dao.acceptRequest(id, name);
	}

}

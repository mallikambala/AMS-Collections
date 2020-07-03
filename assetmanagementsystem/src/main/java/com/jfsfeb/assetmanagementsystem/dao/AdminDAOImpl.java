package com.jfsfeb.assetmanagementsystem.dao;

import java.util.ArrayList;
import java.util.List;

import com.jfsfeb.assetmanagementsystem.dto.AdminInfoBean;
import com.jfsfeb.assetmanagementsystem.dto.AssetInfoBean;
import com.jfsfeb.assetmanagementsystem.dto.RequestInfoBeans;
import com.jfsfeb.assetmanagementsystem.exception.AMSException;
import com.jfsfeb.assetmanagementsystem.repository.DataBase;

public class AdminDAOImpl implements AdminDAO {

	private static final int Asset_id = 0;

	@Override
	public boolean registerAdmin(AdminInfoBean admin) {
		for (AdminInfoBean a1 : DataBase.ADMINDB) {
			if ((a1.getEmailId()).equals(admin.getEmailId())) {
				return false;
			}
		}
		DataBase.ADMINDB.add(admin);
		return true;
	}

	@Override
	public AdminInfoBean authenticateAdmin(String email, String password) {
		for (AdminInfoBean a2 : DataBase.ADMINDB) {
			if ((a2.getEmailId().equals(email)) && (a2.getPassword().equals(password))) {
				return a2;
			}
		}
		throw new AMSException("Invalid Credentials");
	}

	@Override
	public boolean addAsset(AssetInfoBean assetinfobean) {
		for (AssetInfoBean assetbean : DataBase.ASSETDB) {
			if (assetbean.getAsset_id() == assetinfobean.getAsset_id()) {
				return false;
			}
		}
		DataBase.ASSETDB.add(assetinfobean);
		return true;
	}

	@Override
	public boolean removeAsset(int Asset_id) {
		for (AssetInfoBean assetinf : DataBase.ASSETDB) {
			if (assetinf.getAsset_id() == Asset_id) {
				DataBase.ASSETDB.remove(assetinf);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<AssetInfoBean> searchAsset(int id) {
		ArrayList<AssetInfoBean> searchAsset = new ArrayList<AssetInfoBean>();

		for (AssetInfoBean beans : DataBase.ASSETDB) {

			if (beans.getAsset_id() == id) {
				searchAsset.add(beans);
			}

		}

		if (searchAsset.size() == 0) {

			throw new AMSException("Assets not found");
		}

		return searchAsset;
	}

	@Override
	public List<RequestInfoBeans> requestDetails() {

		List<RequestInfoBeans> requests = new ArrayList<RequestInfoBeans>();
		for (RequestInfoBeans requestBeans1 : DataBase.REQUESTDB) {
			requestBeans1.getUserId();
			requestBeans1.getUserName();
			requestBeans1.getAssetId();
			requestBeans1.getAssetName();
			requestBeans1.getStatus();

			requests.add(requestBeans1);

		}
		return requests;
	}

	@Override
	public boolean acceptRequest(int id, String name) {

		RequestInfoBeans requestInfo = new RequestInfoBeans();

		for (RequestInfoBeans accept : DataBase.REQUESTDB) {

			if (id == accept.getUserId()) {

				for (AssetInfoBean assetBean : DataBase.ASSETDB) {

					if (assetBean.getAsset_name().contentEquals(name)) {

						requestInfo.setUserId(id);
						requestInfo.setAssetName(name);
						String status = "true";
						requestInfo.setStatus(status);
						DataBase.REQUESTDB.add(requestInfo);
						return true;

					}

				}

			}

		}

		throw new AMSException("Accept is not valid");
	}

}

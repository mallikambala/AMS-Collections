package com.jfsfeb.assetmanagementsystem.repository;

import java.util.ArrayList;
import java.util.List;

import com.jfsfeb.assetmanagementsystem.dto.AdminInfoBean;
import com.jfsfeb.assetmanagementsystem.dto.AssetInfoBean;
import com.jfsfeb.assetmanagementsystem.dto.RequestInfoBeans;
import com.jfsfeb.assetmanagementsystem.dto.UserInfoBean;

public class DataBase {
	public static final List<AdminInfoBean> ADMINDB = new ArrayList<AdminInfoBean>();
	public static final List<UserInfoBean> USERDB = new ArrayList<UserInfoBean>();
	public static final ArrayList<AssetInfoBean> ASSETDB = new ArrayList<AssetInfoBean>();
//	public static List<RequestInfoBeans> requestBeans = new ArrayList<RequestInfoBeans>();
	public static final List<RequestInfoBeans> REQUESTDB = new ArrayList<RequestInfoBeans>();
	
	public static void addToDB() {

		// ADMINDETAILS
		AdminInfoBean adminInfoBean = new AdminInfoBean();
		adminInfoBean.setId(123);
		adminInfoBean.setName("malli");
		adminInfoBean.setEmailId("malli@gmail.com");
		adminInfoBean.setPassword("Malli@123");
		ADMINDB.add(adminInfoBean);

		// USERDETAILS
		UserInfoBean userinfobean = new UserInfoBean();
		userinfobean.setUserid(234);
		userinfobean.setUsername("raj");
		userinfobean.setEmail("raj@gmail.com");
		userinfobean.setPassword("raj234");
		USERDB.add(userinfobean);
		UserInfoBean userinfobean1 = new UserInfoBean();
		userinfobean1.setUserid(222);
		userinfobean1.setUsername("aravind");
		userinfobean1.setEmail("aravind@gmail.com");
		userinfobean1.setPassword("aravind");
		USERDB.add(userinfobean1);

		// ASSETDETAILS
		AssetInfoBean assetinfobean = new AssetInfoBean();
		assetinfobean.setAsset_id(100);
		assetinfobean.setAsset_name("mobile");
		assetinfobean.setPrice(20000);
		assetinfobean.setQuantity(5);
		ASSETDB.add(assetinfobean);

		AssetInfoBean assetinfobean1 = new AssetInfoBean();
		assetinfobean1.setAsset_id(200);
		assetinfobean1.setAsset_name("washingmachine");
		assetinfobean1.setPrice(30000);
		assetinfobean1.setQuantity(6);
		ASSETDB.add(assetinfobean1);

		AssetInfoBean assetinfobean2 = new AssetInfoBean();
		assetinfobean2.setAsset_id(300);
		assetinfobean2.setAsset_name("chair");
		assetinfobean2.setPrice(1000);
		assetinfobean2.setQuantity(50);
		ASSETDB.add(assetinfobean2);

		AssetInfoBean assetinfobean3 = new AssetInfoBean();
		assetinfobean3.setAsset_id(400);
		assetinfobean3.setAsset_name("table");
		assetinfobean3.setPrice(2000);
		assetinfobean3.setQuantity(20);
		ASSETDB.add(assetinfobean3);

		AssetInfoBean assetinfobean4 = new AssetInfoBean();
		assetinfobean4.setAsset_id(500);
		assetinfobean4.setAsset_name("laptop");
		assetinfobean4.setPrice(50000);
		assetinfobean4.setQuantity(3);
		ASSETDB.add(assetinfobean4);

		// REQUEST
//		RequestInfoBeans request = new RequestInfoBeans();

//		request.getAssetId();
//		request.getAssetName();
//		request.getUserId();
//		request.getUserName();
//		request.getQuantity();
//		request.getStatus();

	}
}

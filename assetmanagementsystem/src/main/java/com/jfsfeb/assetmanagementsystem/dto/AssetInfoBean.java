package com.jfsfeb.assetmanagementsystem.dto;

import java.io.Serializable;

import lombok.Data;

@Data

public class AssetInfoBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int Asset_id;
	private String Asset_name;
	private int price;
	private int quantity;

}

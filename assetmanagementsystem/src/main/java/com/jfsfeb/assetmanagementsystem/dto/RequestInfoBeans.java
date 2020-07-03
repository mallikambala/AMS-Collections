package com.jfsfeb.assetmanagementsystem.dto;

import java.io.Serializable;

import lombok.Data;
@Data
public class RequestInfoBeans implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;
	private String userName;
	private int assetId;
	private String assetName;
	private int quantity;
	private String status;

}

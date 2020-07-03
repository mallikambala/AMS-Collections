package com.jfsfeb.assetmanagementsystem.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@Data
public class AdminInfoBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String emailId;
	@ToString.Exclude
	private String password;

}

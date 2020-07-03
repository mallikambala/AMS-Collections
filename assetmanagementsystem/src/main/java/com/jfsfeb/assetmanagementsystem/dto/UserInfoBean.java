package com.jfsfeb.assetmanagementsystem.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@Data

public class UserInfoBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int Userid;
	private String Username;
	private String email;
	@ToString.Exclude
	private String password;

}

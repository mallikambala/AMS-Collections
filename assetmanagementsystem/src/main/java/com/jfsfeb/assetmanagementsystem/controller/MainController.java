package com.jfsfeb.assetmanagementsystem.controller;

import com.jfsfeb.assetmanagementsystem.repository.DataBase;

public class MainController {
	public static void main(String[] args) {
		DataBase.addToDB();

		Controller.Operations();
	}
}

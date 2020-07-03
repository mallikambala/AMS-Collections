package com.jfsfeb.assetmanagementsystem.controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.jfsfeb.assetmanagementsystem.dto.AdminInfoBean;
import com.jfsfeb.assetmanagementsystem.dto.AssetInfoBean;
import com.jfsfeb.assetmanagementsystem.dto.RequestInfoBeans;
//import com.jfsfeb.assetmanagementsystem.dto.StatusBean;
import com.jfsfeb.assetmanagementsystem.dto.UserInfoBean;
import com.jfsfeb.assetmanagementsystem.exception.AMSException;
import com.jfsfeb.assetmanagementsystem.factory.Factory;
import com.jfsfeb.assetmanagementsystem.services.AdminService;
//import com.jfsfeb.assetmanagementsystem.services.AdminServiceImpl;
import com.jfsfeb.assetmanagementsystem.services.UserService;
import com.jfsfeb.assetmanagementsystem.services.UserServiceImpl;
//import com.jfsfeb.assetmanagementsystem.validation.Validation;

import lombok.extern.log4j.Log4j;

@Log4j
public class Controller {
	private static Object id;

	public static void Operations() {


		boolean flag = false;
		int checkId = 0;
		String checkName = null;
		String checkEmail = null;
		String checkPassword = null;
		int Asset_id = 0;
		String Asset_name = null;

		AdminService service = Factory.getAdminServiceImplInstance();
		UserService service1 = new UserServiceImpl();

		Scanner scanner = new Scanner(System.in);
		do {
			try {
				log.info("<------------>ASSET MANAGEMENT SYSTEM<------------>");
				log.info("press 1 for ADMIN PAGE");
				log.info("press 2 for USER PAGE");
				log.info("press any other number to RELOAD");
				log.info("<_______________________________________>");
				int i = scanner.nextInt();
				switch (i) {
				case 1:

					do {
						try {
							log.info("<------------>ADMIN PAGE<------------>");
							log.info("Press 1 for ADMINISTRATION REGISTER");
							log.info("Press 2 for ADMINISTRATION LOGIN");
							log.info("Press 3 to EXIT");
							log.info("<_______________________________________>");
							int choice = scanner.nextInt();
							switch (choice) {

							case 1:
								do {
									try {
										log.info("Enter ID to Register as ADMIN : ");
										checkId = scanner.nextInt();
										service.validatedId(checkId);
										flag = true;
									} catch (InputMismatchException e) {
										log.error("ID should consist of only digits");
										flag = false;
										scanner.next();
									} catch (AMSException e) {
										flag = false;
										log.error(e.getMessage());
									}
								} while (!flag);
								do {
									try {
										log.info("Enter Name to Register : ");
										checkName = scanner.next();
										service.validatedName(checkName);
										flag = true;
									} catch (InputMismatchException e) {
										flag = false;
										log.error("Name should consists of only Alphabates");
									} catch (AMSException e) {
										flag = false;
										log.error(e.getMessage());
									}
								} while (!flag);

								do {
									try {
										log.info("Enter Email to Register : ");
										checkEmail = scanner.next();
										service.validatedEmail(checkEmail);
										flag = true;
									} catch (InputMismatchException e) {
										flag = false;
										log.error("Enter proper email such that it should consist of '@'");
									} catch (AMSException e) {
										flag = false;
										log.error(e.getMessage());
									}
								} while (!flag);
								do {
									try {
										log.info("Enter Password :");
										checkPassword = scanner.next();
										service.validatedPassword(checkPassword);
										flag = true;
									} catch (InputMismatchException e) {
										flag = false;
										log.error("Password doesnt accept spaces ");
									} catch (AMSException e) {
										flag = false;
										log.error(e.getMessage());
									}
								} while (!flag);

								AdminInfoBean bean = new AdminInfoBean();
								bean.setId(checkId);
								bean.setName(checkName);
								bean.setEmailId(checkEmail);
								bean.setPassword(checkPassword);

								boolean check = service.registerAdmin(bean);
								if (check) {
									log.info("You have registered Successfully");
								} else {
									log.info("Already registered");
								}
								break;

							case 2:
								log.info("Enter registered email to login : ");
								String email = scanner.next();
								log.info("Enter registered Password to login : ");
								String password = scanner.next();
								try {

									AdminInfoBean authBean = service.authenticateAdmin(email, password);
									log.info("You have logged in successfully");

									do {
										try {
											log.info("<--------------------------------------->");
											log.info("Press 1 to  ADD ASSET");
											log.info("Press 2 to  REMOVE ASSET");
											log.info("Press 3 to  VIEW ALL ASSET DETAILS");
											log.info("Press 4 to SEARCH ASSET");
											log.info("Press 5 to For ASSET REquest Details");
											log.info("Press 6 to LOGOUT");
											log.info("<_______________________________________>");
											int choice1 = scanner.nextInt();

											switch (choice1) {
											case 1:

												do {
													log.info("Enter Asset_id to add : ");
													Asset_id = scanner.nextInt();
													try {
														service.validatedId(Asset_id);
														flag = true;
													} catch (InputMismatchException e) {
														flag = false;
														log.error("Id should contains only digits");
													} catch (AMSException e) {
														flag = false;
														log.error(e.getMessage());
													}
												} while (!flag);
												do {
													log.info("Enter Asset_name : ");
													Asset_name = scanner.next();
													try {
														service.validatedName(Asset_name);
														flag = true;
													} catch (InputMismatchException e) {
														flag = false;
														log.error("should contains only Alphabets");
													} catch (AMSException e) {
														flag = false;
														log.error(e.getMessage());
													}
												} while (!flag);

												AssetInfoBean bean1 = new AssetInfoBean();
												bean1.setAsset_id(Asset_id);
												bean1.setAsset_name(Asset_name);
//												bean1.setprice(price);
//												bean1.setquantity(quantity);
												boolean check2 = service.addAsset(bean1);
												if (check2) {
													log.info("Asset added of id = " + Asset_id);
												} else {
													log.info("Asset already exist = " + Asset_id);
												}
												break;

											case 2:
												log.info("REMOVE ASSET ");
												log.info("ENTER ASSETID");
												int AssetId3 = scanner.nextInt();
												if (AssetId3 == 0) {
													log.info("Please Enter the Valid ASSETID");
												} else {
													AssetInfoBean bean6 = new AssetInfoBean();
													bean6.setAsset_id(AssetId3);
													boolean remove = service.removeAsset(AssetId3);
													if (remove) {
														log.info("The Asset is removed of Id = " + AssetId3);
													} else {
														log.info("The Asset is not removed of Id = " + AssetId3);
													}
												}
												break;
											case 3:

												ArrayList<AssetInfoBean> info = service1.getAssetInfoBean();

												for (AssetInfoBean AssetBean : info) {
													log.info("Asset id = " + AssetBean.getAsset_id());
													log.info("Asset name = " + AssetBean.getAsset_name());
													log.info("Asset price = " + AssetBean.getPrice());
													log.info("Asset quantity = " + AssetBean.getQuantity());
													log.info("___________________________");
												}
												break;

											case 4:
												log.info("SEARCH ASSET BY ID");
//												id = checkId();
												int id = scanner.nextInt();
												try {

													List<AssetInfoBean> search = service.searchAsset(id);

													if (search != null) {
														for (AssetInfoBean details : search) {
															log.info("Asset id = " + details.getAsset_id());
															log.info("Asset name = " + details.getAsset_name());
															log.info("Asset quantity = " + details.getQuantity());
															log.info("Asset price = " + details.getPrice());
														}

													}

												} catch (AMSException e) {

													System.err.println(e.getMessage());
												}

												break;

											case 5:

												log.info("Requested User details are:");

												List<RequestInfoBeans> requests = service.requestDetails();
												log.info("Total no. of requests : "+requests.size());
												for (RequestInfoBeans details : requests) {
													log.info("User id = " + details.getUserId());
													log.info("User name = " + details.getUserName());
													log.info("Asset id = " + details.getAssetId());
													log.info("Asset name = " + details.getAssetName());
													log.info("Asset status = " + details.getStatus());

												}
												break;

											case 6:
												Operations();

											default:
												log.info("Invalid Choice");
												break;
											}
										} catch (InputMismatchException e) {
											log.error("Invalid entry please provide only positive integer");
											scanner.nextLine();
										}
									} while (true);
								} catch (Exception e) {
									log.info("Invalid Credentials");
								}

							case 5:
								Operations();
								break;

							default:
								log.info("Invalid Choice");
								break;
							}
						} catch (InputMismatchException e) {
							log.error("Invalid entry please provide only positive integer");
							scanner.nextLine();
						}
					} while (true);

				case 2:

					do {
						try {
							log.info("<------------>USER PAGE<------------>");
							log.info("Press 1 for USER REGISTER");
							log.info("Press 2 for USER LOGIN");
							log.info("Press 3 to EXIT");
							log.info("<--------------------------------------->");
							int choice = scanner.nextInt();
							switch (choice) {
							case 1:

								do {
									try {
										log.info("Enter ID to Register as USER : ");
										checkId = scanner.nextInt();
										service.validatedId(checkId);
										flag = true;
									} catch (InputMismatchException e) {
										log.error("ID should consist of only digits");
										flag = false;
										scanner.next();
									} catch (AMSException e) {
										flag = false;
										log.error(e.getMessage());
									}
								} while (!flag);
								do {
									try {
										log.info("Enter Name to Register : ");
										checkName = scanner.next();
										service.validatedName(checkName);
										flag = true;
									} catch (InputMismatchException e) {
										flag = false;
										log.error("Name should consists of only Alphabates");
									} catch (AMSException e) {
										flag = false;
										log.error(e.getMessage());
									}
								} while (!flag);

								do {
									try {
										log.info("Enter Email to Register : ");
										checkEmail = scanner.next();
										service.validatedEmail(checkEmail);
										flag = true;
									} catch (InputMismatchException e) {
										flag = false;
										log.error(
												"Enter proper email such that it should consist of numbers and alphabets");
									} catch (AMSException e) {
										flag = false;
										log.error(e.getMessage());
									}
								} while (!flag);
								do {
									try {
										log.info("Enter Password :");
										checkPassword = scanner.next();
										service.validatedPassword(checkPassword);
										flag = true;
									} catch (InputMismatchException e) {
										flag = false;
										log.error("Password doesnt accept spaces");
									} catch (AMSException e) {
										flag = false;
										log.error(e.getMessage());
									}
								} while (!flag);
								UserInfoBean bean1 = new UserInfoBean();
								bean1.setUserid(checkId);
								bean1.setUsername(checkName);

								bean1.setEmail(checkEmail);
								bean1.setPassword(checkPassword);

								boolean check = service1.registerUser(bean1);
								if (check) {
									log.info("Registered Successfully");
								} else {
									log.info("Already registered");
								}
								break;

							case 2:
								UserInfoBean userInfo = new UserInfoBean();
								AssetInfoBean assetsInfo = new AssetInfoBean();
								log.info("Enter registered email to login : ");
								String email = scanner.next();
								log.info("Enter registered Password to login : ");
								String password = scanner.next();
								try {
									@SuppressWarnings("unused")
									UserInfoBean UserBean = service1.userAuthentication(email, password);
									log.info("Logged in Successfully");
									do {
										try {
											log.info(
													"<--------------------------------------------------------------------->");

											// log.info("Press 1 for SEARCH ASSET BY NAME");
											log.info("Press 1 to  VIEW ALL ASSETDETAILS");
											log.info("Press 2 to REQUEST THE ASSET");
											log.info("Press 3 to  LOGOUT");
											log.info(
													"<--------------------------------------------------------------------->");
											int choice2 = scanner.nextInt();
											switch (choice2) {

											case 1:
												ArrayList<AssetInfoBean> info = service1.getAssetInfoBean();
												log.info("<<<<_____YOUR ASSETS ARE____>>>>");

												for (AssetInfoBean AssetBean : info) {
													log.info("Asset id = " + AssetBean.getAsset_id());
													log.info("Asset name = " + AssetBean.getAsset_name());
													log.info("Asset category = " + AssetBean.getQuantity());
													log.info("Asset price = " + AssetBean.getPrice());
												}
												break;
											case 2:

												log.info("Add your required assets");

//												log.info("Enter user id");
//												int Userid = scanner.nextInt();
												int Userid = UserBean.getUserid();
												userInfo.setUserid(Userid);

												log.info("Enter asset name");
												String name = scanner.next();
												assetsInfo.setAsset_name(name.trim());

												log.info("Enter asset quantity");
												int quantity = scanner.nextInt();
												assetsInfo.setQuantity(quantity);

												log.info("Enter asset price");
												int price = scanner.nextInt();
												assetsInfo.setPrice(price);

												try {

													boolean status = service1.requestAsset(Userid, name, quantity);

													if (status) {

														service.acceptRequest(Userid, name);

														log.info("request accepted");

													} else {
														log.info("request not accepted");
													}

												} catch (AMSException e) {

													System.err.println(e.getMessage());

												}
												break;

											case 3:
												Operations();

											default:
												break;
											}
										} catch (InputMismatchException e) {
											log.error("please select valid option");
											scanner.nextLine();
										}
									} while (true);
								} catch (Exception e) {
									log.error("Invalid Credentials");
								}
								break;
							case 3:
								Operations();
								break;

							default:
								log.info("Invalid Choice");
								log.error("Choice must be 1 or 2");
								break;
							}
						} catch (InputMismatchException e) {
							log.error("Invalid entry");
							scanner.nextLine();
						}
					} while (true);
				}
			} catch (InputMismatchException e) {
				log.error("Invalid entry");
				scanner.nextLine();
				scanner.close();
			}
		} while (true);
	}

}

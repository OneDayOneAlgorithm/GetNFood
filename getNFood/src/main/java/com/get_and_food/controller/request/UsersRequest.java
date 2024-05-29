/*
 * 이상기
 * 2024-04-29 작성
 */
package com.get_and_food.controller.request;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

public class UsersRequest {

	@Data
	public static class create
	{
		private String loginId;
		private String password;
		private String userName;
		private String email;
		private String usePhone;
	}
	
	@Data
	public static class update
	{
		private String password;
		//private Long addressId;
		private String email;
		private String usePhone;
		private String address;
		private MultipartFile userPhoto;
	}
	
	@Data
	public static class changeAddr
	{
		private long addressId;
	}
	
	@Data
	public static class uploadBusiness
	{
		private Boolean isBusiness;
	}
	
	@Data
	public static class login
	{
		private String loginId;
		private String password;
	}
}

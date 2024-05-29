/*
 * 이상기
 * 2024-04-29 작성
 */
package com.get_and_food.controller.request;

import org.springframework.web.multipart.MultipartFile;

import com.get_and_food.domain.model.FoodCategory;

import lombok.Data;

public class StoreRequest {

	@Data
	public static class create
	{
		  private Long userId;
		  private String storeAddr;
		  private String storeName;
		  private String phoneNumber;
		  private FoodCategory foodCategory;
		  private String businessNumber;
	}
	
	
	@Data
	public static class update
	{
		
		private String storeName;
		private String storeContent;
		private String phoneNumber;
		private String storeAddr;
		private String operationTime;
		private String dayOff;
		private FoodCategory foodCategory;
		private String countryOfOrigin;
		private String businessNumber;
		private MultipartFile storePicture;
	}
}

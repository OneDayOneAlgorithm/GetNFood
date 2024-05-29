package com.get_and_food.controller.request;

import org.springframework.web.multipart.MultipartFile;

import lombok.*;

public class MenuRequest {
	@Data
	public static class Detail {
		private Long storeId;
		private String menuName;
		private int price;
		private int inventory;
		private String pickupTime;
		private String menuPictureUrl;
		private int discount;
		private MultipartFile menuPicture;
	}
}

package com.get_and_food.controller.request;

import lombok.Data;

public class OrderListRequest {
	@Data
	public static class Detail {
		private Long storeId;
		private Long userId;	
	}
}

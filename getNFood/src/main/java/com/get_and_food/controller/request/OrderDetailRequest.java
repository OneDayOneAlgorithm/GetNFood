package com.get_and_food.controller.request;

import lombok.Data;

public class OrderDetailRequest {
	@Data
	public static class Detail{
		private Long menuId;
		private Long orderListId;
	}
}

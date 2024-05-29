/*
 * 이상기
 * 2024-04-29 작성
 */
package com.get_and_food.controller.request;

import java.time.LocalDate;


import lombok.Data;

public class OrderRequest {
	
	@Data
	public static class create
	{
		private Long userId;
		private Long storeId;
		private Long orderListId;
		private String paymentMethod;
		private String requests;
		
	}
}

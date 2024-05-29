/*
 * 이상기
 * 2024-04-29 작성
 */
package com.get_and_food.controller.request;

import lombok.Data;

public class AddressRequest {

	@Data
	public static class create
	{
		private Long userId;
		private String address;
	}
}

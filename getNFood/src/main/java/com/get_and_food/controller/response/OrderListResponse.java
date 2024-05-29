package com.get_and_food.controller.response;

import com.get_and_food.domain.model.OrderList;
import com.get_and_food.domain.model.Stores;
import com.get_and_food.domain.model.Users;

import lombok.*;

public class OrderListResponse {
	@Data
	@Builder
	public static class Detail{
		private Long orderListId;
//		private StoreResponse.Detail store;
//		private UsersResponse.Detail user;
//		private int status;
		
		public static Detail of(OrderList orderList) {
			return Detail.builder()
					.orderListId(orderList.getOrderListId())
//					.store(StoreResponse.Detail.of(orderList.getStores()))
//					.user(UsersResponse.Detail.of(orderList.getUsers()))
					.build();
		}
	}
}

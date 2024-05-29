/*
 * 이상기
 * 2024-04-29 작성
 */
package com.get_and_food.controller.response;

import java.time.LocalDate;
import java.util.List;

import com.get_and_food.domain.model.OrderDetail;
import com.get_and_food.domain.model.OrderList;
import com.get_and_food.domain.model.Orders;
import com.get_and_food.domain.model.Stores;
import com.get_and_food.domain.model.Users;
import com.get_and_food.domain.repository.OrderDetailRepository;
import com.get_and_food.domain.repository.OrderListRepository;
import com.get_and_food.domain.repository.OrdersRepository;
import com.get_and_food.domain.repository.StoresRepository;
import com.get_and_food.domain.repository.UsersRepository;
import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrdersResponse {
	

	@Data
	@Builder
	public static class Detail
	{
		private Long orderId;
		private String storeName;
		private Long storeId;
		private String createDate;
		private int notDiscountPrice;
		private int discount;
		private int totalPrice;
		private String paymentMethod;
		private String phoneNumber;
		private String requests;
		private List<OrderDetail> orderDetails;
		
		public static Detail of(Orders order, Stores store, OrderList orderList, List<OrderDetail> orderDetails )
		{
			return Detail.builder()
					.orderId(order.getOrderId())
					.paymentMethod(order.getPaymentMethod())
					.requests(order.getRequests())
					.createDate(order.getCreateDate())
					.storeName(store.getStoreName())
					.orderDetails(orderDetails)
					.totalPrice(orderList.getTotalPrice())
					.storeId(store.getStoreId())
					.notDiscountPrice(orderList.getNotDiscountPrice())
					.phoneNumber(order.getUser().getUserPhone())
					.discount(orderList.getNotDiscountPrice() - orderList.getTotalPrice())
					.build();
		}
		
	}
	
	@Data
	@Builder
	public static class ListElem
	{
		private Long orderId;
		private String storeName;
		private int notDiscountPrice;
		private int discount;
		private int totalPrice;
		private List<OrderDetail> orderDetails;
		public static ListElem of(Orders order, List<OrderDetail> orderDetails)
		{
			return ListElem.builder()
					.orderId(order.getOrderId())
					.storeName(order.getStore().getStoreName())
					.totalPrice(order.getOrderListId().getTotalPrice())
					.notDiscountPrice(order.getOrderListId().getNotDiscountPrice())
					.discount(order.getOrderListId().getNotDiscountPrice() - order.getOrderListId().getTotalPrice())
					.orderDetails(orderDetails)
					.build();
		}
	}

	
	@Data
	@Builder
	public static class Price
	{
		private int notDiscountPrice;
		private int discount;
		private int totalPrice;

		
		public static Price of(OrderList orderList)
		{
			return Price.builder()
					.totalPrice(orderList.getTotalPrice())
					.notDiscountPrice(orderList.getNotDiscountPrice())
					.discount(orderList.getNotDiscountPrice() - orderList.getTotalPrice())
					.build();
		}
		
	}
	

}

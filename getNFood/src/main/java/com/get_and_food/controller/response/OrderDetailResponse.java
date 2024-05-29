package com.get_and_food.controller.response;


import java.util.ArrayList;
import java.util.List;
import com.get_and_food.domain.model.Menu;
import com.get_and_food.domain.model.OrderDetail;
import com.get_and_food.domain.model.OrderList;
import com.get_and_food.domain.model.Stores;

import lombok.*;

public class OrderDetailResponse {
	
	@Data
    @Builder
    public static class Detail{
		private Long orderDetailId;
		private OrderList orderList;
		private Menu menu;
		private int amount;
		
		public static Detail of(OrderDetail orderDetail) {
			return Detail.builder()
					.orderDetailId(orderDetail.getOrderDetailId())
					.orderList(orderDetail.getOrderList())
					.menu(orderDetail.getMenu())
					.amount(orderDetail.getAmount())
					.build();
					
		}
	}
	
	@Data
	@Builder
	public static class Details {
	    
	    private Long orderListId;
	    private String storeName;
	    private Long storeId;
	    private int notDiscountPrice;
	    private int discount;
	    private int totalPrice;
	    private List<OrderDetail> orderDetails;
	    
	    public static Details of(OrderList orderList, List<OrderDetail> orderDetails, Stores store) {
	        // OrderDetails 정보 생성
	        List<OrderDetail> orderDetailsList = new ArrayList<>();
	        for (OrderDetail orderDetail : orderDetails) {
	            orderDetailsList.add(OrderDetail.builder()
	                                            .orderDetailId(orderDetail.getOrderDetailId())
	                                            .amount(orderDetail.getAmount())
	                                            .menu(orderDetail.getMenu())
	                                            .build());
	        }
	        
	        
	        // Details 객체 생성
	        return Details.builder()
	                      .orderListId(orderList.getOrderListId())
	                      .storeId(store.getStoreId())
	                      .storeName(store.getStoreName())
	                      .totalPrice(orderList.getTotalPrice())
	                      .notDiscountPrice(orderList.getNotDiscountPrice())
	                      .discount(orderList.getNotDiscountPrice() - orderList.getTotalPrice())
	                      .orderDetails(orderDetailsList)
	                      .build();
	    }
	}
	

}

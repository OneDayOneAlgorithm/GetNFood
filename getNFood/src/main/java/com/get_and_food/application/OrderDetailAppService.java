package com.get_and_food.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.get_and_food.controller.request.OrderDetailRequest;
import com.get_and_food.controller.request.OrderDetailRequest.Detail;
import com.get_and_food.controller.response.OrdersResponse;
import com.get_and_food.domain.model.Menu;
import com.get_and_food.domain.model.OrderDetail;
import com.get_and_food.domain.model.OrderList;
import com.get_and_food.domain.repository.MenuRepository;
import com.get_and_food.domain.repository.OrderDetailRepository;
import com.get_and_food.domain.repository.OrderListRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderDetailAppService {
	private final OrderDetailRepository orderDetailRepository;
	private final MenuRepository menuRepository;
	private final OrderListRepository orderListRepository;
	
	public OrdersResponse.Price plusAmount(Long orderDetailId) {
		OrderDetail orderDetail = orderDetailRepository.findById(orderDetailId).orElseThrow();
		Menu menu = orderDetail.getMenu();
		int inventory = menu.getInventory();
		if(orderDetail.getAmount() < inventory) {
			orderDetail.setAmount(orderDetail.getAmount()+1);
			orderDetailRepository.save(orderDetail);
			OrderList orderList = orderDetail.getOrderList();
			int totalPrice = 0;
			int notDiscountPrice = 0;
		    List<OrderDetail> orderDetails = orderDetailRepository.findByOrderList(orderList);
		    for (OrderDetail detail : orderDetails) {
		        // orderDetail의 menuId에 해당하는 Menu 객체 조회
		        Menu detailMenu = detail.getMenu();
		        if (detailMenu != null) {
		            // Menu 객체의 nowPrice를 totalPrice에 더함
		            totalPrice += detailMenu.getNowPrice() * detail.getAmount();
		            notDiscountPrice += detailMenu.getPrice() * detail.getAmount();
		        }
		    }
		    // 계산된 totalPrice를 orderList에 설정
		    orderList.setTotalPrice(totalPrice);
		    orderList.setNotDiscountPrice(notDiscountPrice);
		    orderListRepository.save(orderList);
			return OrdersResponse.Price.of(orderList);
		}
		return null;
	}
	
	public OrdersResponse.Price minusAmount(Long orderDetailId) {
		OrderDetail orderDetail = orderDetailRepository.findById(orderDetailId).orElseThrow();
		if(orderDetail.getAmount()>1) {
		orderDetail.setAmount(orderDetail.getAmount()-1);
		orderDetailRepository.save(orderDetail);
		OrderList orderList = orderDetail.getOrderList();
		int totalPrice = 0;
		int notDiscountPrice = 0;
	    List<OrderDetail> orderDetails = orderDetailRepository.findByOrderList(orderList);
	    for (OrderDetail detail : orderDetails) {
	        // orderDetail의 menuId에 해당하는 Menu 객체 조회
	        Menu detailMenu = detail.getMenu();
	        if (detailMenu != null) {
	            // Menu 객체의 nowPrice를 totalPrice에 더함
	            totalPrice += detailMenu.getNowPrice() * detail.getAmount();
	            notDiscountPrice += detailMenu.getPrice() * detail.getAmount();
	        }
	    }
	    // 계산된 totalPrice를 orderList에 설정
	    orderList.setTotalPrice(totalPrice);
	    orderList.setNotDiscountPrice(notDiscountPrice);
	    orderListRepository.save(orderList);
		return OrdersResponse.Price.of(orderList);
	}
		return null;
	}
	
	public Boolean deleteOrderDetail(Long orderDetailId) {
		OrderDetail orderDetail = orderDetailRepository.findById(orderDetailId).orElseThrow();
		OrderList orderList = orderDetail.getOrderList();
		orderDetailRepository.delete(orderDetail);
		int totalPrice = 0;
		int notDiscountPrice = 0;
		List<OrderDetail> orderDetails = orderDetailRepository.findByOrderList(orderList);
	    for (OrderDetail detail : orderDetails) {
	        // orderDetail의 menuId에 해당하는 Menu 객체 조회
	        Menu detailMenu = detail.getMenu();
	        if (detailMenu != null) {
	            // Menu 객체의 nowPrice를 totalPrice에 더함
	            totalPrice += detailMenu.getNowPrice() * detail.getAmount();
	            notDiscountPrice += detailMenu.getPrice() * detail.getAmount();
	        }
	    }
	    orderList.setTotalPrice(totalPrice);
	    orderList.setNotDiscountPrice(notDiscountPrice);
	    orderListRepository.save(orderList);		
		return true;
		
	}

	public Boolean createOrderDetail(OrderDetailRequest.Detail request) {
		Menu menu = menuRepository.findById(request.getMenuId()).orElseThrow();
		OrderList orderList = orderListRepository.findById(request.getOrderListId()).orElseThrow();
		OrderDetail existedMenu = orderDetailRepository.findByOrderListAndMenu(orderList,menu);
		if(existedMenu!=null) {
			return false;
		}
		// TODO Auto-generated method stub
		OrderDetail orderDetail = OrderDetail.builder()
									.menu(menu)
									.orderList(orderList)
									.amount(1)
									.build();
		orderDetailRepository.save(orderDetail);
		int totalPrice = 0;
		int notDiscountPrice = 0;
	    List<OrderDetail> orderDetails = orderDetailRepository.findByOrderList(orderList);
	    for (OrderDetail detail : orderDetails) {
	        // orderDetail의 menuId에 해당하는 Menu 객체 조회
	        Menu detailMenu = detail.getMenu();
	        if (detailMenu != null) {
	            // Menu 객체의 nowPrice를 totalPrice에 더함
	            totalPrice += detailMenu.getNowPrice();
	            notDiscountPrice += detailMenu.getPrice();
	        }
	    }
	    // 계산된 totalPrice를 orderList에 설정
	    orderList.setTotalPrice(totalPrice);
	    orderList.setNotDiscountPrice(notDiscountPrice);
	    orderListRepository.save(orderList);
		return true;
	}
	
}

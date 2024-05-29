package com.get_and_food.application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.mail.Store;

import org.springframework.stereotype.Service;

import com.get_and_food.controller.request.OrderRequest;
import com.get_and_food.controller.response.OrdersResponse;
import com.get_and_food.controller.response.OrdersResponse.Detail;
import com.get_and_food.domain.model.Menu;
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

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrdersAppService {
	private final UsersRepository usersRepository;
	private final StoresRepository storesRepository;
	private final OrderListRepository orderListRepository;
	private final OrdersRepository ordersRepository;
	private final OrderDetailRepository orderDetailRepository;
	
	public OrdersResponse.Detail createOrder(OrderRequest.create request){
		Users user = usersRepository.findById(request.getUserId()).orElseThrow();
		Stores store = storesRepository.findById(request.getStoreId()).orElseThrow();
		OrderList orderList = orderListRepository.findById(request.getOrderListId()).orElseThrow();
		List<OrderDetail> orderDetails = orderDetailRepository.findByOrderList(orderList);
		for(OrderDetail orderDetail:orderDetails) {
			int amount = orderDetail.getAmount();
			Menu menu = orderDetail.getMenu();
			if(menu.getInventory() >= amount) {
				menu.setInventory(menu.getInventory()-amount);
			}else {
				return null;
			}
		}
		
		LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = currentDateTime.format(formatter);
        orderList.setStatus(1);
		Orders order = Orders.builder()
				.user(user)
				.store(store)
				.orderListId(orderList)
				.paymentMethod(request.getPaymentMethod())
				.requests(request.getRequests())
				.createDate(formattedDateTime)
				.build();
		ordersRepository.save(order);
		return OrdersResponse.Detail.of(order, store, orderList, orderDetails);
	}

	public Boolean deleteOrder(Long orderId) {
		Orders order = ordersRepository.findById(orderId).orElseThrow();
		ordersRepository.delete(order);
		return true;
	}

	public OrdersResponse.Detail retrieveDetail(Long orderId) {
		Orders order = ordersRepository.findById(orderId).orElseThrow();
		Stores store = order.getStore();
		OrderList orderList = order.getOrderListId();
		List<OrderDetail> orderDetails = orderDetailRepository.findByOrderList(orderList);
		return OrdersResponse.Detail.of(order, store, orderList, orderDetails);
	}
	
	public List<OrdersResponse.ListElem> retrieveTotal(Long userId){
	    Users user = usersRepository.findById(userId).orElseThrow();
	    List<Orders> orders = ordersRepository.findByUser(user);
	    return orders.stream()
	            .map(order -> OrdersResponse.ListElem.of(order, orderDetailRepository.findByOrderList(order.getOrderListId())))
	            .collect(Collectors.<OrdersResponse.ListElem>toList());
	}
}

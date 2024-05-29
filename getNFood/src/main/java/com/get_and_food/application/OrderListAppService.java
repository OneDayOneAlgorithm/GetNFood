package com.get_and_food.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.get_and_food.controller.request.OrderListRequest;
import com.get_and_food.controller.response.MenuResponse;
import com.get_and_food.controller.response.OrderDetailResponse;
import com.get_and_food.controller.response.OrderDetailResponse.Details;
import com.get_and_food.controller.response.OrderListResponse;
import com.get_and_food.controller.response.OrderListResponse.Detail;
import com.get_and_food.domain.model.Menu;
import com.get_and_food.domain.model.OrderDetail;
import com.get_and_food.domain.model.OrderList;
import com.get_and_food.domain.model.Stores;
import com.get_and_food.domain.model.Users;
import com.get_and_food.domain.repository.MenuRepository;
import com.get_and_food.domain.repository.OrderDetailRepository;
import com.get_and_food.domain.repository.OrderListRepository;
import com.get_and_food.domain.repository.StoresRepository;
import com.get_and_food.domain.repository.UsersRepository;

import lombok.*;

@Service
@RequiredArgsConstructor
public class OrderListAppService {
	private final OrderListRepository orderListRepository;
	private final OrderDetailRepository orderDetailRepository;
	private final StoresRepository storesRepository;
	private final UsersRepository usersRepository;
	
	public OrderDetailResponse.Details retrieveDetail(Long orderListId) {
		OrderList orderList = orderListRepository.findById(orderListId).orElseThrow();
		List<OrderDetail> orderDetails = orderDetailRepository.findByOrderList(orderList);
		Stores store = orderList.getStores();

		return OrderDetailResponse.Details.of(orderList, orderDetails, store);
	}

	public Boolean deleteOrderList(Long orderListId) {
		OrderList orderList = orderListRepository.findById(orderListId).orElseThrow();
		orderListRepository.delete(orderList);
		return true;
	}

	public OrderListResponse.Detail createOrderList(OrderListRequest.Detail request) {
		Stores store = storesRepository.findById(request.getStoreId()).orElseThrow();
		Users user = usersRepository.findById(request.getUserId()).orElseThrow();
		OrderList orderList = OrderList.builder()
				.stores(store)
				.users(user)
				.status(0)
				.build();
		orderListRepository.save(orderList);
		return OrderListResponse.Detail.of(orderList);
	}
}

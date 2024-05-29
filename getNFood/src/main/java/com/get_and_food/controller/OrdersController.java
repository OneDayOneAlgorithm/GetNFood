package com.get_and_food.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.get_and_food.application.OrdersAppService;
import com.get_and_food.controller.request.OrderRequest;
import com.get_and_food.controller.response.OrdersResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrdersController {
	private final OrdersAppService ordersAppService;
	
	@PostMapping
	public OrdersResponse.Detail createOrder(@RequestBody OrderRequest.create request){
		return ordersAppService.createOrder(request);
	}
	
	@DeleteMapping("/{orderId}")
	public Boolean deleteOrder(@PathVariable Long orderId) {
		return ordersAppService.deleteOrder(orderId);
	}
	
	@GetMapping("/{orderId}")
	public OrdersResponse.Detail retrieveDetail(@PathVariable Long orderId){
		return ordersAppService.retrieveDetail(orderId);
	}
	
	@GetMapping("/user/{userId}")
	public List<OrdersResponse.ListElem> retrieveTotal(@PathVariable Long userId){
		return ordersAppService.retrieveTotal(userId);
	}
}

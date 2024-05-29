package com.get_and_food.controller;

import org.springframework.web.bind.annotation.*;
import com.get_and_food.application.OrderDetailAppService;
import com.get_and_food.controller.request.OrderDetailRequest;
import com.get_and_food.controller.response.OrdersResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/orderDetail")
@RequiredArgsConstructor
public class OrderDetailController {
	private final OrderDetailAppService orderDetailAppService;
	
	@GetMapping("/plus/{orderDetailId}")
	public OrdersResponse.Price plusAmount(@PathVariable Long orderDetailId) {
		return orderDetailAppService.plusAmount(orderDetailId);
	}
	
	@GetMapping("/minus/{orderDetailId}")
	public OrdersResponse.Price minusAmount(@PathVariable Long orderDetailId) {
		return orderDetailAppService.minusAmount(orderDetailId);
	}
	
	@DeleteMapping("/{orderDetailId}")
	public Boolean deleteOrderDetail(@PathVariable Long orderDetailId) {
		return orderDetailAppService.deleteOrderDetail(orderDetailId);
	}
	
	@PostMapping
	public Boolean createOrderDetail(@RequestBody OrderDetailRequest.Detail request) {
		return orderDetailAppService.createOrderDetail(request);
	}
	
}

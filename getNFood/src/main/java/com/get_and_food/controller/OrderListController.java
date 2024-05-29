package com.get_and_food.controller;

import org.springframework.web.bind.annotation.*;

import com.get_and_food.application.OrderListAppService;
import com.get_and_food.controller.request.OrderListRequest;
import com.get_and_food.controller.response.OrderDetailResponse;
import com.get_and_food.controller.response.OrderListResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/orderList")
@RequiredArgsConstructor
public class OrderListController {
	private final OrderListAppService orderListAppService;
	
	@GetMapping("/{orderListId}")
	public OrderDetailResponse.Details retrieveDetail(@PathVariable Long orderListId){
		return orderListAppService.retrieveDetail(orderListId);
	}

	@DeleteMapping("/{orderListId}")
	public Boolean deleteOrderList(@PathVariable Long orderListId) {
		return orderListAppService.deleteOrderList(orderListId);
	}
	
	@PostMapping
	public OrderListResponse.Detail createOrderList(@RequestBody OrderListRequest.Detail request){
		System.out.println(request);
		return orderListAppService.createOrderList(request);
	}
}

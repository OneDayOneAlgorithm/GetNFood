/*
 * 2024 05 03 
 * 이상기
 * */
package com.get_and_food.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.get_and_food.application.AddressAppService;
import com.get_and_food.controller.request.AddressRequest;
import com.get_and_food.controller.response.AddressResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AddressController {
	private final AddressAppService addressAppService;
	
	@GetMapping("/addr/{id}")
	public List<AddressResponse.Detail> retrieveDetail(@PathVariable Long id)
	{
		return addressAppService.retrieveList(id);
	}
	
	@PostMapping("/addr")
	public AddressResponse.Detail createAddr(@RequestBody AddressRequest.create request)
	{
		return addressAppService.createAddress(request);
	}
}

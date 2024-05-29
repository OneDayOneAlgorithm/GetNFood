/*
 * 2024 05 07
 * 이상기
 * */
package com.get_and_food.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.get_and_food.application.AddressAppService;
import com.get_and_food.application.UsersAppService;
import com.get_and_food.controller.request.StoreRequest;
import com.get_and_food.controller.request.UsersRequest;
import com.get_and_food.controller.response.UsersResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
	private final UsersAppService usersAppService;
	
	@PostMapping("/login")
	public Long login(@RequestBody UsersRequest.login request, HttpServletRequest httpRequest) 
	{
	        return usersAppService.login(request, httpRequest);
	}
	
	@DeleteMapping("/resign/{id}")
	public void resign(@PathVariable Long id)
	{
		usersAppService.resign(id);
	}
	
	@GetMapping("/mypage/{id}")
	public UsersResponse.Detail retrieveDetail(@PathVariable Long id)
	{
		return usersAppService.retrieveList(id);
	}
	
	@PostMapping("/signup")
	public UsersResponse.Detail createUser(@RequestBody UsersRequest.create request)
	{
		return usersAppService.createUser(request);
	}
	
	@PutMapping("/mypage/{id}")
	public UsersResponse.Detail updateUser(@PathVariable Long id, 
			@RequestParam("password") String password,
			@RequestParam("email") String email,
			@RequestParam("usePhone") String usePhone,
			@RequestParam("address") String address,
			@RequestParam("userPhoto") MultipartFile userPhoto) throws IOException 
	{
		UsersRequest.update request = new UsersRequest.update();
		request.setPassword(password);
		request.setAddress(address);
		request.setEmail(email);
		request.setUsePhone(usePhone);
		request.setUserPhoto(userPhoto);
		
		return usersAppService.updateUser(id, request);
	}
	
	/*@PutMapping("/addr/{id}")
	public UsersResponse.Detail changeUserAddr(@PathVariable Long id, @RequestBody UsersRequest.changeAddr request)
	{
		return usersAppService.changeUserAddr(id, request);
	}
	*/

}

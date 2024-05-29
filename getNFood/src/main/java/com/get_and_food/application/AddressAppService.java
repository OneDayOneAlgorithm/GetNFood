/*
 * 2024 05 03 
 * 이상기
 * */
package com.get_and_food.application;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.get_and_food.controller.request.AddressRequest;
import com.get_and_food.controller.response.AddressResponse;
import com.get_and_food.domain.model.Address;
import com.get_and_food.domain.model.Users;
import com.get_and_food.domain.repository.AddressRepository;
import com.get_and_food.domain.repository.UsersRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressAppService {
	private final AddressRepository addressRepository;
	private final UsersRepository usersRepository;
	
	@Transactional
	public AddressResponse.Detail createAddress(AddressRequest.create request)
	{
		Users user = usersRepository.findById(request.getUserId()).orElseThrow();
		
		Address addr = Address.builder()
				.user(user)
				.address(request.getAddress())
				.build();
		
		addressRepository.save(addr);
		
		return AddressResponse.Detail.of(addr);
	}
	
	public List<AddressResponse.Detail> retrieveList(Long userId)
	{
		Users user = usersRepository.findById(userId).orElseThrow();
		System.out.println(user);
		return addressRepository.findAllByUser(user).stream().map(AddressResponse.Detail::of).toList();
	}
	
	
}

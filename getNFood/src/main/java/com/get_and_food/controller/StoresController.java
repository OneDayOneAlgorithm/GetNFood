/*
 * 2024 05 08
 * 이상기
 * */
package com.get_and_food.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.get_and_food.application.StoresAppService;
import com.get_and_food.controller.request.StoreRequest;
import com.get_and_food.controller.response.StoreResponse;
import com.get_and_food.domain.model.FoodCategory;
import com.get_and_food.domain.model.Stores;
import com.get_and_food.domain.repository.StoresRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class StoresController {
	private final StoresAppService storesAppService;
	
	@PostMapping("/stores")
	public StoreResponse.Detail createStore(@RequestBody StoreRequest.create request)
	{
		return storesAppService.createStore(request);
	}
	
	@GetMapping("/maps")
	public List<StoreResponse.SearchInfo> retrieveAll()
	{
	      return storesAppService.searchForAll();
	}
	
	
	/*@GetMapping("/stores/user/{userId}")
	public List<StoreResponse.ListElem> retrieveList(@PathVariable Long userId)
	{
		return storesAppService.retrieveList(userId);
	}*/
	
	@GetMapping("/stores/{storeId}")
	public StoreResponse.Detail retrieveStoreByUserId(@PathVariable Long storeId)
	{
		return storesAppService.retrieveStoreByStoreID(storeId);
	}
	
	
	@GetMapping("/stores/user/{userId}")
	public StoreResponse.Detail retrieveStore(@PathVariable Long userId) {
	    return storesAppService.retrieveStore(userId);
	}
	
	
	@PutMapping("/stores/{storeId}")
    public StoreResponse.Detail updateStore(@PathVariable Long storeId,
            @RequestParam("storeName") String storeName,
            @RequestParam("storeContent") String storeContent,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("storeAddr") String storeAddr,
            @RequestParam("operationTime") String operationTime,
            @RequestParam("dayOff") String dayOff,
            @RequestParam("foodCategory") FoodCategory foodCategory,
            @RequestParam("countryOfOrigin") String countryOfOrigin,
            @RequestParam("businessNumber") String businessNumber,
            @RequestParam("storePicture") MultipartFile storePicture) throws IOException 
	{
			StoreRequest.update request = new StoreRequest.update();
			request.setStoreName(storeName);
			request.setStoreContent(storeContent);
			request.setPhoneNumber(phoneNumber);
			request.setStoreAddr(storeAddr);
			request.setOperationTime(operationTime);
			request.setDayOff(dayOff);
			request.setFoodCategory(foodCategory);
			request.setCountryOfOrigin(countryOfOrigin);
			request.setBusinessNumber(businessNumber);
			request.setStorePicture(storePicture);
			
			return storesAppService.updateStore(storeId ,request);
	}
	
	@GetMapping("/search/{name}")
	public List<StoreResponse.SearchInfo> searchForName(@PathVariable("name") String name)
	{
		return storesAppService.searchForName(name);
	}
	
	@GetMapping("/category/{foodCategory}")
	public List<StoreResponse.SearchInfo> searchForCategory(@PathVariable FoodCategory foodCategory)
	{
		return storesAppService.searchForCategory(foodCategory);
	}
	
	
	
	
}

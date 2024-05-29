/*
 * 2024 05 08
 * 이상기
 * */
package com.get_and_food.application;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.get_and_food.controller.request.StoreRequest;
import com.get_and_food.controller.response.StoreResponse;
import com.get_and_food.controller.response.StoreResponse.SearchInfo;
import com.get_and_food.domain.model.FoodCategory;
import com.get_and_food.domain.model.Menu;
import com.get_and_food.domain.model.Stores;
import com.get_and_food.domain.model.Users;
import com.get_and_food.domain.repository.MenuRepository;
import com.get_and_food.domain.repository.StoresRepository;
import com.get_and_food.domain.repository.UsersRepository;

import lombok.RequiredArgsConstructor;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.cloud.StorageClient;

@Service
@RequiredArgsConstructor
public class StoresAppService {
	
	@Value("${app.firebase-bucket}")
    private String firebaseBucket;
	
	private final StoresRepository storeRepository;
	private final UsersRepository usersRepository;
	private final MenuRepository menuRepository;
	
	@Transactional
	public StoreResponse.Detail createStore(StoreRequest.create request) {
		Long userId = request.getUserId();
	    if (userId == null) {
	        throw new IllegalArgumentException("User ID must not be null");
	    }

	    Users user = usersRepository.findById(userId)
	            .orElseThrow(() -> new IllegalArgumentException("User with given ID not found"));

	    Stores stores = Stores.builder()
	            .storeName(request.getStoreName())
	            .storeAddr(request.getStoreAddr())
	            .phoneNumber(request.getPhoneNumber())
	            .foodCategory(request.getFoodCategory())
	            .businessNumber(request.getBusinessNumber())
	            .user(user)
	            .build();

	    storeRepository.save(stores);

	    return StoreResponse.Detail.of(stores);
	}
	
	
	@Transactional
	public List<StoreResponse.ListElem> retrieveList(Long userId)
	{
		 List<Stores> stores = storeRepository.findAllByUserUserId(userId);
		 return stores.stream().map(StoreResponse.ListElem::of).toList();
	}
	
	
	
	@Transactional
	public StoreResponse.Detail retrieveStore(Long userId)
	{
		Users user = usersRepository.findById(userId).orElseThrow();
		Stores stores = storeRepository.findByUser(user).stream().findFirst().orElse(null);
		return StoreResponse.Detail.of(stores);
	}
	
	@Transactional
	public StoreResponse.Detail retrieveStoreByStoreID(Long storeId)
	{
		Stores stores = storeRepository.findById(storeId).orElse(null);
		return StoreResponse.Detail.of(stores);
	}
	
	@Transactional
	public StoreResponse.Detail updateStore(Long storeId, @RequestBody StoreRequest.update request) throws IOException
	{
		Stores stores = storeRepository.findById(storeId).orElseThrow();
		
		Bucket bucket = StorageClient.getInstance().bucket(firebaseBucket);
        InputStream content = new ByteArrayInputStream(request.getStorePicture().getBytes());
        Blob blob = bucket.create(request.getStoreName(), content, request.getStorePicture().getContentType());
		
		
		stores.setStoreName(request.getStoreName());
		stores.setStoreContent(request.getStoreContent());
		stores.setPhoneNumber(request.getPhoneNumber());
		stores.setStoreAddr(request.getStoreAddr());
		stores.setOperationTime(request.getOperationTime());
		stores.setDayOff(request.getDayOff());
		stores.setFoodCategory(request.getFoodCategory());
		stores.setCountryOfOrigin(request.getCountryOfOrigin());
		stores.setBusinessNumber(request.getBusinessNumber());
		
		stores.setStorePhotoUrl("https://firebasestorage.googleapis.com/v0/b/" + firebaseBucket + "/o/" + blob.getName() + "?alt=media");
		
		storeRepository.save(stores);
		
		return StoreResponse.Detail.of(stores);
	}
	
	@Transactional
	public List<StoreResponse.SearchInfo> searchForName(String name) {
	    List<Stores> stores = storeRepository.findAllByStoreNameContaining(name);
	    List<StoreResponse.SearchInfo> searchInfos = new ArrayList<>();
	    for (Stores store : stores) {
	    	Menu menu = menuRepository.findByStores(store).stream().findFirst().orElse(null);
	    	if(menu == null) {
	            continue;
	        }
	        searchInfos.add(StoreResponse.SearchInfo.of(menu, store));
	    }

	    return searchInfos;
	}
	
	@Transactional
	public List<StoreResponse.SearchInfo> searchForCategory(FoodCategory foodCategory) {
	    System.out.println("FoodCategory : " + foodCategory);
	    List<Stores> stores = storeRepository.findAllByFoodCategory(foodCategory);
	    
	    List<StoreResponse.SearchInfo> searchInfos = new ArrayList<>();
	    
	    for (Stores store : stores) {
	    	Menu menu = menuRepository.findByStores(store).stream().findFirst().orElse(null);
	    	if(menu == null) {
	            continue;
	        }
	        searchInfos.add(StoreResponse.SearchInfo.of(menu, store));
	    }

	    return searchInfos;
	}

	@Transactional
	public List<StoreResponse.SearchInfo> searchForAll() {
		List<Stores> stores = storeRepository.findAll(); // 모든 가게 정보를 데이터베이스에서 조회합니다.
	    List<StoreResponse.SearchInfo> searchInfos = new ArrayList<>();
	    System.out.println("stores " + stores);
	    for (Stores store : stores) 
	    {
	    	 
	    	Menu menu = menuRepository.findByStores(store).stream().findFirst().orElse(null);
	    	if(menu == null) {
		      continue;
		    }
		    searchInfos.add(StoreResponse.SearchInfo.of(menu, store));
	    }
	    return searchInfos;
	}
	
	
}

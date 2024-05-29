package com.get_and_food.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.get_and_food.controller.request.MenuRequest;
import com.get_and_food.controller.response.MenuResponse;
import com.get_and_food.domain.model.Menu;
import com.get_and_food.domain.model.Stores;
import com.get_and_food.domain.repository.MenuRepository;
import com.get_and_food.domain.repository.StoresRepository;

import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
 
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.cloud.StorageClient;

@Service
@RequiredArgsConstructor
public class MenuAppService {
	
	@Value("${app.firebase-bucket}")
    private String firebaseBucket;
	
	private final MenuRepository menuRepository;
	private final StoresRepository storeRepository;

	public List<MenuResponse.Detail> searchMenuList(Long id) {
		Stores store = storeRepository.findById(id).orElseThrow();
		List<Menu> menuList = menuRepository.findByStores(store);
		return menuList.stream().map(MenuResponse.Detail::of).toList();
	}

	public Boolean deleteMenu(Long menuId) {
		Menu menu = menuRepository.findById(menuId).orElseThrow();
		menuRepository.delete(menu);
		return true;
	}
	
	public MenuResponse.Detail createMenu(MenuRequest.Detail request) throws IOException{
		LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = currentDateTime.format(formatter);
        Stores store = storeRepository.findById(request.getStoreId()).orElseThrow();
        
        Bucket bucket = StorageClient.getInstance().bucket(firebaseBucket);
        InputStream content = new ByteArrayInputStream(request.getMenuPicture().getBytes());
        Blob blob = bucket.create(request.getMenuName(), content, request.getMenuPicture().getContentType());
        
		Menu menu = Menu.builder()
				.stores(store)
				.menuName(request.getMenuName())
				.price(request.getPrice())
				.inventory(request.getInventory())
				.pickupTime(request.getPickupTime())
				.menuPictureUrl(request.getMenuPictureUrl())
				.createDate(formattedDateTime)
				.discount(request.getDiscount())
				.nowPrice(request.getPrice()-request.getDiscount())
				.menuPictureUrl("https://firebasestorage.googleapis.com/v0/b/" + firebaseBucket + "/o/" + blob.getName() + "?alt=media")
				.build();
		menuRepository.save(menu);
		return MenuResponse.Detail.of(menu);
	}
}


package com.get_and_food.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.get_and_food.application.MenuAppService;
import com.get_and_food.controller.request.MenuRequest;
import com.get_and_food.controller.response.MenuResponse;

import lombok.*;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {
	private final MenuAppService menuAppService;
	
	// 상점의 메뉴 가져오기
	@GetMapping("store/{storeId}")
	public List<MenuResponse.Detail> searchMenuList(@PathVariable Long storeId){
		return menuAppService.searchMenuList(storeId);
	}
	
	@DeleteMapping("/{menuId}")
	public Boolean deleteMenu(@PathVariable Long menuId) {
		return menuAppService.deleteMenu(menuId);
	}
	
	@PostMapping
	public MenuResponse.Detail createMenu(@RequestParam("storeId") Long storeId,
	                                      @RequestParam("menuName") String menuName,
	                                      @RequestParam("price") int price,
	                                      @RequestParam("inventory") int inventory,
	                                      @RequestParam("pickupTime") String pickupTime,
	                                      @RequestParam("discount") int discount,
	                                      @RequestParam("menuPicture") MultipartFile menuPicture) throws IOException {
		MenuRequest.Detail request = new MenuRequest.Detail();
	    request.setStoreId(storeId);
	    request.setMenuName(menuName);
	    request.setPrice(price);
	    request.setInventory(inventory);
	    request.setPickupTime(pickupTime);
	    request.setDiscount(discount);
	    request.setMenuPicture(menuPicture);
	    return menuAppService.createMenu(request);
	}

}

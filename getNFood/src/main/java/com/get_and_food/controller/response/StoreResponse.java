/*
 * 이상기
 * 2024-05-03 작성
 */
package com.get_and_food.controller.response;

import com.get_and_food.domain.model.FoodCategory;
import com.get_and_food.domain.model.Menu;
import com.get_and_food.domain.model.Stores;

import lombok.Builder;
import lombok.Data;

public class StoreResponse {
	
	@Data
    @Builder
    public static class Detail{
		
		private Long storeId;
		private String storeName;
		private String storeContent;
		private String phoneNumber;
		private String storeAddr;
		private String operationTime;
		private String dayOff;
		private String storePhotoUrl;
		private FoodCategory foodCategory;
		private String countryOfOrigin;
		private String businessNumber;
		private UsersResponse.Detail user;
		
		public static Detail of(Stores store)
		{
			return Detail.builder()
					.storeId(store.getStoreId())
					.storeName(store.getStoreName())
					.storeContent(store.getStoreContent())
					.phoneNumber(store.getPhoneNumber())
					.storeAddr(store.getStoreAddr())
					.operationTime(store.getOperationTime())
					.dayOff(store.getDayOff())
					.storePhotoUrl(store.getStorePhotoUrl())
					.foodCategory(store.getFoodCategory())
					.countryOfOrigin(store.getCountryOfOrigin())
					.businessNumber(store.getBusinessNumber())
					.user(UsersResponse.Detail.of(store.getUser()))
					.build();
		}
	}
	
	@Data
    @Builder
    public static class ListElem
    {
		private Long storeId;
		private String storeName;
		
		public static ListElem of(Stores store)
		{
			return ListElem.builder()
					.storeId(store.getStoreId())
					.storeName(store.getStoreName())
					.build();
		}
    }
	
	@Data
    @Builder
    public static class SearchInfo
    {
		Long menuId;
		Long storeId;
		String storePhotoUrl;
		String storeName;
		String menuName;
		int price;
		String pickupTime;
		int discount;
		String address;
		String phoneNumber;
		public static SearchInfo of(Menu menu, Stores store)
		{
			return SearchInfo.builder()
					.menuId(menu.getMenuId())
					.storeId(store.getStoreId())
					.storePhotoUrl(store.getStorePhotoUrl())
					.storeName(store.getStoreName())
					.menuName(menu.getMenuName())
					.price(menu.getPrice())
					.pickupTime(menu.getPickupTime())
					.discount(menu.getDiscount())
					.address(store.getStoreAddr())
					.phoneNumber(store.getPhoneNumber())
					.build();
		}
		
    }
	
	
}

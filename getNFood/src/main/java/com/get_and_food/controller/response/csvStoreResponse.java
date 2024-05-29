package com.get_and_food.controller.response;

import com.get_and_food.domain.model.Stores;
import com.get_and_food.domain.model.csvStore;

import lombok.Builder;
import lombok.Data;

public class csvStoreResponse {
	@Data
    @Builder
    public static class SearchMaps
    {
		private Long storeId;
		private String storeName;
		private String phoneNumber;
		private String address; 
		public static SearchMaps of(csvStore store)
		{
			return SearchMaps.builder()
					.storeId(store.getCsvStoreId())
					.storeName(store.getStoreName())
					.phoneNumber(store.getPhoneNumber())
					.address(store.getAddress())
					.build();
		}
    }
}

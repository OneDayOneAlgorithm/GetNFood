package com.get_and_food.controller.request;

import lombok.Data;

public class CsvStoreRequest {
	@Data
	public static class readCsv
	{
		private String StoreAddr;
		private String storeName;
		private String storePhoneNumber;
	}
	
}

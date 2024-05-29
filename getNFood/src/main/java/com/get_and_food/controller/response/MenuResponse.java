package com.get_and_food.controller.response;

import java.util.Date;
import lombok.*;
import com.get_and_food.domain.model.Menu;

public class MenuResponse {
	@Data
	@Builder
	public static class Detail{
		private Long menuId;
		private String menuName;
		private int price;
		private int inventory;
		private String pickupTime;
		private String menuPictureUrl;
		private String createDate;
		private int discount;
		private int nowPrice;
		
		public static Detail of(Menu menu) {
			return Detail.builder()
					.menuId(menu.getMenuId())
					.menuName(menu.getMenuName())
					.price(menu.getPrice())
					.inventory(menu.getInventory())
					.pickupTime(menu.getPickupTime())
					.menuPictureUrl(menu.getMenuPictureUrl())
					.createDate(menu.getCreateDate())
					.discount(menu.getDiscount())
					.nowPrice(menu.getNowPrice())
					.build();
		}
	}
}

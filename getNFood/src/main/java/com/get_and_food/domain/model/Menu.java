package com.get_and_food.domain.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"stores"}) // 직렬화에서 제외할 필드 지정
public class Menu {
	@Id
	@GeneratedValue
	private Long menuId;
	
	// Stores에서 OneToMany 해야함
	@ManyToOne
	@JoinColumn(name = "menu_store_id")
	private Stores stores;
	
	private String menuName;
	
	private int price;
	
	@Setter
	private int inventory;
	
	private String pickupTime;
	
	private String menuPictureUrl;
	
	private String createDate;
	
	private int discount;
	
	private int nowPrice;
}

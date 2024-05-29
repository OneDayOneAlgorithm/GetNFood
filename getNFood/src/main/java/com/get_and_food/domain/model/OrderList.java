package com.get_and_food.domain.model;

import javax.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderList {
	@Id
	@GeneratedValue
	private Long orderListId;
	
	@ManyToOne
	@JoinColumn(name = "order_list_store_id")
	private Stores stores;
	
	@ManyToOne
	@JoinColumn(name = "order_list_users_id")
	private Users users;
	
	@Setter
	private int status;
	
	@Setter
	private int totalPrice;
	
	@Setter
	private int notDiscountPrice;
}

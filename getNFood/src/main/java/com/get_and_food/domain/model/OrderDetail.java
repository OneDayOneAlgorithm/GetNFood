package com.get_and_food.domain.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = { "orderList" }) // 직렬화에서 제외할 필드 지정
public class OrderDetail {
	@Id
	@GeneratedValue
	private Long orderDetailId;

	@ManyToOne
	@JoinColumn(name = "order_detail_order_list_id")
	private OrderList orderList;

	@ManyToOne
	@JoinColumn(name = "order_detail_menu_id")
	private Menu menu;

	@Setter
	private int amount;
}

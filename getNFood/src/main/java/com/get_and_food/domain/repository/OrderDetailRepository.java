package com.get_and_food.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.get_and_food.domain.model.Menu;
import com.get_and_food.domain.model.OrderDetail;
import com.get_and_food.domain.model.OrderList;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>{
	List<OrderDetail> findByOrderList(OrderList orderList);
	List<OrderDetail> findAll();
	OrderDetail findByOrderListAndMenu(OrderList orderList, Menu menu);
}

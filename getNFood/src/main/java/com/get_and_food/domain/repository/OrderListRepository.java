package com.get_and_food.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.get_and_food.domain.model.OrderList;
import com.get_and_food.domain.model.Stores;

public interface OrderListRepository extends JpaRepository<OrderList, Long> {
}

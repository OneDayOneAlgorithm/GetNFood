/*
 * 이상기
 * 2024-04-29 작성
 */

package com.get_and_food.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.get_and_food.domain.model.Orders;
import com.get_and_food.domain.model.Users;

@EnableJpaRepositories
public interface OrdersRepository extends JpaRepository<Orders, Long>{
	List<Orders> findByUser(Users user);
}

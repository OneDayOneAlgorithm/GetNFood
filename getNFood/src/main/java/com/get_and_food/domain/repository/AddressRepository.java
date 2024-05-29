/*
 * 이상기
 * 2024-04-29 작성
 */

package com.get_and_food.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.get_and_food.domain.model.Address;
import com.get_and_food.domain.model.Users;

@EnableJpaRepositories
public interface AddressRepository extends JpaRepository<Address, Long> {
	List<Address> findAllByUser(Users user);;
}
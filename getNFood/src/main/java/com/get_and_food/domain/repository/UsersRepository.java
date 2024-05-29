/*
 * 이상기
 * 2024-04-29 작성
 */

package com.get_and_food.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.get_and_food.domain.model.Users;

@EnableJpaRepositories
public interface UsersRepository extends JpaRepository<Users, Long>{

	Users findByLoginId(String loginId);
}

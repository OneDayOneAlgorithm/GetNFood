/*
 * 이상기
 * 2024-04-29 작성
 */
package com.get_and_food.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.get_and_food.domain.model.FoodCategory;
import com.get_and_food.domain.model.Stores;
import com.get_and_food.domain.model.Users;

@EnableJpaRepositories
public interface StoresRepository extends JpaRepository<Stores, Long>{
    List<Stores> findAllByStoreNameContaining(String storeName);
    List<Stores> findAllByFoodCategory(FoodCategory foodCategory);
    List<Stores> findAllByUserUserId(Long userId);
    List<Stores> findByUser(Users user);
    boolean existsByStoreNameAndPhoneNumberAndStoreAddr(String storeName, String phoneNumber, String storeAddr);
}
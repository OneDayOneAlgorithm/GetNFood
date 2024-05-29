package com.get_and_food.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.get_and_food.domain.model.Address;
import com.get_and_food.domain.model.Users;
import com.get_and_food.domain.model.csvStore;

@EnableJpaRepositories
public interface CsvDateRepository extends JpaRepository<csvStore, Long> {
	boolean existsByStoreNameAndPhoneNumberAndAddress(String storeName, String phoneNumber, String address);
}
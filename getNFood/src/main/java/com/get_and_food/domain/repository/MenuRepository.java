package com.get_and_food.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.get_and_food.domain.model.Menu;
import com.get_and_food.domain.model.Stores;

public interface MenuRepository extends JpaRepository<Menu, Long>{
	List<Menu> findByStores(Stores store);
	Menu findByStoresStoreId(Long storeId);
}

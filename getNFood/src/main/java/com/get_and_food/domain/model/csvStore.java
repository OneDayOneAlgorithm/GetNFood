package com.get_and_food.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class csvStore {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long csvStoreId;
	
	private String storeName;
	private String phoneNumber;
	private String address; 

}

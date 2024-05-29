/*
 * 이상기
 * 2024-04-29 작성
 */
package com.get_and_food.domain.model;

import javax.persistence.*;
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
public class Stores {
    @Id
    @GeneratedValue
    private Long storeId;
    private String storeName;
    private String storeContent;
    private String phoneNumber;
    private String storeAddr;
    private String operationTime;
    private String dayOff;
    private String storePhotoUrl;
    
    @Enumerated(value = EnumType.STRING)
    private FoodCategory foodCategory;
    
    private String countryOfOrigin;
    private String businessNumber;
    
    @ManyToOne
    @JoinColumn(name = "user_id") // 외래 키 컬럼명을 명시적으로 지정
    private Users user;
}
/*
 * 이상기
 * 2024-04-29 작성
 */
package com.get_and_food.domain.model;


import java.time.LocalDate;

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
public class Orders {
    
    @Id
    @GeneratedValue
    private Long orderId;
    
    @ManyToOne
    @JoinColumn(name = "user_id") // 외래 키 컬럼명을 명시적으로 지정
    private Users user;
    
    @ManyToOne
    @JoinColumn(name = "store_id") // 외래 키 컬럼명을 명시적으로 지정
    private Stores store;
    @OneToOne
    @JoinColumn(name = "orederlist_id")
    private OrderList orderListId;
    
    private String paymentMethod;
    private String requests;
    private String createDate;
    
}

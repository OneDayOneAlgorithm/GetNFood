/*
 * 이상기
 * 2024-04-29 작성
 */
package com.get_and_food.domain.model;

import javax.persistence.*;
import lombok.*;

import javax.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adressId; // Renamed to follow Java naming conventions, also changed the type to Long

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user; // Changed from 'Users' to 'User' to match the entity name

    private String address;
}
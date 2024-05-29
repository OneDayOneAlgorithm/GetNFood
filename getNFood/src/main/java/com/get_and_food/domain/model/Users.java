/*
 * 이상기
 * 2024-04-29 작성
 */
package com.get_and_food.domain.model;

import java.util.Optional;

import javax.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Users 
{
    @Id
    @GeneratedValue
    private long userId;
    @Column(unique = true)
    private String loginId;
    private String password;
    
    /*@ManyToOne(cascade = CascadeType.ALL)
    private Address address;
    */

    private String address_name;
    
    private String username;
    private String email;
    private String userPhone;
    private Boolean isBusiness;
    private String userPhotoUrl;

}
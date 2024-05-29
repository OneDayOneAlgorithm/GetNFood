/*
 * 이상기
 * 2024-05-03 작성
 */
package com.get_and_food.controller.response;

import com.get_and_food.domain.model.Address;
import com.get_and_food.domain.model.FoodCategory;
import com.get_and_food.domain.model.Users;

import lombok.Builder;
import lombok.Data;

public class UsersResponse {
    @Data
    @Builder
    public static class Detail {
        private long userId;
        private String loginId;
        private String address;
        private String email;
        private String userPhone;
        private String userName;
        private String userPhotoUrl;
        
        public static Detail of(Users user) {
            Detail.DetailBuilder builder = Detail.builder()
                    .userId(user.getUserId())
                    .loginId(user.getLoginId())
                    .email(user.getEmail())
                    .userPhone(user.getUserPhone())
                    .userName(user.getUsername())
                    .address(user.getAddress_name())
                    .userPhotoUrl(user.getUserPhotoUrl());
            
            /*
            // 사용자의 주소 정보가 null이 아닌 경우에만 주소 정보를 설정합니다.
            if (user.getAddress() != null) {
                builder.addressId(user.getAddress().getAdressId());
            }
            */
            
            return builder.build();
        }
    }
}

/*
 * 이상기
 * 2024-04-29 작성
 */
package com.get_and_food.controller.response;

import com.get_and_food.domain.model.Address;

import lombok.Builder;
import lombok.Data;

public class AddressResponse {
    @Data
    @Builder
    public static class Detail {
        private Long addressId;
        private Long userId;
        private String address;

        public static Detail of(Address address) {
            return Detail.builder()
                    .addressId(address.getAdressId())
                    .userId(address.getUser().getUserId())
                    .address(address.getAddress())
                    .build();
        }
    }
}

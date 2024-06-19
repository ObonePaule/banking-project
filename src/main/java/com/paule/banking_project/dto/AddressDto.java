package com.paule.banking_project.dto;

import com.paule.banking_project.models.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AddressDto {

    private Integer id;

    private String street;

    private Integer houseNumber;

    private Integer zipCode;

    private String city;

    private String country;

    public static AddressDto fromAddress(Address address) {
        return AddressDto.builder()
                .id(address.getId())
                .street(address.getStreet())
                .houseNumber(address.getHouseNumber())
                .zipCode(address.getZipCode())
                .city(address.getCity())
                .country(address.getCountry())
                .build();
    }

    public static Address toAddress(AddressDto addressDto) {
        return Address.builder()
                .id(addressDto.getId())
                .street(addressDto.getStreet())
                .houseNumber(addressDto.getHouseNumber())
                .zipCode(addressDto.getZipCode())
                .city(addressDto.getCity())
                .country(addressDto.getCountry())
                .build();
    }
}

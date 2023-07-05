package com.asd.addressserviceapi.service;

import com.asd.addressserviceapi.dto.request.AddressRequestDto;
import com.asd.addressserviceapi.dto.response.AddressResponseDto;

public interface AddressService {
    public void saveAddress(AddressRequestDto dto);

    public AddressResponseDto findAddress(String id);
}

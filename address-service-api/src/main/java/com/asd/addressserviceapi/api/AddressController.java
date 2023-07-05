package com.asd.addressserviceapi.api;

import com.asd.addressserviceapi.dto.request.AddressRequestDto;
import com.asd.addressserviceapi.dto.response.AddressResponseDto;
import com.asd.addressserviceapi.service.AddressService;
import com.asd.addressserviceapi.util.StandardResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity<StandardResponseEntity> saveAddress(@RequestBody AddressRequestDto dto) {
        addressService.saveAddress(dto);
        return new ResponseEntity<>(
                new StandardResponseEntity(201, "Created " + dto.getId(), null),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponseEntity> findUser(@PathVariable String id) {
        AddressResponseDto address = addressService.findAddress(id);
        System.out.println(address.getCity());
        return new ResponseEntity<>(
                new StandardResponseEntity(200, "data for " + id,
                       address),
                HttpStatus.OK
        );
    }
}

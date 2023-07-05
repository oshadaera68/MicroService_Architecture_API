package com.asd.itemserviceapi.controller;


import com.asd.itemserviceapi.dto.request.ItemRequestDto;
import com.asd.itemserviceapi.service.ItemService;
import com.asd.itemserviceapi.util.StandardResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<StandardResponseEntity> saveItem(@RequestBody ItemRequestDto dto){
        itemService.saveItem(dto);
        return new ResponseEntity<>(
                new StandardResponseEntity(201,"Created "+dto.getDescription(),null),
                HttpStatus.CREATED
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<StandardResponseEntity> findItem(@PathVariable String id){
        return new ResponseEntity<>(
                new StandardResponseEntity(200,"data for "+id,itemService.findItem(id)),
                HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponseEntity> deleteCustomer(@PathVariable String id){
        itemService.deleteItem(id);
        return new ResponseEntity<>(
                new StandardResponseEntity(204,"data deleted "+id,null),
                HttpStatus.NO_CONTENT
        );
    }

    @PutMapping
    public ResponseEntity<StandardResponseEntity> updateItem(@RequestBody ItemRequestDto dto){
        itemService.updateItem(dto);
        return new ResponseEntity<>(
                new StandardResponseEntity(201,"data updated "+dto.getDescription(),null),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/list")
    public ResponseEntity<StandardResponseEntity> findAllItems(){
        return new ResponseEntity<>(
                new StandardResponseEntity(200,"all data",itemService.findAllItems()),
                HttpStatus.OK
        );
    }
}

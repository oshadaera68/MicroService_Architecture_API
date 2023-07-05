package com.asd.itemserviceapi.service.impl;


import com.asd.itemserviceapi.dto.request.ItemRequestDto;
import com.asd.itemserviceapi.dto.response.ItemResponseDto;
import com.asd.itemserviceapi.entity.Item;
import com.asd.itemserviceapi.repo.ItemRepo;
import com.asd.itemserviceapi.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepo itemRepo;

    @Autowired
    public ItemServiceImpl(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @Override
    public void saveItem(ItemRequestDto dto) {
        itemRepo.save(
                new Item(dto.getId(), dto.getDescription(),
                        dto.getUnitPrice(), dto.getQty())
        );
    }

    @Override
    public ItemResponseDto findItem(String id) {
        var selectedItem  = itemRepo.findById(id);
        if (selectedItem.isEmpty()){
            throw new RuntimeException("Not Found!");
        }
        return new ItemResponseDto(
                selectedItem.get().getId(),
                selectedItem.get().getDescription(),
                selectedItem.get().getUnitPrice(),
                selectedItem.get().getQty()
        );
    }

    @Override
    public void updateItem(ItemRequestDto dto) {
        var selectedItem = itemRepo.findById(dto.getId());
        if (selectedItem.isEmpty()){
            throw new RuntimeException("Not Found!");
        }
        selectedItem.get().setDescription(dto.getDescription());
        selectedItem.get().setUnitPrice(dto.getUnitPrice());
        selectedItem.get().setQty(dto.getQty());

        itemRepo.save(selectedItem.get());
    }

    @Override
    public void deleteItem(String id) {
        itemRepo.deleteById(id);
    }

    @Override
    public List<ItemResponseDto> findAllItems() {
        List<ItemResponseDto> list =new ArrayList<>();
        for (Item c: itemRepo.findAll()
             ) {
            list.add(
                    new ItemResponseDto(
                            c.getId(),c.getDescription(),c.getUnitPrice(),c.getQty()
                    )
            );
        }
        return list;
    }
}

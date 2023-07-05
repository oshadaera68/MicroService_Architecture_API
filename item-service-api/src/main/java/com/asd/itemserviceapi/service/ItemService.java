package com.asd.itemserviceapi.service;


import com.asd.itemserviceapi.dto.request.ItemRequestDto;
import com.asd.itemserviceapi.dto.response.ItemResponseDto;

import java.util.List;

public interface ItemService {
    public void saveItem(ItemRequestDto dto);
    public ItemResponseDto findItem(String id);
    public void updateItem(ItemRequestDto dto);
    public void deleteItem(String id);
    public List<ItemResponseDto> findAllItems();
}

package apiserver.orderitemexample.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import apiserver.orderitemexample.domain.Item;
import apiserver.orderitemexample.repository.ItemRepository;
import apiserver.orderitemexample.service.ItemService;
import lombok.RequiredArgsConstructor;

@Service("itemService")
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    
    @Override
    public List<Item> findItemList(String keyword) {
        List<Item> itemList = itemRepository.findByKeyword(keyword);
        return itemList;
    }
    
}

package apiserver.orderitemexample.service;

import java.util.List;

import apiserver.orderitemexample.domain.Item;

public interface ItemService {
    List<Item> findItemList(String keyword);
}

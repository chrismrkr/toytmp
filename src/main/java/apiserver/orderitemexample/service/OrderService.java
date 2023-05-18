package apiserver.orderitemexample.service;

import java.util.List;

import apiserver.orderitemexample.domain.Orders;
import apiserver.orderitemexample.domain.dto.item.ItemDto;

public interface OrderService {
    List<Orders> findOrderList(String name);
    List<ItemDto> findItemList(Long orderId);
}

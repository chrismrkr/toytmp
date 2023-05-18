package apiserver.orderitemexample.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import apiserver.orderitemexample.domain.Orders;
import apiserver.orderitemexample.domain.dto.item.ItemDto;
import apiserver.orderitemexample.domain.dto.item.OrderItemResponseDto;
import apiserver.orderitemexample.domain.dto.order.GetOrdersResponseDto;
import apiserver.orderitemexample.service.OrderService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/orders/{name}")
    public GetOrdersResponseDto getMemeberOrderListRequest(@PathVariable String name) {
        List<Orders> orderList = orderService.findOrderList(name);   
        return new GetOrdersResponseDto(name, orderList);
    }

    @GetMapping("/orderItems/{orderId}")
    public OrderItemResponseDto getOrderItemListRequest(@PathVariable Long orderId) {
        List<ItemDto> itemList = orderService.findItemList(orderId);
        return new OrderItemResponseDto(orderId, itemList);
    }
}

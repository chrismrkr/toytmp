package apiserver.orderitemexample.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import apiserver.orderitemexample.domain.Item;
import apiserver.orderitemexample.domain.Member;
import apiserver.orderitemexample.domain.OrderItem;
import apiserver.orderitemexample.domain.Orders;
import apiserver.orderitemexample.domain.dto.item.ItemDto;
import apiserver.orderitemexample.repository.MemberRepository;
import apiserver.orderitemexample.repository.OrderItemRepository;
import apiserver.orderitemexample.repository.OrderRepository;
import apiserver.orderitemexample.service.OrderService;
import lombok.RequiredArgsConstructor;

@Service("orderService")
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final OrderItemRepository orderItemRepository;

    @Override
    public List<Orders> findOrderList(String name) {
        Member m = memberRepository.findByName(name).orElseThrow(() -> {
            return new IllegalAccessError("can't find proper member");
        });
        List<Orders> orderList = orderRepository.findByMemberId(m.getId());
        return orderList;
    }

    @Override
    public List<ItemDto> findItemList(Long orderId) {
        List<OrderItem> orderItemList = orderItemRepository.findByOrderId(orderId);
        
        List<ItemDto> itemList = new ArrayList<>();
        for(OrderItem orderItem : orderItemList) {
            Item item = orderItem.getItem();
            ItemDto itemDto = ItemDto.builder()
                                .itemId(item.getId())
                                .itemName(item.getName())
                                .orderNum(orderItem.getOrderNum())
                                .price(item.getPrice())
                                .stock(item.getStock())
                                .build();
            itemList.add(itemDto);
        }

        return itemList;
    }
}

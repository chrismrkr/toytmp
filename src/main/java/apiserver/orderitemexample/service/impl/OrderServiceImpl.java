package apiserver.orderitemexample.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import apiserver.orderitemexample.domain.Member;
import apiserver.orderitemexample.repository.MemberRepository;
import apiserver.orderitemexample.repository.OrderRepository;
import apiserver.orderitemexample.service.OrderService;
import apiserver.orderitemexample.service.Orders;
import lombok.RequiredArgsConstructor;

@Service("orderService")
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;

    @Override
    public List<Orders> findOrderList(String name) {
        Member m = memberRepository.findByName(name).orElseThrow(() -> {
            return new IllegalAccessError("can't find proper member");
        });
        List<Orders> orderList = orderRepository.findByMemberId(m.getId());
        return orderList;
    }

}

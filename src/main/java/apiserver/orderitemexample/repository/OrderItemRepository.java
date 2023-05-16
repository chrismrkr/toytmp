package apiserver.orderitemexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apiserver.orderitemexample.domain.OrderItem;
import apiserver.orderitemexample.domain.compositekeys.OrderItemId;

@Repository("orderItemRepository")
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemId>{
    @Query(value = "SELECT orderItem "
                    + "FROM ")
    OrderItem findOrderItemByOrderId(Long orderId);
}
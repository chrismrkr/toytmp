package apiserver.orderitemexample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import apiserver.orderitemexample.domain.OrderItem;
import apiserver.orderitemexample.domain.compositekeys.OrderItemId;

@Repository("orderItemRepository")
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemId>{
    @Query(value = "SELECT orderItem "
                    + "FROM OrderItem orderItem "
                    + "LEFT JOIN FETCH OrderItem.order order "
                    + "JOIN FETCH OrderItem.item item "
                    + "WHERE order.id = :orderId")
    List<OrderItem> findByOrderId(Long orderId);
}
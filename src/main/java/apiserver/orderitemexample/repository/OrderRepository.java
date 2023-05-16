package apiserver.orderitemexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apiserver.orderitemexample.domain.Orders;

@Repository("orderRepository")
public interface OrderRepository extends JpaRepository<Orders, Long>{
    
}

package apiserver.orderitemexample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import apiserver.orderitemexample.domain.Orders;

@Repository("orderRepository")
public interface OrderRepository extends JpaRepository<Orders, Long>{
    @Query(value = "SELECT o "
                    + "FROM Orders o "
                    + "INNER JOIN o.member m "
                    + "WHERE m.id = :memberId")
    List<Orders> findByMemberId(Long memberId);
}

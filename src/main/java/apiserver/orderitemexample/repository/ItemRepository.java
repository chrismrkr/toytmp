package apiserver.orderitemexample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import apiserver.orderitemexample.domain.Item;

@Repository("itemRepository")
public interface ItemRepository extends JpaRepository<Item, Long>{
    @Query(value = "SELECT i "
                    + "FROM Item i "
                    + "WHERE i.name LIKE CONCAT('%', :keyword, '%')")
    List<Item> findByKeyword(String keyword);
}

package apiserver.orderitemexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apiserver.orderitemexample.domain.Item;

@Repository("itemRepository")
public interface ItemRepository extends JpaRepository<Item, Long>{
    
}

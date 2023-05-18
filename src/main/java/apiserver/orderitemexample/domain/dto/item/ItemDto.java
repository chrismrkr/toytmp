package apiserver.orderitemexample.domain.dto.item;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemDto {
    private Long itemId;
    private String itemName;
    private int orderNum;
    private int price;
    private int stock;
}

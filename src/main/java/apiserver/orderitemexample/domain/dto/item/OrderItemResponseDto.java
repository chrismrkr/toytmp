package apiserver.orderitemexample.domain.dto.item;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderItemResponseDto {
    private Long itemId;
    private List<ItemDto> items;
}

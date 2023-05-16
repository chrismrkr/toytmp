package apiserver.orderitemexample.domain.dto.order;
import java.util.ArrayList;
import java.util.List;
import apiserver.orderitemexample.domain.Orders;
import lombok.Getter;

/**
 * { name: ...
 *   orders: [
 *      {
 *          order_id : ... ,
 *          order_description : ...,
 *          link : {
 *              orderItems
 *          }
 *      }
 *   ]
 * }
 */
@Getter
public class GetOrdersResponseDto {
    private String name;
    private List<OrdersDto> orders;
    public GetOrdersResponseDto(String memberName, List<Orders> orders) {
        this.name = memberName;
        this.orders = new ArrayList<>();
        for(Orders order : orders) {
            this.orders.add(new OrdersDto(order));
        }
    }

    @Getter
    private static class OrdersDto {
        private Long orderId;
        private String orderDescription;
        private OrderItemLinkDto link;
        public OrdersDto(Orders order) {
            this.orderId = order.getId();
            this.orderDescription = order.getOrderDescription();
            this.link = new OrderItemLinkDto("/orderItems", order.getId());
        }

        @Getter
        private static class OrderItemLinkDto {
            private String href;
            public OrderItemLinkDto(String res, Long orderId) {
                StringBuilder sb = new StringBuilder();
                sb.append(res);
                sb.append("/");
                sb.append(orderId.toString());
                this.href = sb.toString();
            }
        }
    }
}

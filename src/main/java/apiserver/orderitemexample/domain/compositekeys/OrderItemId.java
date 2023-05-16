package apiserver.orderitemexample.domain.compositekeys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrderItemId implements Serializable {
    @Column(name = "order_id")
    private Long orderId;
    @Column(name = "item_id")
    private Long itemId;

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof OrderItemId)) return false;
        OrderItemId oiid = (OrderItemId)o;
        return orderId == oiid.getOrderId() && itemId == oiid.getItemId();
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
        result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
        return result;
    }
}

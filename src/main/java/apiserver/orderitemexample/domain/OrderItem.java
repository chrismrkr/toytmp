package apiserver.orderitemexample.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import apiserver.orderitemexample.domain.compositekeys.OrderItemId;
import lombok.Getter;

@Entity
@Getter
public class OrderItem {
    @Embedded
    private OrderItemId orderItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Orders order;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id") 
    private Item item;

    private int orderNum;

    private static class Builder {
        private Orders order;
        private Item item;
        private int orderNum;
        public Builder orderNum(int orderNum) {
            this.orderNum = orderNum;
            return this;
        }
        public Builder order(Orders order) {
            this.order = order;
            return this;
        }
        public Builder item(Item item) {
            this.item = item;
            return this;
        }
        public OrderItem build() {
            return new OrderItem(this);
        }
    }

    public static Builder build() {
        return new Builder();
    }

    private OrderItem(Builder builder) {
        this.order = builder.order;
        this.item = builder.item;
        this.orderNum = builder.orderNum;
    }
    // OrderItem orderItem = OrderItem.build().order(order).item(item).build();
}

package apiserver.orderitemexample.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Orders {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;
    private int totalPrice;
    private String orderDescription;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private static class Builder {
        private int totalPrice;
        private String orderDescription;
        private Member member;
        public Builder totalPrice(int totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }
        public Builder orderDescription(String orderDescription) {
            this.orderDescription = orderDescription;
            return this;
        }
        public Builder member(Member member) {
            this.member = member;
            return this;
        }
        public Orders build() {
            return new Orders(this);
        }
    }
    public static Builder build() {
        return new Builder();
    }
    private Orders(Builder builder) {
        this.member = builder.member;
        this.orderDescription = builder.orderDescription;
        this.totalPrice = builder.totalPrice;
    }
}

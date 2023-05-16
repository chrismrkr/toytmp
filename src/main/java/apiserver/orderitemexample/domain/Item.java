package apiserver.orderitemexample.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;

@Entity
@Getter
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stock;

    @OneToMany(mappedBy = "item")
    private List<Item> itemList = new ArrayList<>();

    private static class Builder {
        private String name;
        private int price;
        private int stock;
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder price(int price) {
            this.price = price;
            return this;
        }
        public Builder stock(int stock) {
            this.stock = stock;
            return this;
        }
    }
    public static Builder builder() {
        return new Builder();
    }
    private Item(Builder builder) {
        this.name = builder.name;
        this.price = builder.price;
        this.stock = builder.stock;
    }
    //Item item = Item.builder().name(n).price(p).stock(s).build();
}

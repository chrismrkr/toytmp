package apiserver.orderitemexample.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String name;
    private int age;
    @OneToMany(mappedBy = "member")
    private List<Orders> ordersList = new ArrayList<>();
    private static class Builder {
        private String name;
        private int age;
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder age(int age) {
            this.age = age;
            return this;
        }
        public Member build() {
            return new Member(this);
        }
    }
    public static Builder builder() {
        return new Builder();
    }
    private Member(Builder builder) {
        this.age = builder.age;
        this.name = builder.name;
    }
    // Member m = Member.builder().name(name).age(age).build();
}

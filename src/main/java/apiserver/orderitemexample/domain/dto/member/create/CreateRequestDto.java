package apiserver.orderitemexample.domain.dto.member.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
public class CreateRequestDto {
    private String name;
    private int age;
}

package apiserver.orderitemexample.domain.dto.member.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Builder
public class CreateResponseDto {
    private String name;
    private int age;
}
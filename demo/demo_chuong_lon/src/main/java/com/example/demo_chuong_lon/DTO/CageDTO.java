package com.example.demo_chuong_lon.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CageDTO implements Validator {
    private int id;
    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "\\D+", message = "Không được nhập số")
    private String name;
    @NotNull(message = "Không được để trống")
    @Min(value = 10, message = "Sức chứa phải lớn hơn hoặc bằng 10")
    private int capacity;

    @Override
    public boolean supports(Class<?> clazz) {
        return CageDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

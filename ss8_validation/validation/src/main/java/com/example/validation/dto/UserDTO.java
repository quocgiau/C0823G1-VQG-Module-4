package com.example.validation.dto;

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
public class UserDTO implements Validator {
    private String first;
    private String last;
    private String phone;
    private int age;
    private String email;

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO userDTO = (UserDTO) target;
        if (userDTO.getAge() < 18) {
            errors.rejectValue("age", null, "Vui lòng nhập tuổi trên 18");
        }
        if (userDTO.getFirst().equals("")) {
            errors.rejectValue("first", null, "Vui lòng nhập không được để trống");
        } else if (userDTO.getFirst().length() < 5 || userDTO.getFirst().length() > 45) {
            errors.rejectValue("first", null, "Cần nhập lớn hơn 5 và ít hơn 45 ký tự");
        }
        if (userDTO.getLast().equals("")) {
            errors.rejectValue("last", null, "Vui lòng nhập không được để trống");
        } else if (userDTO.getLast().length() < 5 || userDTO.getLast().length() > 45) {
            errors.rejectValue("last", null, "Cần nhập lớn hơn 5 và ít hơn 45 ký tự");
        }
        if (userDTO.getPhone().equals("")) {
            errors.rejectValue("phone", null, "Vui lòng nhập không được để trống");
        } else if (!(userDTO.getPhone().matches("(84|0[3|5|7|8|9])+([0-9]{8})"))) {
            errors.rejectValue("phone", null, "Vui lòng nhập đúng định dạng số điện thoại");
        }
        if (userDTO.getEmail().equals("")) {
            errors.rejectValue("email", null, "Vui lòng nhập không được để trống");
        } else if (!(userDTO.getEmail().matches("^[a-zA-Z0-9_!#$%&’*+=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"))) {
            errors.rejectValue("email", null, "Vui lòng nhập đúng định dạng email");
        }
    }
}

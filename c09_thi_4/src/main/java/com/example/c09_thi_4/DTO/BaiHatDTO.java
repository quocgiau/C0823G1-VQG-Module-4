package com.example.c09_thi_4.DTO;

import com.example.c09_thi_4.Model.TheLoai;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaiHatDTO implements Validator {
    private int id;
    @NotBlank(message = "Trường bắt buộc nhập")
    private String ma;
    @Size(min = 1, max = 80, message = "Tên không quá 80 ký tự")
    @NotBlank(message = "Trường bắt buộc nhập")
    private String tenBai;
    @NotBlank(message = "Trường bắt buộc nhập")
    private String tacGia;
    @NotBlank(message = "Trường bắt buộc nhập")
    private String ngay;
    @NotBlank(message = "Trường bắt buộc nhập")
    private String moTa;
    private TheLoai theLoai;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

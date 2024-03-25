package com.example.thi_module_4.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CityDTO {
    private Long id;
    @Size(min = 4,message = "Phải nhập trên 4 kí tự")
    @Size(max = 30,message = "Tên không vượt quá 30 kí tự")
    private String name;
    @NotNull(message = "Không được để trống")
    @Min(value = 0,message = "Diện tích phải dương")
    private Long area;
    @NotNull(message = "Không được để trống")

    @Min(value = 0,message = "Diện tích phải dương")

    private Long people;
    @NotNull(message = "Không được để trống")

    @Min(value = 0,message = "Diện tích phải dương")

    private Long GDP;
    @NotNull(message = "Không được để trống")

    private String detail;
    private Country country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public Long getPeople() {
        return people;
    }

    public void setPeople(Long people) {
        this.people = people;
    }

    public Long getGDP() {
        return GDP;
    }

    public void setGDP(Long GDP) {
        this.GDP = GDP;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public CityDTO(Long id, String name, Long area, Long people, Long GDP, String detail, Country country) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.people = people;
        this.GDP = GDP;
        this.detail = detail;
        this.country = country;
    }

    public CityDTO() {
    }
}

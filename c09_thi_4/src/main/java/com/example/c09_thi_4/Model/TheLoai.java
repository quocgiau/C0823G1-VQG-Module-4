package com.example.c09_thi_4.Model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "the_loai")
public class TheLoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tenLoai;

    @OneToMany(mappedBy = "theLoai")
    private Set<BaiHat> baiHat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

//    public Set<BaiHat> getBaiHat() {
//        return baiHat;
//    }
//
//    public void setBaiHat(Set<BaiHat> baiHat) {
//        this.baiHat = baiHat;
//    }

    public TheLoai() {
    }

//    public TheLoai(int id, String tenLoai, Set<BaiHat> baiHat) {
//        this.id = id;
//        this.tenLoai = tenLoai;
//        this.baiHat = baiHat;
//    }
//
    public TheLoai(int id, String tenLoai) {
        this.id = id;
        this.tenLoai = tenLoai;
    }
}

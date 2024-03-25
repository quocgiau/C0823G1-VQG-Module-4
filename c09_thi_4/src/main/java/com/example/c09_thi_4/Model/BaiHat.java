package com.example.c09_thi_4.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "bai_hat")
public class BaiHat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ma;
    private String tenBai;
    private String tacGia;
    private String ngay;
    private String moTa;
    @ManyToOne
    @JoinColumn(name = "t_id")
    private TheLoai theLoai;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTenBai() {
        return tenBai;
    }

    public void setTenBai(String tenBai) {
        this.tenBai = tenBai;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public TheLoai getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(TheLoai theLoai) {
        this.theLoai = theLoai;
    }

    public BaiHat() {
    }

    public BaiHat(int id, String ma, String tenBai, String tacGia, String ngay, String moTa, TheLoai theLoai) {
        this.id = id;
        this.ma = ma;
        this.tenBai = tenBai;
        this.tacGia = tacGia;
        this.ngay = ngay;
        this.moTa = moTa;
        this.theLoai = theLoai;
    }
}

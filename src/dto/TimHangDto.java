/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.time.LocalDate;

/**
 *
 * @author YONGSOKHENG
 */
public class TimHangDto {
    
    private String maHang;
    private String tenHang;
    private String donViTinh;
    private String loaiHang;
    private String ncc;
    private double giaNhap;
    private double giaBan;
    private String ngayHSD;
    private double soLuong;
    private String ghiChu;

    public TimHangDto() {
    }

    public TimHangDto(String maHang, String tenHang, String donViTinh, String loaiHang, String ncc, double giaNhap, double giaBan, String ngayHSD, double soLuong, String ghiChu) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.donViTinh = donViTinh;
        this.loaiHang = loaiHang;
        this.ncc = ncc;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.ngayHSD = ngayHSD;
        this.soLuong = soLuong;
        this.ghiChu = ghiChu;
    }

    /**
     * @return the maHang
     */
    public String getMaHang() {
        return maHang;
    }

    /**
     * @param maHang the maHang to set
     */
    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    /**
     * @return the tenHang
     */
    public String getTenHang() {
        return tenHang;
    }

    /**
     * @param tenHang the tenHang to set
     */
    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    /**
     * @return the donViTinh
     */
    public String getDonViTinh() {
        return donViTinh;
    }

    /**
     * @param donViTinh the donViTinh to set
     */
    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    /**
     * @return the loaiHang
     */
    public String getLoaiHang() {
        return loaiHang;
    }

    /**
     * @param loaiHang the loaiHang to set
     */
    public void setLoaiHang(String loaiHang) {
        this.loaiHang = loaiHang;
    }

    /**
     * @return the ncc
     */
    public String getNcc() {
        return ncc;
    }

    /**
     * @param ncc the ncc to set
     */
    public void setNcc(String ncc) {
        this.ncc = ncc;
    }

    /**
     * @return the giaNhap
     */
    public double getGiaNhap() {
        return giaNhap;
    }

    /**
     * @param giaNhap the giaNhap to set
     */
    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    /**
     * @return the giaBan
     */
    public double getGiaBan() {
        return giaBan;
    }

    /**
     * @param giaBan the giaBan to set
     */
    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    /**
     * @return the ngayHSD
     */
    public String getNgayHSD() {
        return ngayHSD;
    }

    /**
     * @param ngayHSD the ngayHSD to set
     */
    public void setNgayHSD(String ngayHSD) {
        this.ngayHSD = ngayHSD;
    }

    /**
     * @return the soLuong
     */
    public double getSoLuong() {
        return soLuong;
    }

    /**
     * @param soLuong the soLuong to set
     */
    public void setSoLuong(double soLuong) {
        this.soLuong = soLuong;
    }

    /**
     * @return the ghiChu
     */
    public String getGhiChu() {
        return ghiChu;
    }

    /**
     * @param ghiChu the ghiChu to set
     */
    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    
    
    
}

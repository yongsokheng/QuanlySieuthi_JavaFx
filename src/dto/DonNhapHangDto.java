/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.text.SimpleDateFormat;

/**
 *
 * @author YONGSOKHENG
 */
public class DonNhapHangDto {
    
    private String maHoaDon;
    private String ngayDatHang;
    private String tenHang;
    private String loaiHang;
    private double soLuong;
    private String donViTinh;
    private double giaNhap;
    private double thanhTien;
    
    private String maNcc;
    private String maNV;
    private String maHang;
    
    

    public DonNhapHangDto() {
    }

    public DonNhapHangDto(String maHoaDon, String ngayDatHang, String tenHang, String loaiHang, double soLuong, String donViTinh, double giaNhap, double thanhTien, String maNcc, String maNV, String maHang) {
        this.maHoaDon = maHoaDon;
        this.ngayDatHang = ngayDatHang;
        this.tenHang = tenHang;
        this.loaiHang = loaiHang;
        this.soLuong = soLuong;
        this.donViTinh = donViTinh;
        this.giaNhap = giaNhap;
        this.thanhTien = thanhTien;
        this.maNcc = maNcc;
        this.maNV = maNV;
        this.maHang = maHang;
    }

     public DonNhapHangDto(String maHoaDon, String tenHang, String loaiHang, double soLuong, String donViTinh, double giaNhap, double thanhTien, String maNcc, String maNV, String maHang) {
        this.maHoaDon = maHoaDon;
     
        this.tenHang = tenHang;
        this.loaiHang = loaiHang;
        this.soLuong = soLuong;
        this.donViTinh = donViTinh;
        this.giaNhap = giaNhap;
        this.thanhTien = thanhTien;
        this.maNcc = maNcc;
        this.maNV = maNV;
        this.maHang = maHang;
    }


    
  

    /**
     * @return the maHoaDon
     */
    public String getMaHoaDon() {
        return maHoaDon;
    }

    /**
     * @param maHoaDon the maHoaDon to set
     */
    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    /**
     * @return the ngayDatHang
     */
    public String getNgayDatHang() {
        
        return ngayDatHang;
    }

    /**
     * @param ngayDatHang the ngayDatHang to set
     */
    public void setNgayDatHang(String ngayDatHang) {
       
        this.ngayDatHang = ngayDatHang;
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
     * @return the thanhTien
     */
    public double getThanhTien() {
        return thanhTien;
    }

    /**
     * @param thanhTien the thanhTien to set
     */
    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    /**
     * @return the maNcc
     */
    public String getMaNcc() {
        return maNcc;
    }

    /**
     * @param maNcc the maNcc to set
     */
    public void setMaNcc(String maNcc) {
        this.maNcc = maNcc;
    }

    /**
     * @return the maNV
     */
    public String getMaNV() {
        return maNV;
    }

    /**
     * @param maNV the maNV to set
     */
    public void setMaNV(String maNV) {
        this.maNV = maNV;
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
    
    
    
}

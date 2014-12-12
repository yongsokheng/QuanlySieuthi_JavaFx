/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;


/**
 *
 * @author NGENG CHHENGKIM
 */
public class BanHangDto {

    private String maSanPham;
    private String tenSanPham;
    private double soLuong;
    private String donViTinh;
    private double donGia;
    private double thanhTien;
    private int sTT;
    private String ngayLapHoaDon;
    private String maNhanVien;
    private String maThe;
    private String maHoaDon="0";

    public BanHangDto() {
    }

    ;
  
    public BanHangDto(String maSanPham, String tenSanPham, double soLuong, double donGia, String donViTinh, String maHoaDon, String maNhanVien, String maThe, String ngayLapHoaDon) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.donViTinh = donViTinh;
        this.maNhanVien = maNhanVien;
        this.maHoaDon=maHoaDon;
        this.maThe = maThe;
        this.ngayLapHoaDon = ngayLapHoaDon;
    }

    public BanHangDto(int sTT, String maSanPhan, String tenSanPham, double soLuong, double donGia, String donViTinh, double thanhTien) {
        this.sTT = sTT;
        this.maSanPham = maSanPhan;
        this.tenSanPham = tenSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.donViTinh = donViTinh;
        this.thanhTien = thanhTien;
    }

    public BanHangDto(String maSanPham, String tenSanPham, double soLuong, double donGia, String donViTinh) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public BanHangDto(String tenSanPham, double soLuong, double donGia, String donViTinh) {
        this.tenSanPham = tenSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    /**
     * @return the maSanPham
     */
    public String getMaSanPham() {
        return maSanPham;
    }

    /**
     * @param maSanPham the maSanPham to set
     */
    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    /**
     * @return the tenSanPham
     */
    public String getTenSanPham() {
        return tenSanPham;
    }

    /**
     * @param tenSanPham the tenSanPham to set
     */
    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
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
     * @return the donGia
     */
    public double getDonGia() {
        return donGia;
    }

    /**
     * @param donGia the donGia to set
     */
    public void setDonGia(double donGia) {
        this.donGia = donGia;
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
     * @return the sTT
     */
    public int getsTT() {
        return sTT;
    }

    /**
     * @param sTT the sTT to set
     */
    public void setsTT(int sTT) {
        this.sTT = sTT;
    }

    /**
     * @return the ngayLapHoaDon
     */
    public String getNgayLapHoaDon() {
        return ngayLapHoaDon;
    }

    /**
     * @param ngayLapHoaDon the ngayLapHoaDon to set
     */
    public void setNgayLapHoaDon(String ngayLapHoaDon) {
        this.ngayLapHoaDon = ngayLapHoaDon;
    }

    /**
     * @return the maNhanVien
     */
    public String getMaNhanVien() {
        return maNhanVien;
    }

    /**
     * @param maNhanVien the maNhanVien to set
     */
    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    /**
     * @return the maThe
     */
    public String getMaThe() {
        return maThe;
    }

    /**
     * @param maThe the maThe to set
     */
    public void setMaThe(String maThe) {
        this.maThe = maThe;
    }

    /**
     * @return the soHoaDon
     */
    
}

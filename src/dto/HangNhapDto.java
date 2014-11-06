/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author YONGSOKHENG
 */
public class HangNhapDto {
    
    private String maDonHang;
    private String maHang;
    private double soLuong;

    public HangNhapDto() {
    }

    
    
    public HangNhapDto(String maDonHang, String maHang, double soLuong) {
        this.maDonHang = maDonHang;
        this.maHang = maHang;
        this.soLuong = soLuong;
    }

    /**
     * @return the maDonHang
     */
    public String getMaDonHang() {
        return maDonHang;
    }

    /**
     * @param maDonHang the maDonHang to set
     */
    public void setMaDonHang(String maDonHang) {
        this.maDonHang = maDonHang;
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
    
    
    
}

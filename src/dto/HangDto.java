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
public class HangDto {
    
    private String maHang;
    private String tenHang;
    private String donViTinh;
    private String ghiChu;
    private String maLoaiHang;
    private String maNcc;
    private double giaNhap;
    private double giaBan;

    public HangDto() {
    }
    
    

    public HangDto(String maHang, String tenHang, String donViTinh, String ghiChu, String maLoaiHang, String maNcc, double giaNhap, double giaBan) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.donViTinh = donViTinh;
        this.ghiChu = ghiChu;
        this.maLoaiHang = maLoaiHang;
        this.maNcc = maNcc;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
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

    /**
     * @return the maLoaiHang
     */
    public String getMaLoaiHang() {
        return maLoaiHang;
    }

    /**
     * @param maLoaiHang the maLoaiHang to set
     */
    public void setMaLoaiHang(String maLoaiHang) {
        this.maLoaiHang = maLoaiHang;
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
    
    
}

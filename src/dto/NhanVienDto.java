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
public class NhanVienDto {
    
    private String maNhanVien;
    private String tenNhanVien;
    private String dienThoai;
    private String moTa;

    public NhanVienDto() {
    }

    
    
    public NhanVienDto(String maNhanVien, String tenNhanVien, String dienThoai, String moTa) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.dienThoai = dienThoai;
        this.moTa = moTa;
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
     * @return the tenNhanVien
     */
    public String getTenNhanVien() {
        return tenNhanVien;
    }

    /**
     * @param tenNhanVien the tenNhanVien to set
     */
    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    /**
     * @return the dienThoai
     */
    public String getDienThoai() {
        return dienThoai;
    }

    /**
     * @param dienThoai the dienThoai to set
     */
    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    /**
     * @return the moTa
     */
    public String getMoTa() {
        return moTa;
    }

    /**
     * @param moTa the moTa to set
     */
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
    
}

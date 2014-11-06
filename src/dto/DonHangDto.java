/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author YONGSOKHENG
 */
public class DonHangDto
{
    
    private String maDonHang;
    private LocalDate ngayNhapHang;
    private String maNv;
    private String maNcc;

    public DonHangDto() {
    }

    
    
    public DonHangDto(String maDonHang, LocalDate ngayNhapHang, String maNv, String maNcc) {
        this.maDonHang = maDonHang;
        this.ngayNhapHang = ngayNhapHang;
        this.maNv = maNv;
        this.maNcc = maNcc;
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
     * @return the ngayNhapHang
     */
    public LocalDate getNgayNhapHang() {
        return ngayNhapHang;
    }

    /**
     * @param ngayNhapHang the ngayNhapHang to set
     */
    public void setNgayNhapHang(LocalDate ngayNhapHang) {
        this.ngayNhapHang = ngayNhapHang;
    }

    /**
     * @return the maNv
     */
    public String getMaNv() {
        return maNv;
    }

    /**
     * @param maNv the maNv to set
     */
    public void setMaNv(String maNv) {
        this.maNv = maNv;
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
    
    
}

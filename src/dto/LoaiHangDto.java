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
public class LoaiHangDto {
    
    private String maLoaiHang;
    private String tenLoaiHang;

    public LoaiHangDto() {
    }

    public LoaiHangDto(String maLoaiHang, String tenLoaiHang) {
        this.maLoaiHang = maLoaiHang;
        this.tenLoaiHang = tenLoaiHang;
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
     * @return the tenLoaiHang
     */
    public String getTenLoaiHang() {
        return tenLoaiHang;
    }

    /**
     * @param tenLoaiHang the tenLoaiHang to set
     */
    public void setTenLoaiHang(String tenLoaiHang) {
        this.tenLoaiHang = tenLoaiHang;
    }

   
    
}

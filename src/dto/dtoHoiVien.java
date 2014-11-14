/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dto;

import javafx.scene.control.ComboBox;

/**
 *
 * @author Luckydays
 */
public class dtoHoiVien {
    
    private String maHoiVien;
    private String hoTenHoiVien;
    private String gioiTinh;
    private String dienThoai;
    private String diaChi;
    private String tenCoQuan;
    private String maSoThue;
   
    
    
    public dtoHoiVien(){
        
    }
    
    public dtoHoiVien(String maHoiVien,String hotenHoiVien, String gioiTinh, String dienThoai, String diaChi, String tenCoQuan){
        
        this.maHoiVien = maHoiVien;
        this.hoTenHoiVien = hotenHoiVien;
        this.gioiTinh = gioiTinh;
        this.dienThoai = dienThoai;
        this.diaChi = diaChi;
        this.tenCoQuan = tenCoQuan;
       
       
        
    }
    
    public String getMaHoiVien(){
        return maHoiVien;
    }

    public String getHoTenHoiVien() {
        return hoTenHoiVien;
    }

    public String getGioiTinh() {
        return gioiTinh ;
        
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getTenCoQuan() {
        return tenCoQuan;
    }

    public String getMaSoThue() {
        return maSoThue;
    }

  
    public void setMaHoiVien(String maHoiVien){
        this.maHoiVien = maHoiVien;
    }

    public void setHoTenHoiVien(String hoTenHoiVien) {
        this.hoTenHoiVien = hoTenHoiVien;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setTenCoQuan(String tenCoQuan) {
        this.tenCoQuan = tenCoQuan;
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

  
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dto;

/**
 *
 * @author Luckydays
 */
public class dtoTTLoaiHang {
    
    String maLoaiHang;
    String tenLoaiHang;
    
    public dtoTTLoaiHang(){}
    
    public dtoTTLoaiHang(String maLoaiHang, String tenLoaiHang){
    
        this.maLoaiHang = maLoaiHang;
        this.tenLoaiHang = tenLoaiHang;
    
    }

    public String getMaLoaiHang() {
        return maLoaiHang;
    }

    public String getTenLoaiHang() {
        return tenLoaiHang;
    }

    public void setMaLoaiHang(String maLoaiHang) {
        this.maLoaiHang = maLoaiHang;
    }

    public void setTenLoaiHang(String tenLoaiHang) {
        this.tenLoaiHang = tenLoaiHang;
    }
    
    
    
}

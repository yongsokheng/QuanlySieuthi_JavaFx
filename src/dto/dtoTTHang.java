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
public class dtoTTHang {
    
    
                String maHang;
                String tenHang;
                String maLoaiHang;
                String maNhaCungCap;
                String donviTinh;
                double giaNhap;
                double giaBan;
                String ghiChu;
                String ngayHSD;
                
               public dtoTTHang(){}
               
               public dtoTTHang(String mahang , String tenhang , String maloaihang ,String manhacungcap , String donvitinh , double gianhap , double giaban , String ghichu , String ngayHSD){
               
                   
                   this.maHang = mahang;
                   this.tenHang = tenhang ;
                   this.maLoaiHang = maloaihang;
                   this.maNhaCungCap = manhacungcap ;
                   this.donviTinh = donvitinh;
                   this.giaNhap = gianhap;
                   this.giaBan = giaban;
                   this.ghiChu = ghichu;
                   this.ngayHSD = ngayHSD;
               
               }

    public String getMaHang() {
        return maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public String getMaLoaiHang() {
        return maLoaiHang;
    }

    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public String getDonviTinh() {
        return donviTinh;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public String getNgayHSD() {
        return ngayHSD;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public void setMaLoaiHang(String maLoaiHang) {
        this.maLoaiHang = maLoaiHang;
    }

    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public void setDonviTinh(String donviTinh) {
        this.donviTinh = donviTinh;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public void setNgayHSD(String ngayHSD) {
        this.ngayHSD = ngayHSD;
    }
               
               
               
    
}

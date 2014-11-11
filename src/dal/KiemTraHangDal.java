/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dto.DonNhapHangDto;
import dto.HangDto;
import dto.KhoSanPhamDto;
import dto.LoaiHangDto;
import dto.NccDto;
import dto.TimHangDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author YONGSOKHENG
 */
public class KiemTraHangDal {
    
    DatabaseManager db=new DatabaseManager();
    
    private ObservableList<TimHangDto> data=FXCollections.observableArrayList();
    private ObservableList<String> dataNcc=FXCollections.observableArrayList();
    private ObservableList<String> dataLoaiHang=FXCollections.observableArrayList();
    ResultSet resultSet;
    
    //Tim kiem theo maHang
    public ResultSet timKiemTheoMaHang(HangDto hangDto)
    {
       String sql="SELECT * FROM hang,nhacungcap,loaihang,khosanpham "
               + "WHERE nhacungcap.maNCC=hang.maNCC "
               + "AND loaihang.maLoaiHang=hang.maLoaiHang "
               + "AND hang.maHang=khosanpham.maHang "
               + "AND hang.maHang='"+hangDto.getMaHang()+"'";
              
       
       resultSet=db.loadData(sql);
       return resultSet;
       
    }
    
     //Tim kiem theo tenHang
    public ResultSet timKiemTheoTenHang(HangDto hangDto)
    {
       String sql="SELECT * FROM hang,nhacungcap,loaihang,khosanpham "
               + "WHERE nhacungcap.maNCC=hang.maNCC "
               + "AND loaihang.maLoaiHang=hang.maLoaiHang "
               + "AND hang.maHang=khosanpham.maHang "
               + "AND hang.tenHang like '%"+hangDto.getTenHang()+"%'";
              
       
       resultSet=db.loadData(sql);
       return resultSet;
       
    }
    
     //Tim kiem theo ten Nha cung cap
    public ResultSet timKiemTheoTenNcc(NccDto nccDto)
    {
       String sql="SELECT * FROM hang,nhacungcap,loaihang,khosanpham "
               + "WHERE nhacungcap.maNCC=hang.maNCC "
               + "AND loaihang.maLoaiHang=hang.maLoaiHang "
               + "AND hang.maHang=khosanpham.maHang "
               + "AND nhacungcap.tenNCC like '%"+nccDto.getTenNcc()+"%'";
              
       
       resultSet=db.loadData(sql);
       return resultSet;
       
    }
    
    //Tim kiem theo ten Loai Hang
    public ResultSet timKiemTheoLoaiHang(LoaiHangDto loaiHangDto)
    {
       String sql="SELECT * FROM hang,nhacungcap,loaihang,khosanpham "
               + "WHERE nhacungcap.maNCC=hang.maNCC "
               + "AND loaihang.maLoaiHang=hang.maLoaiHang "
               + "AND hang.maHang=khosanpham.maHang "
               + "AND loaihang.tenLoaiHang= '"+loaiHangDto.getTenLoaiHang()+"'";
              
       
       resultSet=db.loadData(sql);
       return resultSet;
       
    }
    
     //Tim kiem hang con trong kho
    public ResultSet timKiemHangCon()
    {
       String sql="SELECT * FROM hang,nhacungcap,loaihang,khosanpham "
               + "WHERE nhacungcap.maNCC=hang.maNCC "
               + "AND loaihang.maLoaiHang=hang.maLoaiHang "
               + "AND hang.maHang=khosanpham.maHang "
               + "AND khosanpham.soLuong<>0";
              
       
       resultSet=db.loadData(sql);
       return resultSet;
       
    }
    
     //Tim kiem hang khong con trong kho
    public ResultSet timKiemHangHet()
    {
       String sql="SELECT * FROM hang,nhacungcap,loaihang,khosanpham "
               + "WHERE nhacungcap.maNCC=hang.maNCC "
               + "AND loaihang.maLoaiHang=hang.maLoaiHang "
               + "AND hang.maHang=khosanpham.maHang "
               + "AND khosanpham.soLuong=0";
              
       resultSet=db.loadData(sql);
       return resultSet;
       
    }
    
    //Tim kiem hang het han
    public ResultSet timKiemHangHetHan(LocalDate tuNgay, LocalDate denNgay)
    {
       String sql="SELECT * FROM hang,nhacungcap,loaihang,khosanpham "
               + "WHERE nhacungcap.maNCC=hang.maNCC "
               + "AND loaihang.maLoaiHang=hang.maLoaiHang "
               + "AND hang.maHang=khosanpham.maHang "
               + "AND hang.ngayHSD>='"+tuNgay+"'"
               + "AND hang.ngayHSD<='"+denNgay+"'";
              
       resultSet=db.loadData(sql);
       return resultSet;
       
    }
    
    
     // Ket qua hien thi vao trong tabble
     public ObservableList<TimHangDto> loadData(ResultSet resultSet)
     {
        try {
        
            while(resultSet.next())
            {
                SimpleDateFormat oldFormat = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat newFormat = new SimpleDateFormat("dd-MM-yyyy");
                
                String maHang=resultSet.getString("maHang");
                String tenHang=resultSet.getString("tenHang");
                String donViTinh=resultSet.getString("donViTinh");
                String loaiHang=resultSet.getString("tenLoaiHang");
                String ncc=resultSet.getString("tenNCC");
                double giaNhap=Double.parseDouble(resultSet.getString("giaNhap"));
                double giaBan=Double.parseDouble(resultSet.getString("giaBan"));
                String ngayHSD=newFormat.format(oldFormat.parse(resultSet.getString("ngayHSD")));
                double soLuong=Double.parseDouble(resultSet.getString("soLuong"));
                String ghiChu=resultSet.getString("ghiChu");
   
                data.add(new TimHangDto(maHang, tenHang, donViTinh, loaiHang, ncc, giaNhap, giaBan, ngayHSD, soLuong, ghiChu));
            }
            
            resultSet.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DonNhapHangDal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DonNhapHangDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }
     
     //Load ten nha cung cap
     
     public ObservableList<String> loadTenNcc()
     {
        try {
            resultSet=db.loadData("SELECT * FROM nhacungcap");
            while(resultSet.next())
            {
                dataNcc.add(resultSet.getString("tenNCC")); 
            }
            resultSet.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(KiemTraHangDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dataNcc;
     }
     
     //Load ten loai hang
     
     public ObservableList<String> loadTenLoaiHang()
     {
        try {
            resultSet=db.loadData("SELECT * FROM loaihang");
            while(resultSet.next())
            {
                dataLoaiHang.add(resultSet.getString("tenLoaiHang")); 
            }
            resultSet.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(KiemTraHangDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dataLoaiHang;
     }
    
    
}

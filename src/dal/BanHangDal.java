/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dto.BanHangDto;
import dto.NhanVienDto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class BanHangDal {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    
    private final String DRIVER="com.mysql.jdbc.Driver";
    private final String DATABASE= "jdbc:mysql://localhost/quanlysieuthi";
    
    
    DatabaseManager db=new DatabaseManager();
    BanHangDto banHangDto=new BanHangDto();
    private ObservableList<BanHangDto> data=FXCollections.observableArrayList();
    
    
    public ObservableList<BanHangDto> loadData(ResultSet resultSet)
    {
        try {
                int sTT;
                String maSanPham;
                String tenSanPham;
                double soLuong;
                double donGia;
                String donViTinh;
                double thanhTien;
                banHangDto.setThanhTien(10);
                banHangDto.setsTT(2);
                while(resultSet.next())
                {
                    sTT=resultSet.getInt("sTT");
                    maSanPham=resultSet.getString("maSanPham");
                    tenSanPham=resultSet.getString("tenSanPham");
                    soLuong=resultSet.getDouble("soLuong");
                    donGia=resultSet.getDouble("donGia");
                    donViTinh=resultSet.getString("donViTinh");
                    thanhTien=resultSet.getDouble("thanhTien");
                    data.add(new BanHangDto(sTT,maSanPham,tenSanPham,soLuong,donGia,donViTinh,thanhTien));
                }             
                resultSet.close();
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }       
        return data;   
    }
    
    public ObservableList<BanHangDto> Data(ResultSet resultSet)
    {
        try {
                String tenSanPham;
                double donGia;
                String donViTinh;
                
                while(resultSet.next())    {
                   
                    tenSanPham=(resultSet.getString("tenHang"));   
                    donGia=(resultSet.getDouble("giaBan"));
                    donViTinh=(resultSet.getString("donViTinh"));
                    data.add( new BanHangDto(tenSanPham,1,donGia,donViTinh));
                }      
                
                resultSet.close();
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }  
        return data;
    }
    
      public ObservableList<BanHangDto> Data1(ResultSet resultSet,BanHangDto banHangDto)
    {
        try {  
            if(resultSet.isBeforeFirst())  
                {
                while(resultSet.next())    {
                    
                    banHangDto.setTenSanPham(resultSet.getString("tenHang"));
                    banHangDto.setThanhTien(resultSet.getDouble("giaBan"));
                    banHangDto.setDonViTinh(resultSet.getString("donViTinh"));
                }                     
            }
            else{
                JOptionPane.showMessageDialog(null, "Hang khong tim thay");
            }
                resultSet.close();
            } catch (SQLException ex) { 
                JOptionPane.showMessageDialog(null, "Hang khong tim thay");
        }  
        return data;
    }
    
   
    
    public int themHangVaoHangBan(BanHangDto banHangDto){
        
        int result;        
        String sql="INSERT INTO HangBan VALUES ("+ banHangDto.getMaSanPham()+" ," +banHangDto.getMaHoaDon()+","+banHangDto.getSoLuong()+" ,"+banHangDto.getDonGia()+") ";
        result= db.executeData(sql);
        return result;
    }
    
    
     public ResultSet setData(BanHangDto banHangDto)
    {
        resultSet=db.loadData("SELECT tenHang,giaBan,donViTinh FROM Hang WHERE maHang="+banHangDto.getMaSanPham()+"");
        return resultSet;
    }
     
}

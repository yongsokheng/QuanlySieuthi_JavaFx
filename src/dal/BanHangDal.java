/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dto.BanHangDto;
import dto.NhanVienDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class BanHangDal {
   
    DatabaseManager db=new DatabaseManager();
    BanHangDto banHangDto=new BanHangDto();
    ResultSet resultSet;
    
    private ObservableList<BanHangDto> data=FXCollections.observableArrayList();
     
    public ObservableList<BanHangDto> loadData(ResultSet resultSet)
    { 
        try {
                int sTT=0;
                String maSanPham;
                String tenSanPham;
                double soLuong;
                double donGia;
                String donViTinh;
                double thanhTien;
                while(resultSet.next())
                {                
                    maSanPham=resultSet.getString("maHang");
                    tenSanPham=resultSet.getString("tenHang");
                    soLuong=resultSet.getDouble("soLuong");
                    donGia=resultSet.getDouble("giaBan");
                    donViTinh=resultSet.getString("donViTinh");
                    thanhTien=resultSet.getDouble("thanhTien");
                    data.add(new BanHangDto(++sTT,maSanPham,tenSanPham,soLuong,donGia,donViTinh,thanhTien));
                }             
                resultSet.close();
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }       
        return data;   
    }
    
    public void loadMaHoaDon(ResultSet resultSet, BanHangDto banHangDto) {
        try {

            {
                while (resultSet.next()) {
                    if (resultSet.last()) {
                        banHangDto.setMaHoaDon(resultSet.getString("maHoaDon"));
                    }

                }
            }

            resultSet.close();
        } catch (SQLException ex) {

        }
    }
    
      public ObservableList<BanHangDto> loadDataToTextField(ResultSet resultSet,BanHangDto banHangDto)
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
                banHangDto.setTenSanPham("");
                JOptionPane.showMessageDialog(null, "Hang khong tim thay");
            }
                resultSet.close();
            } catch (SQLException ex) { 
 
        }  
        return data;
    }
    

    public ResultSet getTableData(BanHangDto banHangDto){
    
        String sql="SELECT HangBan.maHang,tenHang,soLuong,giaBan,donViTinh,soLuong * donGia as thanhTien FROM HoaDon,HangBan,Hang WHERE HoaDon.soHoaDon=HangBan.soHoaDon AND HangBan.maHang=Hang.maHang";
        resultSet=db.loadData(sql);
        return resultSet;
    }  
      
    public int themHangVaoDonHang(BanHangDto banHangDto){
        int result;
        //JOptionPane.showMessageDialog(null, banHangDto.getMaHoaDon());
        String sql="INSERT INTO HoaDon VALUES("+banHangDto.getMaHoaDon()+",'"+ banHangDto.getNgayLapHoaDon()+"','"+banHangDto.getMaNhanVien()+"','"+banHangDto.getMaThe()+"' )";
        result=db.executeData(sql);       
        return result;
    }
    
    public int themHangVaoHangBan(BanHangDto banHangDto){     
        int result;  
        String sql="INSERT INTO HangBan VALUES ("+banHangDto.getSoLuong()+","+banHangDto.getDonGia()+","+banHangDto.getMaSanPham()+","+banHangDto.getMaHoaDon()+")";
        result= db.executeData(sql);
        return result;
    }
    public int updateKhoSanPham(BanHangDto banHangDto){
        int result;
        String sql="UPDATE KhoSanPham SET soLuong=soLuong -"+banHangDto.getSoLuong()+" WHERE maHang="+banHangDto.getMaSanPham()+" AND soLuong>="+banHangDto.getSoLuong()+"";
        result=db.executeData(sql);
        return result;
    }
    
    
     public ResultSet setData(BanHangDto banHangDto)
    {
        String sql="SELECT tenHang,giaBan,donViTinh FROM Hang WHERE maHang="+banHangDto.getMaSanPham()+"";
        resultSet=db.loadData(sql);
        return resultSet;
    }
     
     public ResultSet setMaHoaDon(BanHangDto banHangDto){
         String sql="SELECT soHoaDon FROM HoaDon ORDER BY soHoaDon";
         resultSet=db.loadData(sql);
         return resultSet;
     }
     
     public int deleteData(BanHangDto banHangDto)
    {
      String sql="DELETE FROM hoadon WHERE soHoaDon='"+banHangDto.getMaHoaDon()+"'";
      int result=db.executeData(sql);
      return result;
    }
}

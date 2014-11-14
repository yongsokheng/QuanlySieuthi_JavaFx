/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dal;

import dto.dtoHoiVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Luckydays
 */
public class dalHoiVien {
    
    DatabaseManager db=new DatabaseManager();
    dtoHoiVien dtoHV = new dtoHoiVien();
    
    
    ResultSet resultSet;
    private ObservableList<dtoHoiVien> data=FXCollections.observableArrayList();
    
    
    
    public ObservableList<dtoHoiVien> loadData()
    {
        try {
            
                String maHoiVien;
                String hoTenHoiVien;
                String gioiTinh;
                String dienThoai;
                String diaChi;
                String tenCoQuan;
               
               
               
                resultSet=db.loadData("SELECT * FROM hoivien");
                while(resultSet.next())
                {
                    maHoiVien = resultSet.getString("maHoiVien");
                    hoTenHoiVien=resultSet.getString("tenHoiVien");
                    gioiTinh=resultSet.getString("GoiTinh");
                    dienThoai=resultSet.getString("DienThoai");
                    diaChi=resultSet.getString("diaChi");
                    tenCoQuan = resultSet.getString("TenCoQuan");
                    
                  data.add(new dtoHoiVien(maHoiVien,hoTenHoiVien,gioiTinh,dienThoai,diaChi,tenCoQuan));
                }
                
                resultSet.close();
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        return data;
    
    }
    
    
    public int saveData(dtoHoiVien dtoHoiVien)
    {
        String sql="INSERT INTO hoivien VALUES('"+ dtoHoiVien.getMaHoiVien()+"','"+ dtoHoiVien.getHoTenHoiVien()+"','"+ dtoHoiVien.getGioiTinh()+"','"+ dtoHoiVien.getDienThoai()+ "','"+ dtoHoiVien.getTenCoQuan() + "','"+ dtoHoiVien.getDiaChi() +"')";
        int result=db.executeData(sql);
        return result;
    }
    
    public int deleteData(dtoHoiVien dtoHv)
    {
      String sql="DELETE FROM hoivien WHERE maHoiVien='"+dtoHv.getMaHoiVien()+"'";
      int result=db.executeData(sql);
      return result;
    }
    
   public int updateData(dtoHoiVien dtoHoiVien, String ma)
   {
      String sql="UPDATE hoivien SET maHoiVien='"+ dtoHoiVien.getMaHoiVien()+"',tenHoiVien='"+ dtoHoiVien.getHoTenHoiVien()+"', GoiTinh='"+dtoHoiVien.getGioiTinh()+"',diaChi='"+dtoHoiVien.getDiaChi()+"',DienThoai='"+dtoHoiVien.getDienThoai() + "',TenCoQuan='"+dtoHoiVien.getTenCoQuan() + "' WHERE maHoiVien='"+ma+"'";
      int result=db.executeData(sql);
      return result;
   }
}

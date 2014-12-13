/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dal;

import dto.dtoTTLoaiHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author Luckydays
 */
public class dalTTLoaiHang {
    
    
    DatabaseManager db = new DatabaseManager();
    dtoTTLoaiHang dtottloaihang = new dtoTTLoaiHang();
    
    ResultSet resultSet;
    private ObservableList<dtoTTLoaiHang> data=FXCollections.observableArrayList();
    
    public ObservableList<dtoTTLoaiHang> loadData(ResultSet resultSet)
    {
        try {
            
                String maLoaiHang;
                String tenLoaiHang;
                
    
     while(resultSet.next())
                {
                    maLoaiHang = resultSet.getString("maLoaiHang");
                    tenLoaiHang=resultSet.getString("tenLoaiHang");
                    
                     
                  data.add(new dtoTTLoaiHang(maLoaiHang,tenLoaiHang));
                }
     resultSet.close();
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        return data;
    
    }
     public ResultSet getLoaiHang()
    {
        resultSet=db.loadData("SELECT * FROM loaihang");
        return resultSet;
    }
     public ResultSet timLoaiHangtheoMa(dtoTTLoaiHang dtottloaihang)
    {
        resultSet=db.loadData("SELECT * FROM loaihang WHERE maLoaiHang='"+dtottloaihang.getMaLoaiHang()+"'");
        return resultSet;
    }
    
    public ResultSet timLoaiHangtheoTen(dtoTTLoaiHang dtottloaihang)
    {
        resultSet=db.loadData("SELECT * FROM loaihang WHERE tenLoaiHang like '%"+dtottloaihang.getTenLoaiHang()+"%'");
        return resultSet;
    }
    
    public int saveData(dtoTTLoaiHang dtottloaihang)
    {
      
      //  System.out.print("Hello db");
        String sql="INSERT INTO loaihang(maLoaiHang,tenLoaiHang) VALUES("
                + "'"+ dtottloaihang.getMaLoaiHang()+"',"
                + "'"+ dtottloaihang.getTenLoaiHang()+"')";
                
        
        int result=db.executeData(sql);
        return result;
    }
    
    public int deleteData(dtoTTLoaiHang dtottloaihang)
    {
      String sql=" DELETE FROM loaihang WHERE maLoaiHang='"+dtottloaihang.getMaLoaiHang()+"'";
      int result=db.executeData(sql);
      return result;
    }
    
   public int updateData(dtoTTLoaiHang dtottloaihang, String ma)
   {
      String sql=" UPDATE loaihang  SET maLoaiHang = '" + dtottloaihang.getMaLoaiHang() + 
                 "' , tenLoaiHang = '" + dtottloaihang.getTenLoaiHang()  + "' WHERE maLoaiHang =  '" + ma + "' " ;
                                          
      int result=db.executeData(sql);
      return result;
   }
    
    
}

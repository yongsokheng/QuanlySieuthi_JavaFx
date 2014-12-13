/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dal;

import dto.NccDto;
import dto.dtoTTHang;
import dto.dtoTTLoaiHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author Luckydays
 */
public class dalTTHang {
    
    DatabaseManager db = new DatabaseManager();
    dtoTTHang dtotthang = new dtoTTHang();
    
    ResultSet resultSet;
    private ObservableList<dtoTTHang> data=FXCollections.observableArrayList();
    private ObservableList<String> dataMaLoaiHang=FXCollections.observableArrayList();
    private ObservableList<String> dataMaNCC=FXCollections.observableArrayList();
     private ObservableList<String> dataTenNCC=FXCollections.observableArrayList();
      private ObservableList<String> dataTenLoaiHang=FXCollections.observableArrayList();
    public ObservableList<String> loadDataLoaiHang()
    {
        try {
            
            resultSet=db.loadData("SELECT maLoaiHang FROM loaihang");
            while(resultSet.next())
            {
                dataMaLoaiHang.add(resultSet.getString("maLoaiHang"));
            }
            
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(dalTTHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dataMaLoaiHang;
    }
    public String loadDataTenLoaiHang(dtoTTLoaiHang dtottloaihang){
    
    String tenLoaiHang=null;
        
        try {
            
           if(!dtottloaihang.getMaLoaiHang().isEmpty())
           {
           
               String sql="SELECT tenLoaiHang FROM loaihang WHERE maLoaiHang='"+ dtottloaihang.getMaLoaiHang()+"'";
                resultSet=db.loadData(sql);
                if(resultSet.next())
                {
                   tenLoaiHang=resultSet.getString("tenLoaiHang");
                }
           
           }
            
            resultSet.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(dalTTHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tenLoaiHang;
    }
    public ObservableList<String> loadDataMaNCC()
    {
        try {
            
            resultSet=db.loadData("SELECT maNCC FROM nhacungcap");
            while(resultSet.next())
            {
                dataMaNCC.add(resultSet.getString("maNCC"));
            }
            
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(dalTTHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dataMaNCC;
    }
    
    public String loadDataTenNCC(NccDto nccdto){
    
    String tenNCC=null;
        
        try {
            
           if(!nccdto.getMaNcc().isEmpty())
           {
           
               String sql="SELECT tenNCC FROM nhacungcap WHERE maNCC='"+ nccdto.getMaNcc()+"'";
                resultSet=db.loadData(sql);
                if(resultSet.next())
                {
                   tenNCC=resultSet.getString("tenNCC");
                }
           
           }
            
            resultSet.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(dalTTHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tenNCC;
    }
    public ObservableList<dtoTTHang> loadData(ResultSet resultSet)
    {
        try {
            
                String maHang;
                String tenHang;
                String maLoaiHang;
                String maNhaCungCap;
                String donviTinh;
                double giaNhap;
                double giaBan;
                String ghiChu;
                String ngayHSD;
    
     while(resultSet.next())
                {
                    maHang = resultSet.getString("maHang");
                    tenHang=resultSet.getString("tenHang");
                    maLoaiHang=resultSet.getString("maLoaiHang");
                    maNhaCungCap=resultSet.getString("maNCC");
                    donviTinh=resultSet.getString("donViTinh");
                    giaNhap = Double.parseDouble(resultSet.getString("giaNhap"));
                    giaBan = Double.parseDouble(resultSet.getString("giaBan"));
                    ghiChu = resultSet.getString("ghiChu");
                    ngayHSD = resultSet.getString("NgayHSD");
                    
                    
                  data.add(new dtoTTHang(maHang,tenHang,maLoaiHang,maNhaCungCap,donviTinh,giaNhap,giaBan,ghiChu,ngayHSD));
                }
     resultSet.close();
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        return data;
    
    }
    
     public ResultSet getHang()
    {
        resultSet=db.loadData("SELECT * FROM hang");
        return resultSet;
    }
    
    public ResultSet timHangTheoMa(dtoTTHang  dtotthang)
    {
        resultSet=db.loadData("SELECT * FROM hang WHERE maHang='"+dtotthang.getMaHang()+"'");
        return resultSet;
    }
    
    public ResultSet timHangTheoTen(dtoTTHang dtotthang)
    {
        resultSet=db.loadData("SELECT * FROM hang WHERE tenHang like '%"+dtotthang.getTenHang()+"%'");
        return resultSet;
    }
    public int saveData(dtoTTHang dtotthang)
    {
      
        String sql="INSERT INTO hang(maHang,tenHang, maLoaiHang,maNCC ,donViTinh, giaNhap, giaBan,ghiChu, ngayHSD) VALUES("
                + "'"+ dtotthang.getMaHang()+"',"
                + "'"+ dtotthang.getTenHang()+"',"
                + "'"+ dtotthang.getMaLoaiHang()+"',"
                + "'"+ dtotthang.getMaNhaCungCap()+ "',"
                + "'"+dtotthang.getDonviTinh() +"',"
                + dtotthang.getGiaNhap() +","
                + dtotthang.getGiaBan() + ","
                + "'"+ dtotthang.getGhiChu() +  "',"
                + "'"+ dtotthang.getNgayHSD() + "')";
        
        int result=db.executeData(sql);
        return result;
    }
    
    public int deleteData(dtoTTHang dtotthang)
    {
      String sql="DELETE FROM hang WHERE maHang='"+dtotthang.getMaHang()+"'";
      int result=db.executeData(sql);
      return result;
    }
    
   public int updateData(dtoTTHang dtotthang, String ma)
   {
      String sql="UPDATE hang SET maHang = '" + dtotthang.getMaHang() + "',tenHang='"+ dtotthang.getTenHang() +"', maLoaiHang ='"+dtotthang.getMaLoaiHang() +
                                           "',maNCC ='"+dtotthang.getMaNhaCungCap() +"',donViTinh='"+dtotthang.getDonviTinh() + "',giaNhap ='" + dtotthang.getGiaNhap()  + 
                                           "',giaBan ='" + dtotthang.getGiaBan()  + "',ghiChu ='" + dtotthang.getGhiChu()  +  "',ngayHSD ='" + dtotthang.getNgayHSD()  + "' WHERE maHang=  '" + ma + "'" ;
      int result=db.executeData(sql);
      return result;
   }
    
    
    
    
    
    
    
    
    
    
    
    
    
}

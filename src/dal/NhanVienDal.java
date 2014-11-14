/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dal;

import dto.NhanVienDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author NGENG CHHENGKIM
 */
public class NhanVienDal {
    NhanVienDto nvdto=new NhanVienDto();
    DatabaseManager db=new DatabaseManager();
    ResultSet resultSet;
    private ObservableList<NhanVienDto> data=FXCollections.observableArrayList();
    
    public ObservableList<NhanVienDto> loadData()
    {
        try {
                String maNhanVien;
                String tenNhanvien;
                String soDienThoaiNhanVien;
                String moTaNhanVien;
                resultSet=db.loadData("SELECT * FROM nhanvien");
                while(resultSet.next())
                {
                    maNhanVien=resultSet.getString("maNV");
                    tenNhanvien=resultSet.getString("tenNhanvien");
                    soDienThoaiNhanVien=resultSet.getString("dienThoaiLH");
                    moTaNhanVien=resultSet.getString("moTa");
                    data.add(new NhanVienDto(maNhanVien,tenNhanvien,soDienThoaiNhanVien,moTaNhanVien));
                }
                
                resultSet.close();
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        return data;
    
    }
    
    public int saveData(NhanVienDto nvdto)
    {
        String sql="INSERT INTO nhanvien VALUES('"+nvdto.getMaNhanVien()+"','"+nvdto.getTenNhanVien()+"','"+nvdto.getDienThoai()+"','"+nvdto.getMoTa()+"')";       
        int result=db.executeData(sql);
       
        return result;
    }
    
    public int deleteData(NhanVienDto nvdto)
    {
      String sql="DELETE FROM NhanVien WHERE maNV='"+nvdto.getMaNhanVien()+"'";
      int result=db.executeData(sql);
      return result;
    }
    
   public int updateData(NhanVienDto nvdto, String ma)
   {
      String sql="UPDATE NhanVien SET maNV='"+nvdto.getMaNhanVien()+"',tenNhanVien='"+nvdto.getTenNhanVien()+"', dienThoaiLH='"+nvdto.getDienThoai()+"',moTa='"+nvdto.getMoTa()+"' WHERE maNV='"+ma+"'";
      int result=db.executeData(sql);
      return result;
   }
    
}

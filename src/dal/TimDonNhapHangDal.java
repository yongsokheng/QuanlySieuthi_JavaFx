/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dto.DonHangDto;
import dto.DonNhapHangDto;
import dto.HangDto;
import dto.HangNhapDto;
import dto.LoaiHangDto;
import dto.NccDto;
import dto.NhanVienDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author YONGSOKHENG
 */
public class TimDonNhapHangDal {
    
    DatabaseManager db=new DatabaseManager();
    ResultSet resultSet;
    
    private ObservableList<DonNhapHangDto> data=FXCollections.observableArrayList();
    
    //Tim theo maHoaDon
    public ResultSet timTheoMaHoaDon(DonHangDto donHangDto)
    {
         String sql="SELECT * FROM donhang,hangnhap,hang,loaihang,nhanvien,nhacungcap "
                    + "WHERE donhang.maDonHang=hangnhap.maDonHang "
                    + "AND hang.maHang=hangNhap.maHang "
                    + "AND loaihang.maLoaiHang=hang.maLoaiHang "
                    + "AND nhanvien.maNV=donhang.maNV "
                    + "AND nhacungcap.maNCC=donhang.maNCC "
                    + "AND donhang.maDonHang='"+donHangDto.getMaDonHang()+"'";
        
          resultSet=db.loadData(sql);
          return resultSet;
    }
    
    // Tim theo ngayNhapHang
    public ResultSet timTheoNgayNhapHang(DonHangDto donHangDto)
    {
         String sql="SELECT * FROM donhang,hangnhap,hang,loaihang,nhanvien,nhacungcap "
                    + "WHERE donhang.maDonHang=hangnhap.maDonHang "
                    + "AND hang.maHang=hangNhap.maHang "
                    + "AND loaihang.maLoaiHang=hang.maLoaiHang "
                    + "AND nhanvien.maNV=donhang.maNV "
                    + "AND nhacungcap.maNCC=donhang.maNCC "
                    + "AND donhang.ngayDatHang='"+donHangDto.getNgayNhapHang()+"'";
        
          resultSet=db.loadData(sql);
          return resultSet;
    }
    
     //Tim theo maHoaDon
    public ResultSet hienThiTatCa()
    {
         String sql="SELECT * FROM donhang,hangnhap,hang,loaihang,nhanvien,nhacungcap "
                    + "WHERE donhang.maDonHang=hangnhap.maDonHang "
                    + "AND hang.maHang=hangNhap.maHang "
                    + "AND loaihang.maLoaiHang=hang.maLoaiHang "
                    + "AND nhanvien.maNV=donhang.maNV "
                    + "AND nhacungcap.maNCC=donhang.maNCC";
        
          resultSet=db.loadData(sql);
          return resultSet;
    }
    
    // Ket qua hien thi vao trong tabble
     public ObservableList<DonNhapHangDto> loadData(ResultSet resultSet)
     {
        try {
        
            while(resultSet.next())
            {
                SimpleDateFormat oldFormat = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat newFormat = new SimpleDateFormat("dd-MM-yyyy");
                
                String maHoaDon=resultSet.getString("maDonHang");
                String ngayNhap=newFormat.format(oldFormat.parse(resultSet.getString("ngayDatHang")));
                String tenHang=resultSet.getString("tenHang");
                String loaiHang=resultSet.getString("tenLoaiHang");
                double soLuong=Double.parseDouble(resultSet.getString("soLuong"));
                String donViTinh=resultSet.getString("donViTinh");
                double giaNhap=Double.parseDouble(resultSet.getString("giaNhap"));
                double thanhTien=soLuong*giaNhap;
                String maNcc=resultSet.getString("maNCC");
                String maNv=resultSet.getString("maNV");
                String maHang=resultSet.getString("maHang");
                
                data.add(new DonNhapHangDto(maHoaDon, ngayNhap, tenHang, loaiHang, soLuong, donViTinh, giaNhap, thanhTien,maNcc,maNv,maHang));
                
            }
            
            resultSet.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DonNhapHangDal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DonNhapHangDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }
    
  

    
}

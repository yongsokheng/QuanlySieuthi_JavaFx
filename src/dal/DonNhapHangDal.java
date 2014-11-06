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
public class DonNhapHangDal {
    
    DatabaseManager db=new DatabaseManager();
    ResultSet resultSet;
    
    private ObservableList<String> dataNcc=FXCollections.observableArrayList();
    private ObservableList<String> dataHang=FXCollections.observableArrayList();
    private ObservableList<String> dataNV=FXCollections.observableArrayList();
    private ObservableList<DonNhapHangDto> data=FXCollections.observableArrayList();
    private ObservableList<DonNhapHangDto> dataTableView=FXCollections.observableArrayList(); 
   // Load data Nha cung cap  
    public ObservableList<String> loadDataNcc()
    {
        try {
            
            resultSet=db.loadData("SELECT maNCC FROM nhacungcap");
            while(resultSet.next())
            {
                dataNcc.add(resultSet.getString("maNCC"));
            }
            
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(DonNhapHangDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dataNcc;
    }
    
     // Load ten Nha cung cap theo maNCC
    public String getTenNhaCungCap(NccDto nccDto)
    {
        String tenNcc=null;
        
        try {
            
           if(!nccDto.getMaNcc().isEmpty())
           {
           
               String sql="SELECT tenNCC FROM nhacungcap WHERE maNCC='"+ nccDto.getMaNcc()+"'";
                resultSet=db.loadData(sql);
                if(resultSet.next())
                {
                    tenNcc=resultSet.getString("tenNCC");
                }
           
           }
            
            resultSet.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DonNhapHangDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tenNcc;
    }
    
    // Load data Hang Theo maNCC
    public ObservableList<String> loadDataHang(NccDto nccDto)
    {
        try {
           if(!nccDto.getMaNcc().isEmpty())
           {
               resultSet=db.loadData("SELECT maHang FROM hang WHERE maNCC='"+nccDto.getMaNcc()+"'");
                while(resultSet.next())
                {
                    dataHang.add(resultSet.getString("maHang"));
                }
           }

            resultSet.close();
             
        } catch (SQLException ex) {
            Logger.getLogger(DonNhapHangDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dataHang;
    }
    
     // Load Thong tin hang theo maHang
    public ResultSet getThongTinHang(HangDto hangDto)
    {
       
           if(!hangDto.getMaHang().isEmpty())
           {
               String sql="SELECT * FROM hang,loaihang "
                    + "WHERE hang.maLoaiHang=loaihang.maLoaiHang "
                    + "AND maHang='"+ hangDto.getMaHang()+"'";
               
                resultSet=db.loadData(sql);
           }
            
            return resultSet;
    }
    
    
     // Load data Nhan Vien 
    public ObservableList<String> loadDataNV()
    {
        try {
            
            resultSet=db.loadData("SELECT maNV FROM nhanvien");
            while(resultSet.next())
            {
                dataNV.add(resultSet.getString("maNV"));
            }
            
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(DonNhapHangDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dataNV;
    }
    
     // Load ten nhan vien theo maNV
    public String getTenNV(NhanVienDto nhanVienDto)
    {
        String tenNV=null;
        
        try {
            
           if(!nhanVienDto.getMaNhanVien().isEmpty())
           {
                String sql="SELECT tenNhanVien FROM nhanvien WHERE maNV='"+ nhanVienDto.getMaNhanVien()+"'";
                resultSet=db.loadData(sql);
                if(resultSet.next())
                {
                    tenNV=resultSet.getString("tenNhanVien");
                }
           }
            
           resultSet.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DonNhapHangDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tenNV;
    }
    
   // Load thong tin vao TableView
    public ObservableList<DonNhapHangDto> loadData()
    {
        try {
            String sql="SELECT * FROM donhang,hangnhap,hang,loaihang,nhanvien,nhacungcap "
                    + "WHERE donhang.maDonHang=hangnhap.maDonHang "
                    + "AND hang.maHang=hangNhap.maHang "
                    + "AND loaihang.maLoaiHang=hang.maLoaiHang "
                    + "AND nhanvien.maNV=donhang.maNV "
                    + "AND nhacungcap.maNCC=donhang.maNCC";
            resultSet=db.loadData(sql);
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
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DonNhapHangDal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DonNhapHangDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }
    
    // Luu data to tableView
    public ObservableList<DonNhapHangDto> loadDataTbView(HangDto hangDto, HangNhapDto hangNhapDto, DonHangDto donHangDto, NccDto nccDto, NhanVienDto nhanVienDto, LoaiHangDto loaiHangDto)
    {
        SimpleDateFormat oldFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat newFormat = new SimpleDateFormat("dd-MM-yyyy");
        
        String maHoaDon=donHangDto.getMaDonHang();
        String tenHang=hangDto.getTenHang();
        String loaiHang=loaiHangDto.getTenLoaiHang();
        double soLuong=hangNhapDto.getSoLuong();
        String donViTinh=hangDto.getDonViTinh();
        double giaNhap=hangDto.getGiaNhap();
        double thanhTien=soLuong*giaNhap;
        String maNcc=nccDto.getMaNcc();
        String maNv=nhanVienDto.getTenNhanVien();
        String maHang=hangDto.getMaHang();
        dataTableView.add(new DonNhapHangDto(maHoaDon, tenHang, loaiHang, soLuong, donViTinh, giaNhap, thanhTien,maNcc,maNv,maHang));

        return dataTableView;
    }
    
    
    // Luu thong tin vao Bang DonHang, NhapHang va edit bang khosanpham
    public int saveData(DonHangDto donHangDto,HangNhapDto hangNhapDto)
    {
        String sqlDonHang="INSERT INTO donHang VALUES('"+donHangDto.getMaDonHang()+"','"+donHangDto.getNgayNhapHang()+"','"+donHangDto.getMaNv()+"','"+donHangDto.getMaNcc()+"')";
        String sqlHangNhap="INSERT INTO hangnhap VALUES('"+hangNhapDto.getMaDonHang()+"','"+hangNhapDto.getMaHang()+"','"+hangNhapDto.getSoLuong()+"')";
        String sqlCapNhapKho="UPDATE khosanpham SET soLuong=("+hangNhapDto.getSoLuong()+"+soLuong) WHERE maHang='"+hangNhapDto.getMaHang()+"'";
        
        int resultDonHang=db.executeData(sqlDonHang);
        int resultHangNhap=db.executeData(sqlHangNhap);
        int resultCapNhatKho=db.executeData(sqlCapNhapKho);
        
       if(resultHangNhap>0 && resultDonHang>0 && resultCapNhatKho>0 )
        
          return 1;
        
        return 0;
            
    }
    
    
}

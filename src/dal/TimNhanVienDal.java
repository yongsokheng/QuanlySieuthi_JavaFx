/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dto.DonHangDto;
import dto.DonNhapHangDto;
import dto.NhanVienDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author asus
 */
public class TimNhanVienDal {

    DatabaseManager db = new DatabaseManager();
    ResultSet resultSet;

    private ObservableList<NhanVienDto> data = FXCollections.observableArrayList();

    //Tim theo maNhanVien
    public ResultSet timTheoMaNhanVien(NhanVienDto nhanVienDto) {
        String sql = "SELECT * FROM NhanVien WHERE maNV =" + nhanVienDto.getMaNhanVien() + " ";
        resultSet = db.loadData(sql);
        return resultSet;
    }

    public ResultSet timTheoTenNhanVien(NhanVienDto nhanVienDto) {
        String sql = "SELECT * FROM NhanVien WHERE tenNhanVien =" + nhanVienDto.getTenNhanVien() + " ";
        resultSet = db.loadData(sql);
        return resultSet;
    }

    public ResultSet hienThiTatCa() {
        String sql = "SELECT * FROM NhanVien  ";
        resultSet = db.loadData(sql);
        return resultSet;
    }

    // Ket qua hien thi vao trong tabble
    public ObservableList<NhanVienDto> loadData(ResultSet resultSet) {
        try {

            while (resultSet.next()) {
                String maNhanVien = resultSet.getString("maNV");
              
                String tenNhanVien = resultSet.getString("tenNV");
   
                String soDth = resultSet.getString("soDth");
          
                String moTa = resultSet.getString("moTa");
          

                data.add(new NhanVienDto(maNhanVien, tenNhanVien, soDth, moTa));

            }

            resultSet.close();

        } catch (SQLException ex) {
            Logger.getLogger(DonNhapHangDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

}

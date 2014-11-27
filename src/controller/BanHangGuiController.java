/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.BanHangDal;
import dto.BanHangDto;
import dto.NhanVienDto;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class BanHangGuiController implements Initializable{
  
    @FXML
    TableView<BanHangDto> tblBanHang;
    @FXML
    TableColumn<BanHangDto, String> colMa;
    @FXML
    TableColumn<BanHangDto, String> colSoLuong;
    @FXML
    TableColumn<BanHangDto, String> colDonGia;
    @FXML
    TableColumn<BanHangDto, String> colDonViTinh;
     @FXML
    TableColumn<BanHangDto, String> colSTT;
      @FXML
    TableColumn<BanHangDto, String> colTenSanPham;
       @FXML
    TableColumn<BanHangDto, String> colThanhTien;
    @FXML
    TextField maSanPham;
    @FXML
    TextField tenSanPham;
    @FXML
    TextField donViTinh;
    @FXML
    TextField soLuong;
    @FXML
    TextField donGia;
    @FXML
    TextField maHoaDon;
    
    BanHangDal banHangDal=new dal.BanHangDal();
    BanHangDto banHangDto=new BanHangDto();
    
     @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
   
    public void setData(BanHangDto banHangDto)
    {
        if(banHangDto.getTenSanPham().equals("")){
            JOptionPane.showMessageDialog(null, "Hàng không tìm thấy!");
        }
        else{
            maSanPham.setText(banHangDto.getMaSanPham());
            tenSanPham.setText(banHangDto.getTenSanPham());
            soLuong.setText("1");
            donViTinh.setText(banHangDto.getDonViTinh());
            donGia.setText(""+banHangDto.getThanhTien()+"");
        }
        
        
         }
            
    @FXML
    private void handleThemHang(ActionEvent event) {
        banHangDto=  new BanHangDto(maSanPham.getText(), tenSanPham.getText().trim(),Double.valueOf( soLuong.getText()),Double.valueOf( donGia.getText()),donViTinh.getText()); 
        banHangDal.themHangVaoHangBan(banHangDto);
        
        
    }
    
    @FXML
    private void handleGetData(ActionEvent event){
        banHangDto.setMaSanPham(maSanPham.getText());  
        banHangDal.Data1(banHangDal.setData(banHangDto), banHangDto);
        setData(banHangDto);
        
    }

   
    
}

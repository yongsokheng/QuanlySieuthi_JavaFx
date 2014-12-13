/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dal.dalHoiVien;
import dto.dtoHoiVien;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Luckydays
 */



public class TimKiemHoiVienController implements Initializable {

    
    
    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    TextField txtmaHoiVien ;
    
    @FXML
    TextField txthoTenHoiVien ;
    
    @FXML
    TableView<dtoHoiVien>  tableHoiVien;
    
    @FXML
    TableColumn<dtoHoiVien , String> maHoiVien;
    
    @FXML
    TableColumn<dtoHoiVien , String> hoTenHoiVien;
    
    @FXML
    TableColumn<dtoHoiVien , String> gioiTinh;
    
    @FXML
    TableColumn<dtoHoiVien , String> dienThoai;
    
    @FXML
    TableColumn<dtoHoiVien , String> tenCoQuan;
    
    @FXML
    TableColumn<dtoHoiVien , String> diaChi;
    
    
    dalHoiVien dalhoivien = new dalHoiVien();
    dtoHoiVien dtohoivien = new dtoHoiVien();
   // FormValidation frm=new FormValidation();
     ResultSet resultSet;
     FormValidation frm=new FormValidation();
    
     
     
     public void loadData(ResultSet resultSet)
    {
         maHoiVien.setCellValueFactory(new PropertyValueFactory("maHoiVien"));
         hoTenHoiVien.setCellValueFactory(new PropertyValueFactory("hoTenHoiVien"));
         gioiTinh.setCellValueFactory(new PropertyValueFactory("gioiTinh"));
         dienThoai.setCellValueFactory(new PropertyValueFactory("dienThoai"));
         tenCoQuan.setCellValueFactory(new PropertyValueFactory("tenCoQuan"));
         diaChi.setCellValueFactory(new PropertyValueFactory("diaChi"));
         tableHoiVien.getItems().clear();
         tableHoiVien.setItems(dalhoivien.loadData(resultSet));
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       resultSet=dalhoivien.getHV();
       loadData(resultSet);
    }    
    
    
    @FXML
    public void handleButtonHienThiMaHoiVien(ActionEvent event){
        
        boolean isTenEmpty=frm.textIsEmtpy(txtmaHoiVien, "Nhập mã hội viên");
        if(!isTenEmpty)
       {
           dtohoivien.setMaHoiVien(txtmaHoiVien.getText());
           resultSet=dalhoivien.timHVtheoMa(dtohoivien);
          loadData(resultSet);
           
       }
        
        
    }
     @FXML
     public void handleButtonHienThiHoTenHoiVien(ActionEvent event){
        
        boolean isTenEmpty=frm.textIsEmtpy(txthoTenHoiVien, "Nhập tên hội viên");
       if(!isTenEmpty)
       {
           dtohoivien.setHoTenHoiVien(txthoTenHoiVien.getText());
           resultSet=dalhoivien.timHVtheoTen(dtohoivien);
           loadData(resultSet);
       }
        
        
    }
      @FXML
      public void handleButtonHienTatCaHoiVien(ActionEvent event){
        
            resultSet=dalhoivien.getHV();
            loadData(resultSet);
        
        
    }
    
      
       @FXML
      public void handleButtonExit(ActionEvent event){
        
           Platform.exit();
        
        
    }
}

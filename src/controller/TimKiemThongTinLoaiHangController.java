/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import com.sun.glass.ui.Window;
import dal.dalTTLoaiHang;
import dto.dtoTTLoaiHang;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author Luckydays
 */
public class TimKiemThongTinLoaiHangController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
 
    @FXML
    TableView<dtoTTLoaiHang>  tableTTLoaiHang;
    
    @FXML
    TableColumn<dtoTTLoaiHang , String> maLoaiHang;
    
    @FXML
    TableColumn<dtoTTLoaiHang , String> tenLoaiHang;
    
    @FXML 
    TextField txtMaLoaiHang;
    
    @FXML 
    TextField txtTenLoaiHang;
    
    
    ResultSet resultSet;
    FormValidation frm=new FormValidation();
    
    dalTTLoaiHang dalttloaihang = new dalTTLoaiHang();
    dtoTTLoaiHang dtottloaihang = new dtoTTLoaiHang();
    
    
    public void loadData(ResultSet resultSet)
    {
         maLoaiHang.setCellValueFactory(new PropertyValueFactory("maLoaiHang"));
         tenLoaiHang.setCellValueFactory(new PropertyValueFactory("tenLoaiHang"));
         
         tableTTLoaiHang.getItems().clear();
         tableTTLoaiHang.setItems(dalttloaihang.loadData(resultSet));
    }
    
   @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       resultSet=dalttloaihang.getLoaiHang();
       loadData(resultSet);
    }    
    
    @FXML
    public void handleButtonHienThiMaLoaiHang(ActionEvent event){
        
        boolean isTenEmpty=frm.textIsEmtpy(txtMaLoaiHang, "Nhập mã loại hàng");
        if(!isTenEmpty)
       {
           dtottloaihang.setMaLoaiHang(txtMaLoaiHang.getText());
           resultSet=dalttloaihang.timLoaiHangtheoMa(dtottloaihang);
          loadData(resultSet);
           
       }
        
        
    }
    
    @FXML
    public void handleButtonHienThiTenLoaiHang(ActionEvent event){
        
        boolean isTenEmpty=frm.textIsEmtpy( txtTenLoaiHang, "Nhập tên loại hàng");
        if(!isTenEmpty)
       {
           dtottloaihang.setTenLoaiHang(txtTenLoaiHang.getText());
           resultSet=dalttloaihang.timLoaiHangtheoTen(dtottloaihang);
          loadData(resultSet);
           
       }
        
        
    }
    
    @FXML
      public void handleButtonHienTatCaLoaiHang(ActionEvent event){
        
            resultSet=dalttloaihang.getLoaiHang();
            loadData(resultSet);
        
        
    }
      
       @FXML
      public void handleButtonExit(ActionEvent event){
        
           Platform.exit();
        
        
    }
    
}

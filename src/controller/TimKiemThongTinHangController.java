/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dal.dalTTHang;
import dto.dtoTTHang;
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
public class TimKiemThongTinHangController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    TableView<dtoTTHang>  tableTTHang;
    
    @FXML
    TableColumn<dtoTTHang , String> maHang;
    
    @FXML
    TableColumn<dtoTTHang , String> tenHang;
    
    @FXML
    TableColumn<dtoTTHang , String> maLoaiHang;
    
    @FXML
    TableColumn<dtoTTHang , String> maNCC;
    
    @FXML
    TableColumn<dtoTTHang , String> donviTinh;
    
    @FXML
    TableColumn<dtoTTHang , String> giaNhap;
    
    @FXML
    TableColumn<dtoTTHang , String> giaBan;
    
    @FXML
    TableColumn<dtoTTHang , String> ghiChu;
    
    @FXML
    TableColumn<dtoTTHang , String> ngayHSD;
    
    @FXML
    TextField txtMaHang;
    
    @FXML
    TextField txtTenHang;
    
    dalTTHang daltthang = new dalTTHang();
    dtoTTHang dtotthang = new dtoTTHang();
   // FormValidation frm=new FormValidation();
     ResultSet resultSet;
     FormValidation frm=new FormValidation();
    
    public void loadData(ResultSet resultSet)
    {
         maHang.setCellValueFactory(new PropertyValueFactory("maHang"));
          tenHang.setCellValueFactory(new PropertyValueFactory("tenHang"));
         maLoaiHang.setCellValueFactory(new PropertyValueFactory("maLoaiHang"));
         maNCC.setCellValueFactory(new PropertyValueFactory("maNhaCungCap"));
         donviTinh.setCellValueFactory(new PropertyValueFactory("donviTinh"));
         giaNhap.setCellValueFactory(new PropertyValueFactory("giaNhap"));
          giaBan.setCellValueFactory(new PropertyValueFactory("giaBan"));
          ghiChu.setCellValueFactory(new PropertyValueFactory("ghiChu"));
         ngayHSD.setCellValueFactory(new PropertyValueFactory("ngayHSD"));
         tableTTHang.getItems().clear();
         tableTTHang.setItems(daltthang.loadData(resultSet));
    }
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       resultSet=daltthang.getHang();
       loadData(resultSet);
    }    
    
    
    @FXML
    public void handleButtonHienThiMaHang(ActionEvent event){
        System.out.print("Hello ma hang");
        boolean isTenEmpty=frm.textIsEmtpy(txtMaHang, "Nhập mã Hàng");
        if(!isTenEmpty)
       {
           dtotthang .setMaHang(txtMaHang.getText());
           resultSet=daltthang.timHangTheoMa(dtotthang );
          loadData(resultSet);
           
       }
        
        
    }
    
    
    @FXML
    public void handleButtonHienThiTenHang(ActionEvent event){
        
        
        System.out.print("Hello ten hang");
        boolean isTenEmpty=frm.textIsEmtpy(txtTenHang, "Nhập Tên Hàng");
        if(!isTenEmpty)
       {
           dtotthang.setTenHang(txtTenHang.getText());
           resultSet=daltthang.timHangTheoTen(dtotthang );
          loadData(resultSet);
           
       }
        
        
    }
    
    
      @FXML
      public void handleButtonHienTatHang(ActionEvent event){
        
          System.out.print("Hello hang");
            resultSet=daltthang.getHang();
            loadData(resultSet);
        
        
    }
    
      
       @FXML
      public void handleButtonExit(ActionEvent event){
        
           Platform.exit();
        
        
    }
}

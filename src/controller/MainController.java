/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.LoginDal;
import dto.LoginDto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author YONGSOKHENG
 */
public class MainController implements Initializable {

    @FXML
    AnchorPane ParentControl;
    @FXML
    Menu edit;
    @FXML
    MenuBar menuBar;
    
    @FXML 
    Menu timKiem;
    @FXML
    MenuItem login;   
    @FXML
    Label labelLogin;
    
    LoginDto loginDto=new LoginDto();
    LoginDal loginDal=new LoginDal();
    ScenceController scence=new ScenceController();
    ReportClass report=new ReportClass();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }
  
   
     @FXML
    private void handleMenuNhaCungCap(ActionEvent event) 
    {
        scence.openNewWindow("/gui/NccGui.fxml", ParentControl); 
    }
    @FXML
    private void handleMenuItemNhanVien(ActionEvent event){
        
        scence.openNewWindow("/gui/NhanVienGui.fxml", ParentControl);
    }
    @FXML
    private void handleMenuItemHoiVien(ActionEvent event){
        
        scence.openNewWindow("/gui/QuanLyHoiVien.fxml", ParentControl);
    }
    @FXML
    private void handleMenuItemTimNCC(ActionEvent event){
       
        scence.openNewWindow("/gui/TimNcc.fxml", ParentControl);
    }
    @FXML
    private void handleMenuItemTimNhanVien(ActionEvent event){
      
        scence.openNewWindow("/gui/TimNhanVienGui.fxml", ParentControl);
    }
    @FXML
    private void handleMenuItemTimDonNhapHang(ActionEvent event){
      
        scence.openNewWindow("/gui/TimDonNhapHangGui.fxml", ParentControl);
    }
    @FXML
    private void handleMenuItemTimHang(ActionEvent event){
     
        scence.openNewWindow("/gui/KiemTraHangGui.fxml", ParentControl);
    }
    @FXML
    private void handleMenuLogin(ActionEvent event){
        scence.openNewWindow("/gui/LoginGui.fxml", ParentControl);
    }
    @FXML
    private void handleMenuClose(ActionEvent event){
        scence.closeScence((Stage)ParentControl.getScene().getWindow());
    }
    
     @FXML
    private void handleMenuItemHang(ActionEvent event){
        scence.openNewWindow("/gui/QuanLyThongTinHang.fxml", ParentControl);
    }
    
     @FXML
    private void handleMenuItemLoaiHang(ActionEvent event){
        scence.openNewWindow("/gui/QuanLyThongTinLoaiHang.fxml", ParentControl);
    }
    
      @FXML
    private void handleMenuItemDonNhapHang(ActionEvent event){
        scence.openNewWindow("/gui/DonNhapHangGui.fxml", ParentControl);
    }
    
     @FXML
    private void handleMenuItemTimHoiVien(ActionEvent event){
        scence.openNewWindow("/gui/TimKiemHoiVien.fxml", ParentControl);
    }
     @FXML
    private void handleMenuItemTimLoaiHang(ActionEvent event){
        scence.openNewWindow("/gui/TimKiemThongTinLoaiHang.fxml", ParentControl);
    }
    
     @FXML
    private void handleMenuItemRpNcc(ActionEvent event){
        report.print("NhaCCReport.jrxml", null);
    }
    
     @FXML
    private void handleMenuItemRpDonHang(ActionEvent event){
        scence.openNewWindow("/gui/ReportDonNhapHang.fxml", ParentControl);
    }
    
    @FXML
    private void handleMenuItemRpHoiVien(ActionEvent event){
       report.print("HoiVienReport.jrxml", null);
    }
    
    @FXML
    private void handleMenuItemRpHang(ActionEvent event){
       report.print("HangReport.jrxml", null);
    }
    
}

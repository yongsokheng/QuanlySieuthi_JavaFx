package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dal.dalHoiVien;
import dto.dtoHoiVien;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Luckydays
 */
public class QuanLyHoiVien implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    TableView<dtoHoiVien>  quanLyHoiVien;
    
    @FXML
    TableColumn<dtoHoiVien , String> maHoiVien;
    
    @FXML
    TableColumn<dtoHoiVien , String> hoTenHoiVien;
    
    @FXML
    TableColumn<dtoHoiVien , String> gioiTinhHoiVien;
    
    @FXML
    TableColumn<dtoHoiVien , String> dienThoai;
    
    @FXML
    TableColumn<dtoHoiVien , String> diaChi ;
    
    @FXML
    TableColumn<dtoHoiVien , String> tenCoQuan;
    
    
    
    @FXML
    TextField txtMaHoiVien;
    
    @FXML
    TextField txtHoTenHoiVien;
    
    @FXML 
    ComboBox cbGioiTinh;
 //   ObservableList<String> options = FXCollections.observableArrayList();
    
    
    @FXML
    TextField txtDienThoai;
    
    @FXML
    TextField txtDiaChi;
    
    @FXML
    TextField txtTenCoQuan;
    
  
    
   dalHoiVien dalHV=new dalHoiVien();
   dtoHoiVien dtoHv=new dtoHoiVien();
    
    public int validate()
    {
       if(txtHoTenHoiVien.getText().equals("") || txtMaHoiVien.getText().equals("") || cbGioiTinh.equals("") || txtDienThoai.equals("") || txtDiaChi.equals("") || txtTenCoQuan.equals("")) 
            return 0;
       return 1;
       
    }
    
    @FXML
    private void handleButtonThemMoi(ActionEvent event) {
    
        txtMaHoiVien.setText("");
        txtHoTenHoiVien.setText("");
        txtDienThoai.setText("");
        txtDiaChi.setText("");
        txtTenCoQuan.setText("");
       

        
        cbGioiTinh.getSelectionModel().select("");
    }
    
    
    public void loadData()
    {
        maHoiVien.setCellValueFactory(new PropertyValueFactory("maHoiVien"));
        hoTenHoiVien.setCellValueFactory(new PropertyValueFactory("hoTenHoiVien"));
        gioiTinhHoiVien.setCellValueFactory(new PropertyValueFactory("gioiTinh"));
        dienThoai.setCellValueFactory(new PropertyValueFactory("dienThoai"));
        tenCoQuan.setCellValueFactory(new PropertyValueFactory("tenCoQuan"));
        diaChi.setCellValueFactory(new PropertyValueFactory("diaChi"));
         
         quanLyHoiVien.getItems().clear();
         quanLyHoiVien.setItems(dalHV.loadData());
    }
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
      
        
             loadData();
             
            // Handle ListView selection changes.
        
             quanLyHoiVien.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if( quanLyHoiVien.getSelectionModel().getSelectedIndex()>=0)
                {
                    txtMaHoiVien.setText(newValue.getMaHoiVien());
                    txtHoTenHoiVien.setText(newValue.getHoTenHoiVien());
                    cbGioiTinh.getSelectionModel().select(newValue.getGioiTinh());
                    txtDienThoai.setText(newValue.getDienThoai());
                    txtDiaChi.setText(newValue.getDiaChi());
                    txtTenCoQuan.setText(newValue.getTenCoQuan());
                }
            
         });
             
       ObservableList<String> options = FXCollections.observableArrayList();
       options.add("Nam");
       options.add("Nu");
       cbGioiTinh.setItems(options);
      
    } 
    
     @FXML
     private void handleButtonLuu(ActionEvent event) {
            if( validate()==1 )
            {
                dtoHv.setMaHoiVien(txtMaHoiVien.getText());
                dtoHv.setHoTenHoiVien(txtHoTenHoiVien.getText());
                dtoHv.setGioiTinh(cbGioiTinh.getSelectionModel().getSelectedItem().toString());
                dtoHv.setDiaChi(txtDiaChi.getText());
                dtoHv.setDienThoai(txtDienThoai.getText());
                dtoHv.setTenCoQuan(txtTenCoQuan.getText());

                if( dalHV.saveData(dtoHv) > 0 )
                {
                  //  loadData();
                    JOptionPane.showMessageDialog(null, "Lưu thành công");
                    loadData();
                }
            }
            else
               JOptionPane.showMessageDialog(null, "MaNCC hoặc TenNCC không thể trống"); 
    }
     
     
     
     @FXML
    private void handleButtonXoa(ActionEvent event) 
    {
      int i=quanLyHoiVien.getSelectionModel().getSelectedIndex();
      
      if(i>=0)
      {
         dtoHv.setMaHoiVien(quanLyHoiVien.getSelectionModel().getSelectedItem().getMaHoiVien());
         if(dalHV.deleteData(dtoHv) > 0)
        {
            loadData();
            
            JOptionPane.showMessageDialog(null, "Xóa thành công");
        }
          
      }
      else
          JOptionPane.showMessageDialog(null, "Hãy chọn một sản phẩm để xóa.");
         
    }
     
     
   
    @FXML
    private void handleButtonUpdate(ActionEvent event) 
    {
      int i=quanLyHoiVien.getSelectionModel().getSelectedIndex();
      
      if(i>=0)
      {
            
               dtoHv.setMaHoiVien(txtMaHoiVien.getText());
               dtoHv.setHoTenHoiVien(txtHoTenHoiVien.getText());
               dtoHv.setGioiTinh(cbGioiTinh.getSelectionModel().getSelectedItem().toString());
               dtoHv.setDienThoai(txtDienThoai.getText());
                dtoHv.setTenCoQuan(txtTenCoQuan.getText());
                dtoHv.setDiaChi(txtDiaChi.getText());
               String ma=quanLyHoiVien.getSelectionModel().getSelectedItem().getMaHoiVien();

               if(dalHV.updateData(dtoHv, ma) >0)
              {
                  loadData();
                 
                  JOptionPane.showMessageDialog(null, "Cấp nhật thành công");
              }

            
            
      }
      else
            JOptionPane.showMessageDialog(null, "Hãy chọn một sản phẩm để xóa.");
  
    }
    
    
    
    
    
    
}

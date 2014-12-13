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
    FormValidation frm=new FormValidation();
    
   public void loadData()
    {
         maHoiVien.setCellValueFactory(new PropertyValueFactory("maHoiVien"));
         hoTenHoiVien.setCellValueFactory(new PropertyValueFactory("hoTenHoiVien"));
         gioiTinhHoiVien.setCellValueFactory(new PropertyValueFactory("gioiTinh"));
         dienThoai.setCellValueFactory(new PropertyValueFactory("dienThoai"));
         tenCoQuan.setCellValueFactory(new PropertyValueFactory("tenCoQuan"));
         diaChi.setCellValueFactory(new PropertyValueFactory("diaChi"));
         
         quanLyHoiVien.getItems().clear();
         quanLyHoiVien.setItems(dalHV.loadData(dalHV.getHV()));
    }
    public void themmoi()
    {
        txtMaHoiVien.setText("");
        txtHoTenHoiVien.setText("");
        txtDienThoai.setText("");
        txtDiaChi.setText("");
        txtTenCoQuan.setText(""); 
        cbGioiTinh.getSelectionModel().select("");
    }
    
    public boolean validate()
    {
        boolean maHVEmpty=frm.textIsEmtpy(txtMaHoiVien, "Vui lòng nhập Mã Hội Viên");
        boolean hoTenHVEmpty=frm.textIsEmtpy(txtHoTenHoiVien, "Vui lòng nhập Họ tên Hội viên");
        boolean soDtEmpty=frm.textIsEmtpy(txtDienThoai, "Vui lòng nhập số điện thoại");
        boolean soDtCorrect=frm.textIsPhoneNumber(txtDienThoai, "Số điện thoại không đúng.");
        boolean diaChiEmpyt=frm.textIsEmtpy(txtDiaChi, "Vui lòng nhập địa chỉ");
        boolean tenCoQuanEmpty=frm.textIsEmtpy(txtTenCoQuan, "Vui lòng nhập tên cơ quan");
        
        if(!maHVEmpty && !hoTenHVEmpty && !soDtEmpty && soDtCorrect && !diaChiEmpyt && !tenCoQuanEmpty)
          return true;
        return false;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
             loadData();
             
            // Handle ListView selection changes.
        
            quanLyHoiVien.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if(quanLyHoiVien.getSelectionModel().getSelectedIndex()>=0)
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
    private void handleButtonLuu(ActionEvent event) 
    {
        
            if(validate())
            {
                dtoHv.setMaHoiVien(txtMaHoiVien.getText());
                dtoHv.setHoTenHoiVien(txtHoTenHoiVien.getText());
                dtoHv.setGioiTinh(cbGioiTinh.getSelectionModel().getSelectedItem().toString());
                dtoHv.setDienThoai(txtDienThoai.getText());
                dtoHv.setDiaChi(txtDiaChi.getText());
                dtoHv.setTenCoQuan(txtTenCoQuan.getText());

                if(dalHV.saveData(dtoHv)>0)
                {
                    loadData();
                    themmoi();
                    JOptionPane.showMessageDialog(null, "Lưu thành công");
                }
            }
         
    }
    
    @FXML
    private void handleButtonXoa(ActionEvent event) 
    {
      int i=quanLyHoiVien.getSelectionModel().getSelectedIndex();
      
      if(i>=0)
      {
         dtoHv.setMaHoiVien(quanLyHoiVien.getSelectionModel().getSelectedItem().getMaHoiVien());
         if(dalHV.deleteData(dtoHv)>0)
        {
            loadData();
            themmoi();
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
            if(validate())
            {
                dtoHv.setMaHoiVien(txtMaHoiVien.getText());
                dtoHv.setHoTenHoiVien(txtHoTenHoiVien.getText());
                dtoHv.setGioiTinh(cbGioiTinh.getSelectionModel().getSelectedItem().toString());
                dtoHv.setDienThoai(txtDienThoai.getText());
                dtoHv.setTenCoQuan(txtTenCoQuan.getText());
                dtoHv.setDiaChi(txtDiaChi.getText());
               String ma=quanLyHoiVien.getSelectionModel().getSelectedItem().getMaHoiVien();

               if(dalHV.updateData(dtoHv,ma)>0)
              {
                  loadData();
                  themmoi();
                  JOptionPane.showMessageDialog(null, "Update thành công");
              }

            }
            
      }
      else
            JOptionPane.showMessageDialog(null, "Hãy chọn một sản phẩm để xóa.");
  
    }
    @FXML
    private void handleButtonThemMoi(ActionEvent event) 
    {
        themmoi();
    }
}

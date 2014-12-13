/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dal.dalTTLoaiHang;
import dto.dtoTTLoaiHang;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
public class QuanLyThongTinLoaiHang implements Initializable {

    /**
     * Initializes the controller class.
     */
    
     @FXML
    TableView<dtoTTLoaiHang>  tbTTLoaiHang;
    
    @FXML
    TableColumn<dtoTTLoaiHang , String> maLoaiHang;
    
    @FXML
    TableColumn<dtoTTLoaiHang , String> tenLoaiHang;
    
    
    @FXML
    TextField txtMaLoaiHang;

    @FXML
    TextField txtTenLoaiHang;
    
    
    dalTTLoaiHang daltthang=new dalTTLoaiHang();
    dtoTTLoaiHang dtotthang=new dtoTTLoaiHang();
    FormValidation frm=new FormValidation();
    
    public void themmoi()
    {
        txtMaLoaiHang.setText("");
         txtTenLoaiHang.setText("");
        
    }
    
    
    public void loadData()
    {
         maLoaiHang.setCellValueFactory(new PropertyValueFactory("maLoaiHang"));
         tenLoaiHang.setCellValueFactory(new PropertyValueFactory("tenLoaiHang"));
         
         tbTTLoaiHang.getItems().clear();
         tbTTLoaiHang.setItems(daltthang.loadData(daltthang.getLoaiHang()));
        
    }
    
     public boolean validate()
    {
        boolean maLoaiHangEmpty=frm.textIsEmtpy(txtMaLoaiHang, "Vui lòng nhập Mã Loại Hàng");
        boolean tenLoaiHangEmpty=frm.textIsEmtpy(txtTenLoaiHang, "Vui lòng nhập tên Loại hàng");
        
        
       
        if(!maLoaiHangEmpty && !tenLoaiHangEmpty )
          return true;
        return false;
  //      return true;
        
    }
    
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
       
       
             loadData();
             
            // Handle ListView selection changes.
        
            tbTTLoaiHang.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if(tbTTLoaiHang.getSelectionModel().getSelectedIndex()>=0)
                {
                    txtMaLoaiHang.setText(newValue.getMaLoaiHang());
                    txtTenLoaiHang.setText(newValue.getTenLoaiHang());
                    
                }
            
         });
       
      
    }
    @FXML
    private void handleButtonLuu(ActionEvent event) 
    {
        
            if(validate())
            {
                dtotthang.setMaLoaiHang(txtMaLoaiHang.getText());
                dtotthang.setTenLoaiHang(txtTenLoaiHang.getText());
                

                if(daltthang.saveData(dtotthang)>0)
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
      int i=tbTTLoaiHang.getSelectionModel().getSelectedIndex();
      
      if(i>=0)
      {
         dtotthang.setMaLoaiHang(tbTTLoaiHang.getSelectionModel().getSelectedItem().getMaLoaiHang());
         if(daltthang.deleteData(dtotthang)>0)
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
      int i=tbTTLoaiHang.getSelectionModel().getSelectedIndex();
      
      if(i>=0)
      {
            if(validate())
            {
                dtotthang.setMaLoaiHang(txtMaLoaiHang.getText());
                dtotthang.setTenLoaiHang(txtTenLoaiHang.getText());
                
               String ma=tbTTLoaiHang.getSelectionModel().getSelectedItem().getMaLoaiHang();

               if(daltthang.updateData(dtotthang,ma)>0)
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

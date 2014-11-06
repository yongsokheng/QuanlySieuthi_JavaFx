/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.NccDal;
import dto.NccDto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
 * @author YONGSOKHENG
 */
public class NccGuiController implements Initializable {

    @FXML
    TableView<NccDto> tblNcc;
    @FXML 
    TableColumn<NccDto,String> maNcc;
    @FXML 
    TableColumn<NccDto,String> tenNcc;
    @FXML 
    TableColumn<NccDto,String> soDt;
    @FXML 
    TableColumn<NccDto,String> diaChi;
    @FXML
    TextField txtMaNcc;
    @FXML
    TextField txtTenNcc;
    @FXML
    TextField txtSoDt;
    @FXML
    TextField txtDiaChi;
    
    NccDal nccDal=new NccDal();
    NccDto nccDto=new NccDto();
    FormValidation frm=new FormValidation();
    
    public void loadData()
    {
         maNcc.setCellValueFactory(new PropertyValueFactory("maNcc"));
         tenNcc.setCellValueFactory(new PropertyValueFactory("tenNcc"));
         soDt.setCellValueFactory(new PropertyValueFactory("soDt"));
         diaChi.setCellValueFactory(new PropertyValueFactory("diaChi"));
         tblNcc.getItems().clear();
         tblNcc.setItems(nccDal.loadData());
    }
    
    public void themmoi()
    {
        txtMaNcc.setText("");
        txtTenNcc.setText("");
        txtSoDt.setText("");
        txtDiaChi.setText("");
    }
    
    public boolean validate()
    {
        boolean maNccEmpty=frm.textIsEmtpy(txtMaNcc, "Vui lòng nhập Mã nhà cung cấp");
        boolean tenNccEmpty=frm.textIsEmtpy(txtTenNcc, "Vui lòng nhập tên nhà cung cấp");
        boolean soDtEmpty=frm.textIsEmtpy(txtSoDt, "Vui lòng nhập số điện thoại");
        boolean soDtCorrect=frm.textIsPhoneNumber(txtSoDt, "Số điện thoại không đúng.");
        if(!maNccEmpty && !tenNccEmpty && !soDtEmpty && soDtCorrect)
          return true;
        return false;
    }
  
    
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
             loadData();
             
            // Handle ListView selection changes.
        
            tblNcc.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if(tblNcc.getSelectionModel().getSelectedIndex()>=0)
                {
                    txtMaNcc.setText(newValue.getMaNcc());
                    txtTenNcc.setText(newValue.getTenNcc());
                    txtSoDt.setText(newValue.getSoDt());
                    txtDiaChi.setText(newValue.getDiaChi());
                }
            
         });
      
    } 
    
    @FXML
    private void handleButtonLuu(ActionEvent event) 
    {
        
            if(validate())
            {
                nccDto.setMaNcc(txtMaNcc.getText());
                nccDto.setTenNcc(txtTenNcc.getText());
                nccDto.setSoDt(txtSoDt.getText());
                nccDto.setDiaChi(txtDiaChi.getText());

                if(nccDal.saveData(nccDto)>0)
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
      int i=tblNcc.getSelectionModel().getSelectedIndex();
      
      if(i>=0)
      {
         nccDto.setMaNcc(tblNcc.getSelectionModel().getSelectedItem().getMaNcc());
         if(nccDal.deleteData(nccDto)>0)
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
    private void handleButtonCapNhat(ActionEvent event) 
    {
      int i=tblNcc.getSelectionModel().getSelectedIndex();
      
      if(i>=0)
      {
            if(validate())
            {
               nccDto.setMaNcc(txtMaNcc.getText());
               nccDto.setTenNcc(txtTenNcc.getText());
               nccDto.setSoDt(txtSoDt.getText());
               nccDto.setDiaChi(txtDiaChi.getText());
               String ma=tblNcc.getSelectionModel().getSelectedItem().getMaNcc();

               if(nccDal.updateData(nccDto,ma)>0)
              {
                  loadData();
                  themmoi();
                  JOptionPane.showMessageDialog(null, "Cấp nhật thành công");
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

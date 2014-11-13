/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.UserDal;
import dto.LoginDto;
import dto.NccDto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
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
public class UserController implements Initializable {

    @FXML
    TableView<LoginDto> tbUser;
    @FXML 
    TableColumn<LoginDto,String> colUser;
    @FXML 
    TableColumn<LoginDto,String> colRole;
    
    @FXML
    TextField txtUsername;
    @FXML
    TextField txtPassword;
    @FXML
    ComboBox cbRole;
    
    UserDal userDal=new UserDal();
    LoginDto loginDto=new LoginDto();
    FormValidation frm=new FormValidation();
    
    ObservableList<String> data=FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Add Role
        data.add("Admin");
        data.add("Accounting");
        data.add("Seller");
        cbRole.setItems(data);
        
        loadData();
    }
    
    public boolean validate()
    {
        boolean usernameEmpty=frm.textIsEmtpy(txtUsername, "Nhập username");
        boolean pwdEmpty=frm.textIsEmtpy(txtPassword, "Nhập password");
        boolean roleEmplty=frm.comboBoxIsEmtpy(cbRole, "Chọn role");
        
        if(!usernameEmpty && !pwdEmpty && !roleEmplty)
            return true;
        return false;
    }
    
    
     public void loadData()
    {
         colUser.setCellValueFactory(new PropertyValueFactory("username"));
         colRole.setCellValueFactory(new PropertyValueFactory("role"));
         tbUser.getItems().clear();
         tbUser.setItems(userDal.loadData());
    }
     
     public void themMoi()
     {
        txtUsername.setText("");
        txtPassword.setText("");
        cbRole.getSelectionModel().select("");
     }
    
    @FXML
    private void handleButtonLuu(ActionEvent event) 
    {
        if(validate())
        {
          loginDto.setUsername(txtUsername.getText().trim());
          loginDto.setPassword(txtPassword.getText().trim());
          loginDto.setRole(cbRole.getSelectionModel().getSelectedItem().toString());
          int result=userDal.themUser(loginDto);
          if(result>0)
          {
              loadData();
              JOptionPane.showMessageDialog(null, "Luu thanh cong");
              
          }
        else
            JOptionPane.showMessageDialog(null, "Khong luu duoc");
        }
        
    }
    
    @FXML
    private void handleButtonXoa(ActionEvent event) 
    {
        int i=tbUser.getSelectionModel().getSelectedIndex();
      
        if(i>=0)
        {
           loginDto.setUsername(tbUser.getSelectionModel().getSelectedItem().getUsername());
            if(userDal.xoaUser(loginDto)>0)
            {
                loadData();
                JOptionPane.showMessageDialog(null, "Xóa thành công");
            }

        }
        else
            JOptionPane.showMessageDialog(null, "Hãy chọn một username để xóa.");
        
    }
    
    @FXML
    private void handleButtonThemMoi(ActionEvent event) 
    {
        themMoi();
    }
    
    
    
}

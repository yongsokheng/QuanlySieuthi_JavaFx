/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.LoginDal;
import dto.LoginDto;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javax.swing.JOptionPane;



/**
 *
 * @author YONGSOKHENG
 */
public class LoginController implements Initializable {
    

    @FXML
    TextField txtUsername;
    @FXML
    TextField txtPassword;
    @FXML 
    Button btnClose;
  
    
    LoginDal login=new LoginDal();
    LoginDto loginDTO=new LoginDto();
    ScenceController scence=new ScenceController();
    
    @FXML
    private void handleButtonLogin(ActionEvent event) {
  
            loginDTO.setUsername(txtUsername.getText());
            loginDTO.setPassword(txtPassword.getText());
            
            if(login.kiemTraLogin(loginDTO)>0)
            {
                scence.openNewScence("/gui/MainGui.fxml",true);
                scence.closeScence((Stage) btnClose.getScene().getWindow());
                 
            }
            else
            {
                 JOptionPane.showMessageDialog(null, "Username hoặc password chưa đúng."); 
              
            }
            
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    

}

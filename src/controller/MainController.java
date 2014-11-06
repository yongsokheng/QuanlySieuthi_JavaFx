/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author YONGSOKHENG
 */
public class MainController implements Initializable {

    @FXML
    AnchorPane ParentControl;
    
    ScenceController scence=new ScenceController();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    
    
    
     @FXML
    private void handleMenuNhaCungCap(ActionEvent event) 
    {
       // scence.openNewWindow("/gui/NccGui.fxml", ParentControl);
        scence.openNewScence("/gui/NccGui.fxml", false);
    }
    
}

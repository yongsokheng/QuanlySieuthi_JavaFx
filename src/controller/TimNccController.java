/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.NccDal;
import dto.NccDto;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
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
 * @author YONGSOKHENG
 */
public class TimNccController implements Initializable {

    
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
    
    NccDal nccDal=new NccDal();
    NccDto nccDto=new NccDto();
    FormValidation frm=new FormValidation();
    ResultSet resultSet;
    
    public void loadData(ResultSet resultSet)
    {
         maNcc.setCellValueFactory(new PropertyValueFactory("maNcc"));
         tenNcc.setCellValueFactory(new PropertyValueFactory("tenNcc"));
         soDt.setCellValueFactory(new PropertyValueFactory("soDt"));
         diaChi.setCellValueFactory(new PropertyValueFactory("diaChi"));
         tblNcc.getItems().clear();
         tblNcc.setItems(nccDal.loadData(resultSet));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        resultSet=nccDal.getNcc();
        loadData(resultSet);
    }  
    
    @FXML
    private void handleTimTen(ActionEvent event) 
    {
       boolean isTenEmpty=frm.textIsEmtpy(txtTenNcc, "Nhập tên nhà cung cấp");
       if(!isTenEmpty)
       {
           nccDto.setTenNcc(txtTenNcc.getText());
           resultSet=nccDal.timNccTheoTen(nccDto);
           loadData(resultSet);
       }
        
    }
    
    @FXML
    private void handleTimMa(ActionEvent event) 
    {
       boolean isTenEmpty=frm.textIsEmtpy(txtMaNcc, "Nhập mã nhà cung cấp");
       if(!isTenEmpty)
       {
           nccDto.setMaNcc(txtMaNcc.getText());
           resultSet=nccDal.timNccTheoMa(nccDto);
           loadData(resultSet);
           
       }
 
    }
    
    @FXML
    private void handleTimTat(ActionEvent event) 
    {
           resultSet=nccDal.getNcc();
           loadData(resultSet);
      
 
    }
    
}

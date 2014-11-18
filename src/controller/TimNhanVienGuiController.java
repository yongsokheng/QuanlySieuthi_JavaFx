/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.NhanVienDal;
import dal.TimNhanVienDal;
import dto.NhanVienDto;
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
 * @author asus
 */
public class TimNhanVienGuiController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    TableView<NhanVienDto> tblNhanVien;
    @FXML
    TableColumn<NhanVienDto,String> ma;
    @FXML
    TableColumn<NhanVienDto,String> ten;
    @FXML
    TableColumn<NhanVienDto,String> sdth;
    @FXML
    TableColumn<NhanVienDto,String> moTa;
    @FXML
    TextField txtMa;
    @FXML
    TextField txtTen;
    
    FormValidation frm=new FormValidation();
    NhanVienDto nhanVienDto= new NhanVienDto();
    NhanVienDal nhanVienDal=new NhanVienDal();
    TimNhanVienDal timNhanVienDal=new TimNhanVienDal();
    ResultSet resultSet;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        resultSet=nhanVienDal.getNhanVien();
        loadData(resultSet);
               
    }    
    
     public boolean validate()
    {
        boolean maNhanVien=frm.textIsEmtpy(txtMa, "chưa có thông tin"); 
        boolean tenNhanVien=frm.textIsEmtpy(txtTen, "chưa có thông tin");
        if(!maNhanVien || !tenNhanVien ) 
            return true;
        return false;
        
    }
     
    public void loadData(ResultSet resultSet)
    {
         ma.setCellValueFactory(new PropertyValueFactory("maNhanVien"));
         ten.setCellValueFactory(new PropertyValueFactory("tenNhanVien"));
         sdth.setCellValueFactory(new PropertyValueFactory("dienThoai"));
         moTa.setCellValueFactory(new PropertyValueFactory("moTa"));
         tblNhanVien.getItems().clear();
         tblNhanVien.setItems(nhanVienDal.loadData(resultSet));
    }
    
   
    
      
      @FXML
    private void handleTimKiemTheoMaNhanVien(ActionEvent event) 
    {
 
        if(validate())
        {
            if(!txtMa.getText().trim().isEmpty()){
                nhanVienDto.setMaNhanVien(txtMa.getText().trim());

                ResultSet resultSet=timNhanVienDal.timTheoMaNhanVien(nhanVienDto);

                loadData(resultSet);
            }
            else {
               
                nhanVienDto.setTenNhanVien(txtTen.getText().trim());

                ResultSet resultSet=timNhanVienDal.timTheoTenNhanVien(nhanVienDto);

                loadData(resultSet);
            }
        }
    }
    @FXML
    public void handleHienThiTatCa(ActionEvent event){
        resultSet=timNhanVienDal.hienThiTatCa();
        loadData(resultSet);
    }
 
    @FXML
     private void handleTimTat(ActionEvent event) 
    {
           resultSet=nhanVienDal.getNhanVien();
           loadData(resultSet);
    }    
}

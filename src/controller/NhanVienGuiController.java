/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dal.NhanVienDal;
import dto.NhanVienDto;
import java.net.URL;
import java.util.ResourceBundle;
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
 * @author NGENG CHHENGKIM
 */
public class NhanVienGuiController implements Initializable {

    @FXML
    TableView<NhanVienDto> tblNhanVien;
    @FXML
    TableColumn<NhanVienDto, String> maNhanVien;
    @FXML
    TableColumn<NhanVienDto, String> tenNhanVien;
    @FXML
    TableColumn<NhanVienDto, String> soDt;
    @FXML
    TableColumn<NhanVienDto, String> moTa;
    @FXML
    TextField txtMa;
    @FXML
    TextField txtTen;
    @FXML
    TextField txtSoDt;
    @FXML
    TextField txtMota;

    NhanVienDal nvDal = new NhanVienDal();
    NhanVienDto nvDto = new NhanVienDto();
    FormValidation frm = new FormValidation();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }

    public void themmoi() {
        txtMa.setText("");
        txtTen.setText("");
        txtSoDt.setText("");
        txtMota.setText("");
    }

     public void loadData()
    {
         maNhanVien.setCellValueFactory(new PropertyValueFactory("maNhanVien"));
         tenNhanVien.setCellValueFactory(new PropertyValueFactory("tenNhanVien"));
         soDt.setCellValueFactory(new PropertyValueFactory("dienThoai"));
         moTa.setCellValueFactory(new PropertyValueFactory("moTa"));
         tblNhanVien.getItems().clear();
         tblNhanVien.setItems(nvDal.loadData());
    }
    @FXML
    private void handleButtonThemMoi(ActionEvent event) {
        themmoi();
    }
    
     public boolean validate()
    {
        boolean maNccEmpty=frm.textIsEmtpy(txtMa, "Vui lòng nhập Mã nhà cung cấp");
        boolean tenNccEmpty=frm.textIsEmtpy(txtTen, "Vui lòng nhập tên nhà cung cấp");
        boolean soDtEmpty=frm.textIsEmtpy(txtSoDt, "Vui lòng nhập số điện thoại");
        boolean soDtCorrect=frm.textIsPhoneNumber(txtSoDt, "Số điện thoại không đúng.");
        if(!maNccEmpty && !tenNccEmpty && !soDtEmpty && soDtCorrect)
          return true;
        return false;
    }
     @FXML
    private void handleButtonLuu(ActionEvent event) 
    {
        
            if(validate())
            {
                nvDto.setMaNhanVien(txtMa.getText());
                nvDto.setTenNhanVien(txtTen.getText());
                nvDto.setDienThoai(txtSoDt.getText());
                nvDto.setMoTa(txtMota.getText());
                JOptionPane.showMessageDialog(null, "validate thanh cong");
                if(nvDal.saveData(nvDto)>0)
                {
                    JOptionPane.showMessageDialog(null, "than cong saveData");
                    loadData();
                    JOptionPane.showMessageDialog(null,"thanh cong loaddata");
                    themmoi();
                    JOptionPane.showMessageDialog(null, "Lưu thành công");
                }
            }
         
    }
    
}
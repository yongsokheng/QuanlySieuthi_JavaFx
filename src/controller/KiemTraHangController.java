/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.KiemTraHangDal;
import dto.HangDto;
import dto.LoaiHangDto;
import dto.NccDto;
import dto.TimHangDto;
import java.net.URL;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author YONGSOKHENG
 */
public class KiemTraHangController implements Initializable {

    //TableView Data
    @FXML 
    TableView<TimHangDto> tbHang;
    @FXML
    TableColumn<TimHangDto,String> maHang;
    @FXML
    TableColumn<TimHangDto,String> tenHang;
    @FXML
    TableColumn<TimHangDto,String> donViTinh;
    @FXML
    TableColumn<TimHangDto,String> loaiHang;
    @FXML
    TableColumn<TimHangDto,String> ncc;
    @FXML
    TableColumn<TimHangDto,Double> giaNhap;
    @FXML
    TableColumn<TimHangDto,Double> giaBan;
    @FXML
    TableColumn<TimHangDto,String> ngayHSD;
    @FXML
    TableColumn<TimHangDto,Double> soLuong;
    @FXML
    TableColumn<TimHangDto,String> ghiChu;
    
    @FXML
    TextField txtMaHang;
    @FXML
    TextField txtTenHang;
    @FXML
    ComboBox cbTenNcc;
    @FXML
    ComboBox cbLoaiHang;
    @FXML
    DatePicker tuNgay;
    @FXML
    DatePicker denNgay;
    
   
    KiemTraHangDal kiemTraHangDal=new KiemTraHangDal();
    FormValidation frm=new FormValidation();
    HangDto hangDto=new HangDto();
    NccDto nccDto=new NccDto();
    LoaiHangDto loaiHangDto=new LoaiHangDto();
    
    ResultSet resultSet;
   
    public void loadTabble(ResultSet resultSet)
    {
        //Load Data vao TableView
        maHang.setCellValueFactory(new PropertyValueFactory("maHang"));
        tenHang.setCellValueFactory(new PropertyValueFactory("tenHang"));
        donViTinh.setCellValueFactory(new PropertyValueFactory("donViTinh"));
        loaiHang.setCellValueFactory(new PropertyValueFactory("loaiHang"));
        ncc.setCellValueFactory(new PropertyValueFactory("ncc"));
        giaNhap.setCellValueFactory(new PropertyValueFactory("giaNhap"));
        giaBan.setCellValueFactory(new PropertyValueFactory("giaBan"));
        ngayHSD.setCellValueFactory(new PropertyValueFactory("ngayHSD"));
        soLuong.setCellValueFactory(new PropertyValueFactory("soLuong"));
        ghiChu.setCellValueFactory(new PropertyValueFactory("ghiChu"));
         
        tbHang.getItems().clear();
        tbHang.setItems(kiemTraHangDal.loadData(resultSet));
    
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        //Load ten nha cung cap
        cbTenNcc.getItems().clear();
        cbTenNcc.setItems(kiemTraHangDal.loadTenNcc());
        
        //Load ten loai hang
        cbLoaiHang.getItems().clear();
        cbLoaiHang.setItems(kiemTraHangDal.loadTenLoaiHang());
        
        
         //Datepicker tu ngay Format
        
        tuNgay.setValue(LocalDate.now());
        
        String pattern = "dd-MM-yyyy";

        tuNgay.setConverter(new StringConverter<LocalDate>() {
             DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

             @Override 
             public String toString(LocalDate date) {
                 if (date != null) {
                     return dateFormatter.format(date);
                 } else {
                     return "";
                 }
             }

             @Override 
             public LocalDate fromString(String string) {
                 if (string != null && !string.isEmpty()) {
                     return LocalDate.parse(string, dateFormatter);
                 } else {
                     return null;
                 }
             }
         });
        
        
        //Datepicker den ngay Format
        
        denNgay.setValue(LocalDate.now());
      
        denNgay.setConverter(new StringConverter<LocalDate>() {
             DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

             @Override 
             public String toString(LocalDate date) {
                 if (date != null) {
                     return dateFormatter.format(date);
                 } else {
                     return "";
                 }
             }

             @Override 
             public LocalDate fromString(String string) {
                 if (string != null && !string.isEmpty()) {
                     return LocalDate.parse(string, dateFormatter);
                 } else {
                     return null;
                 }
             }
         });
        
        
    }    
    
    @FXML
    private void handleTimMaHang(ActionEvent event) 
    {
        boolean empty=frm.textIsEmtpy(txtMaHang, "Nhập mã hàng");
        if(!empty)
        {
            hangDto.setMaHang(txtMaHang.getText().trim());
            resultSet=kiemTraHangDal.timKiemTheoMaHang(hangDto);
            loadTabble(resultSet);
        }
    }
    
    @FXML
    private void handleTimTenHang(ActionEvent event) 
    {
        boolean empty=frm.textIsEmtpy(txtTenHang, "Nhập tên hàng");
        if(!empty)
        {
            hangDto.setTenHang(txtTenHang.getText().trim());
            resultSet=kiemTraHangDal.timKiemTheoTenHang(hangDto);
            loadTabble(resultSet);
        }
    }
    
    @FXML
    private void handleTimTenNcc(ActionEvent event) 
    {
        boolean empty=frm.comboBoxIsEmtpy(cbTenNcc, "Chọn tên NCC");
        if(!empty)
        {
            nccDto.setTenNcc(cbTenNcc.getSelectionModel().getSelectedItem().toString());
            resultSet=kiemTraHangDal.timKiemTheoTenNcc(nccDto);
            loadTabble(resultSet);
        }
    }
    
    @FXML
    private void handleTimLoaiHang(ActionEvent event) 
    {
        boolean empty=frm.comboBoxIsEmtpy(cbLoaiHang, "Chọn loại hàng");
        if(!empty)
        {
            loaiHangDto.setTenLoaiHang(cbLoaiHang.getSelectionModel().getSelectedItem().toString());
            resultSet=kiemTraHangDal.timKiemTheoLoaiHang(loaiHangDto);
            loadTabble(resultSet);
        }
    }
    
    @FXML
    private void handleTimHangCon(ActionEvent event) 
    {
            resultSet=kiemTraHangDal.timKiemHangCon();
            loadTabble(resultSet);      
    }
    
    @FXML
    private void handleTimHangHet(ActionEvent event) 
    {
            resultSet=kiemTraHangDal.timKiemHangHet();
            loadTabble(resultSet);      
    }
    
    @FXML
    private void handleTimHangHetHan(ActionEvent event) 
    {
            LocalDate tu=tuNgay.getValue();
            LocalDate den=denNgay.getValue();
            resultSet=kiemTraHangDal.timKiemHangHetHan(tu,den);
            loadTabble(resultSet);      
    }
    
}

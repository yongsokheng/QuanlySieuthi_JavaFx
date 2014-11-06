/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.DonNhapHangDal;
import dal.NccDal;
import dto.DonHangDto;
import dto.DonNhapHangDto;
import dto.HangDto;
import dto.HangNhapDto;
import dto.LoaiHangDto;
import dto.NccDto;
import dto.NhanVienDto;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author YONGSOKHENG
 */
public class DonNhapHangController implements Initializable {

    //TableView Data
    @FXML 
    TableView<DonNhapHangDto> tbDonNhap;
    @FXML
    TableColumn<DonNhapHangDto,String> maHoaDon;
    @FXML
    TableColumn<DonNhapHangDto,String> ngayLap;
    @FXML
    TableColumn<DonNhapHangDto,String> tenHang;
    @FXML
    TableColumn<DonNhapHangDto,String> loaiHang;
    @FXML
    TableColumn<DonNhapHangDto,Double> soLuong;
    @FXML
    TableColumn<DonNhapHangDto,String> donViTinh;
    @FXML
    TableColumn<DonNhapHangDto,Double> giaNhap;
    @FXML
    TableColumn<DonNhapHangDto,Double> thanhTien;
            
    //Hoa DOn
    @FXML
    TextField txtMaHoaDon;
    @FXML
    DatePicker ngayNhapHang;
    
    //Nha cung cap
    @FXML
    ComboBox cbMaNcc;
    @FXML
    TextField txtTenNcc;
    
    //Hang
    @FXML 
    ComboBox cbMaHang;
    @FXML
    TextField txtTenHang;
    @FXML
    TextField txtDonViTinh;
    @FXML
    TextField txtGiaNhap;
    @FXML
    TextField txtGiaBan;
    @FXML
    TextField txtLoai;
    @FXML
    TextField txtTenNccHang;
    @FXML
    TextField txtSoLuong;
    
    //Nhan Vien
    @FXML 
    ComboBox cbMaNV;
    @FXML
    TextField txtTenNV;
    
    // Khai Bao Doi tuong
    DonNhapHangDal donNhapHangDal=new DonNhapHangDal();
    NccDto nccDto=new NccDto();
    HangDto hangDto=new HangDto();
    NhanVienDto nhanVienDto=new NhanVienDto();
    DonHangDto donHangDto=new DonHangDto();
    HangNhapDto hangNhapDto=new HangNhapDto();
    LoaiHangDto loaiHangDto=new LoaiHangDto();
    FormValidation frm=new FormValidation();
    
    public void xoaThongTinHang()
    {
        txtTenHang.setText("");
        txtDonViTinh.setText("");
        txtGiaBan.setText("");
        txtGiaNhap.setText("");
        txtLoai.setText("");
        txtSoLuong.setText("");
    
    }
    
    public void themmoi()
    {
       xoaThongTinHang();
       txtMaHoaDon.setText("");
       ngayNhapHang.setValue(LocalDate.now());
       cbMaNcc.getSelectionModel().select("");
       cbMaNV.getSelectionModel().select("");
       
       
       
    }
    
    public boolean validate()
    {
        boolean maHoDonEmpty=frm.textIsEmtpy(txtMaHoaDon, "chưa có thông tin");
        boolean maNccEmpty=frm.comboBoxIsEmtpy(cbMaNcc, "chưa có thông tin");
        boolean maNvEmpty=frm.comboBoxIsEmtpy(cbMaNV, "chưa có thông tin");
        boolean maHangEmpty=frm.comboBoxIsEmtpy(cbMaHang, "chưa có thông tin");
        boolean soLuongEmpty=frm.textIsEmtpy(txtSoLuong, "chưa có thông tin");
        boolean soLuongIsNumber=frm.textIsNumberic(txtSoLuong, "phải là số");
        
        if(!maHoDonEmpty && !maNccEmpty && !maNvEmpty && !maHangEmpty &&  !soLuongEmpty && soLuongIsNumber) 
            return true;
        return false;
        
    }
    
    public void loadTabble()
    {
        //Load Data vao TableView
        maHoaDon.setCellValueFactory(new PropertyValueFactory("maHoaDon"));
        ngayLap.setCellValueFactory(new PropertyValueFactory("ngayDatHang"));
        tenHang.setCellValueFactory(new PropertyValueFactory("tenHang"));
        loaiHang.setCellValueFactory(new PropertyValueFactory("loaiHang"));
        soLuong.setCellValueFactory(new PropertyValueFactory("soLuong"));
        donViTinh.setCellValueFactory(new PropertyValueFactory("donViTinh"));
        giaNhap.setCellValueFactory(new PropertyValueFactory("giaNhap"));
        thanhTien.setCellValueFactory(new PropertyValueFactory("thanhTien"));
        
        tbDonNhap.getItems().clear();
        tbDonNhap.setItems(donNhapHangDal.loadData());
    
    
    }
    
    public void addTableView()
    {
         //Load Data vao TableView
        ObservableList<DonNhapHangDto> dataTableView=FXCollections.observableArrayList(); 
        
        maHoaDon.setCellValueFactory(new PropertyValueFactory("maHoaDon"));
      //  ngayLap.setCellValueFactory(new PropertyValueFactory("ngayDatHang"));
        tenHang.setCellValueFactory(new PropertyValueFactory("tenHang"));
        loaiHang.setCellValueFactory(new PropertyValueFactory("loaiHang"));
        soLuong.setCellValueFactory(new PropertyValueFactory("soLuong"));
        donViTinh.setCellValueFactory(new PropertyValueFactory("donViTinh"));
        giaNhap.setCellValueFactory(new PropertyValueFactory("giaNhap"));
        thanhTien.setCellValueFactory(new PropertyValueFactory("thanhTien"));
        
        dataTableView=donNhapHangDal.loadDataTbView(hangDto, hangNhapDto, donHangDto, nccDto, nhanVienDto, loaiHangDto);
        tbDonNhap.setItems(dataTableView);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        loadTabble();
        
         // Handle ListView selection changes.
        
            SimpleDateFormat oldFormat = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");   
        
            tbDonNhap.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                
            try {
                int i=tbDonNhap.getSelectionModel().getSelectedIndex();
                if(i>=0)
                {
                    txtMaHoaDon.setText(newValue.getMaHoaDon());
                    ngayNhapHang.setValue(LocalDate.parse(newFormat.format(oldFormat.parse(newValue.getNgayDatHang()))));
                    cbMaNcc.getSelectionModel().select(newValue.getMaNcc());
                    cbMaNV.getSelectionModel().select(newValue.getMaNV());
                    cbMaHang.getSelectionModel().select(newValue.getMaHang());
                    txtSoLuong.setText(String.format("%.0f" ,newValue.getSoLuong()));
                }
                
            } catch (ParseException ex) {
                Logger.getLogger(DonNhapHangController.class.getName()).log(Level.SEVERE, null, ex);
            }
                
           
         });
        
        
        //Data nha cung cap
        cbMaNcc.getItems().clear();
        cbMaNcc.setItems(donNhapHangDal.loadDataNcc());
        
        cbMaNcc.setOnAction((event) -> {
           nccDto.setMaNcc(cbMaNcc.getSelectionModel().getSelectedItem().toString());
           txtTenNcc.setText(donNhapHangDal.getTenNhaCungCap(nccDto)); 
           
           //Load Data Hang theo maNCC
           xoaThongTinHang();
           cbMaHang.getItems().clear();
           cbMaHang.setItems(donNhapHangDal.loadDataHang(nccDto));
           
        });
        
        //Data Hang
      
        cbMaHang.setOnAction((event) -> {
            
            try {
                if(cbMaHang.getSelectionModel().getSelectedIndex()>=0)
                {
                    hangDto.setMaHang(cbMaHang.getSelectionModel().getSelectedItem().toString());
                
                    ResultSet resultSet=donNhapHangDal.getThongTinHang(hangDto);
                    if(resultSet.next())
                    {
                        txtTenHang.setText(resultSet.getString("tenHang"));
                        txtDonViTinh.setText(resultSet.getString("donViTinh"));
                        txtGiaBan.setText(resultSet.getString("giaBan"));
                        txtGiaNhap.setText(resultSet.getString("giaNhap"));
                        txtLoai.setText(resultSet.getString("tenLoaiHang"));

                    }

                    resultSet.close();
                }
                    
                   
    
            } catch (SQLException ex) {
                Logger.getLogger(DonNhapHangController.class.getName()).log(Level.SEVERE, null, ex);
            }
              
           
        });
        
        //Data Nhan Vien
        cbMaNV.getItems().clear();
        cbMaNV.setItems(donNhapHangDal.loadDataNV());
        
        cbMaNV.setOnAction((event) -> {
            
            nhanVienDto.setMaNhanVien(cbMaNV.getSelectionModel().getSelectedItem().toString());
            txtTenNV.setText(donNhapHangDal.getTenNV(nhanVienDto));
            
        });
        
       //Datepicker ngayNhapHang Format
        
        ngayNhapHang.setValue(LocalDate.now());
        
        String pattern = "dd-MM-yyyy";

        ngayNhapHang.setConverter(new StringConverter<LocalDate>() {
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
    private void handleButtonLuu(ActionEvent event) 
    {
 
          
        if(validate())
         {
               donHangDto.setMaDonHang(txtMaHoaDon.getText());
               donHangDto.setNgayNhapHang(ngayNhapHang.getValue());
               donHangDto.setMaNv(cbMaNV.getSelectionModel().getSelectedItem().toString());
               donHangDto.setMaNcc(cbMaNcc.getSelectionModel().getSelectedItem().toString());

               hangNhapDto.setMaDonHang(txtMaHoaDon.getText());
               hangNhapDto.setMaHang(cbMaHang.getSelectionModel().getSelectedItem().toString());
               hangNhapDto.setSoLuong(Double.parseDouble(txtSoLuong.getText()));

               int result=donNhapHangDal.saveData(donHangDto, hangNhapDto);
               
               if(result==1)
               {
                 loadTabble();
                 JOptionPane.showMessageDialog(null, "Luu thanh cong"); 
                 themmoi();
               }
               else
                   JOptionPane.showMessageDialog(null, "Chua luu duoc."); 

         }
          
      
         
    }
    
   
    
}

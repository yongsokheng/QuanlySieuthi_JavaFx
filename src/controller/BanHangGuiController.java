/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.BanHangDal;
import dto.BanHangDto;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */

public class BanHangGuiController implements Initializable{
  
    @FXML
    TableView<BanHangDto> tblBanHang;
    @FXML
    TableColumn<BanHangDto, String> colMa;
    @FXML
    TableColumn<BanHangDto, String> colSoLuong;
    @FXML
    TableColumn<BanHangDto, String> colDonGia;
    @FXML
    TableColumn<BanHangDto, String> colDonViTinh;
    @FXML
    TableColumn<BanHangDto,Integer> colSTT;
    @FXML
    TableColumn<BanHangDto, String> colTenSanPham;
    @FXML
    TableColumn<BanHangDto, String> colThanhTien;
    @FXML
    TextField maSanPham;
    @FXML
    TextField tenSanPham;
    @FXML
    TextField donViTinh;
    @FXML
    TextField soLuong;
    @FXML
    TextField donGia;
    @FXML
    TextField maHoaDon;
    @FXML
            
    FormValidation validation=new FormValidation();
    DatePicker datePicker  = new DatePicker(LocalDate.now());
    LocalDate date=datePicker.getValue();
    BanHangDal banHangDal=new BanHangDal();
    BanHangDto banHangDto=new BanHangDto();
      
    public  static   ObservableList<BanHangDto> data=FXCollections.observableArrayList();
    public static int sTT=0;
    
    
        
    public boolean setValidation(){
        boolean ma=validation.textIsEmtpy(maSanPham, "Vui lòng nhập mã sản phẩm ");
        if(ma){
             return true;
        }
        else return false;
        
    }
     @Override
    public void initialize(URL location, ResourceBundle resources) {
    
          tblBanHang.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if(tblBanHang.getSelectionModel().getSelectedIndex()>=0)
                {
                    maSanPham.setText(newValue.getMaSanPham());
                    tenSanPham.setText(newValue.getTenSanPham());
                    soLuong.setText(""+newValue.getSoLuong()+"");
                    donGia.setText(""+newValue.getDonGia()+"");
                    donViTinh.setText(newValue.getDonViTinh());
                }
            
         });
          
          
       
    }
     
    
     public void loadData()
    {   
        colSTT.setCellValueFactory(c -> new SimpleObjectProperty(c.getValue().getsTT()));
        colMa.setCellValueFactory(new PropertyValueFactory("maSanPham"));
        colTenSanPham.setCellValueFactory(new PropertyValueFactory("tenSanPham"));        
        colSoLuong.setCellValueFactory(new PropertyValueFactory("soLuong"));
        colDonGia.setCellValueFactory(new PropertyValueFactory("donGia"));
        colThanhTien.setCellValueFactory(new PropertyValueFactory("thanhTien"));
        colDonViTinh.setCellValueFactory(new PropertyValueFactory("donViTinh"));     
        
    }
     
    public void loadDataFromCSDL(){
        loadData();
        tblBanHang.getItems().clear();
        tblBanHang.setItems(banHangDal.loadData(banHangDal.getTableData(banHangDto)));
    }
    
    public void setData(BanHangDto banHangDto)
    {
        
        if(!banHangDto.getTenSanPham().equals("")){
          
            maSanPham.setText(banHangDto.getMaSanPham());
            tenSanPham.setText(banHangDto.getTenSanPham());
            soLuong.setText("1");
            donViTinh.setText(banHangDto.getDonViTinh());
            donGia.setText(""+banHangDto.getThanhTien()+"");
        }   
        else {
            themmoi();
        }
        
    }
  

    
    @FXML
    private void handleThem(Event event){
        
        if(kiemTraMaSanPham()==true){
              
            data.addAll(new BanHangDto(++sTT,maSanPham.getText(), tenSanPham.getText(),Double.valueOf( soLuong.getText()),Double.valueOf( donGia.getText()), donViTinh.getText(),50000));
            loadData();
            tblBanHang.setItems(data);      
            themmoi(); 

            tblBanHang.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue == null) {
                    return;
                }
                JOptionPane.showMessageDialog(null, newValue.getMaSanPham() + newValue.getTenSanPham());
            }
            );
        }    
    }
    
    
    
    @FXML
    private void handleEnterPressed(KeyEvent event){
         if (event.getCode() == KeyCode.ENTER) {
             kiemTraMaSanPham();
         }
    }
    private boolean kiemTraMaSanPham(){
        if(!setValidation()){
        banHangDto.setMaSanPham(maSanPham.getText());  
        banHangDal.loadDataToTextField(banHangDal.setData(banHangDto), banHangDto);
        setData(banHangDto);
        return true;
        }
        else return false;
    }
            
    @FXML
    private void handleThanhTien(ActionEvent event) {
        banHangDto.setsTT(1);
        kiemTraMaSanPham();
        banHangDal.loadMaHoaDon(banHangDal.setMaHoaDon(banHangDto), banHangDto);
        int soHoaDon = Integer.valueOf(banHangDto.getMaHoaDon());
        banHangDto = new BanHangDto(maSanPham.getText(), tenSanPham.getText(), Double.valueOf(soLuong.getText()), Double.valueOf(donGia.getText()), donViTinh.getText(), "" + (soHoaDon + 1) + "", "1", "1", date.toString());
        if (banHangDal.updateKhoSanPham(banHangDto) > 0) {         
            if (banHangDal.themHangVaoDonHang(banHangDto) > 0) {
                if (banHangDal.themHangVaoHangBan(banHangDto) > 0) {
                    loadData();
                }
                else JOptionPane.showMessageDialog(null,"Them hang khong thanh cong");
            }
            else JOptionPane.showMessageDialog(null,"Them hang khong thanh cong");
        }
        else JOptionPane.showMessageDialog(null,"Hang trong kho khong du!");
        
        themmoi();
    }
    
    @FXML
    private void handleButtonXoa(ActionEvent event) 
    {
        try{
        data.remove(tblBanHang.getSelectionModel().getSelectedIndex());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Select item to remove");
        }    
    }
    @FXML
    public void thanhTien(){
        for(int i=0;i<data.size();i++){
            JOptionPane.showMessageDialog(null, data.size());
           
        }
    }

    private void themmoi() {
        maSanPham.setText("");
        tenSanPham.setText("");
        soLuong.setText("");
        donGia.setText("");
        donViTinh.setText("");
              
    }
}

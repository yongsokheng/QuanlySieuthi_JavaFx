/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;


import dal.NccDal;
import dal.dalTTHang;
import dal.dalTTLoaiHang;
import dto.NccDto;
import dto.dtoTTHang;
import dto.dtoTTLoaiHang;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
 * @author Luckydays
 */
public class QuanLyThongTinHangController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    
    @FXML
    TableView<dtoTTHang>  tbTTHang;
    
    @FXML
    TableColumn<dtoTTHang , String> maHang;
    
    @FXML
    TableColumn<dtoTTHang , String> tenHang;
    
    @FXML
    TableColumn<dtoTTHang , String> maLoaiHang;
    
    @FXML
    TableColumn<dtoTTHang , String> maNCC;
    
    @FXML
    TableColumn<dtoTTHang , Double> donViTinh ;
    
    @FXML
    TableColumn<dtoTTHang , Double> giaNhap;
    
     @FXML
    TableColumn<dtoTTHang , Double> giaBan;
     
     @FXML
    TableColumn<dtoTTHang , String> ghiChu;
     
      @FXML
    TableColumn<dtoTTHang , String> ngayHSD;
    
    
    
     @FXML
    TextField txtMaHang;

    @FXML
    TextField txtTenHang;

    @FXML
    ComboBox comboMaLoaiHang;
    
    @FXML
    TextField txtMaLoaiHang;

    @FXML
    ComboBox comboMaNhaCungCap;
    
    @FXML
    TextField txtMaNCC;

    @FXML
    TextField txtDonViTinh;

    @FXML
    TextField txtGiaNhap;

    @FXML
    TextField txtGiaBan;

    @FXML
    TextField txtGhiChu;
    
    

    @FXML
    DatePicker ngayhsd;
    
    dalTTHang daltthang=new dalTTHang();
    dtoTTHang dtotthang=new dtoTTHang();
    FormValidation frm=new FormValidation();
    dalTTLoaiHang dalttloaihang = new dalTTLoaiHang();
    NccDal nccdal = new NccDal();
    dtoTTLoaiHang dtottloaihang = new dtoTTLoaiHang();
    NccDto nccdto = new NccDto();
    
   
    
    public void themmoi()
    {
        txtMaHang.setText("");
        txtTenHang.setText("");
        comboMaLoaiHang.getSelectionModel().select("");
        comboMaNhaCungCap.getSelectionModel().select("");
        txtDonViTinh.setText(""); 
        txtGiaNhap.setText(""); 
        txtGiaBan.setText("");
        txtGhiChu.setText("");
        ngayhsd.setValue(LocalDate.now());
    }
    
    
    public void loadData()
    {
         maHang.setCellValueFactory(new PropertyValueFactory("maHang"));
         tenHang.setCellValueFactory(new PropertyValueFactory("tenHang"));
         maLoaiHang.setCellValueFactory(new PropertyValueFactory("maLoaiHang"));
         maNCC.setCellValueFactory(new PropertyValueFactory("maNhaCungCap"));
         donViTinh.setCellValueFactory(new PropertyValueFactory("donviTinh"));
         giaNhap.setCellValueFactory(new PropertyValueFactory("giaNhap"));
          giaBan.setCellValueFactory(new PropertyValueFactory("giaBan"));
         ghiChu.setCellValueFactory(new PropertyValueFactory("ghiChu"));
         ngayHSD.setCellValueFactory(new PropertyValueFactory("ngayHSD"));
         
         
          tbTTHang.getItems().clear();
          tbTTHang.setItems(daltthang.loadData(daltthang.getHang()));
    }
    
    public boolean validate()
    {
        boolean maTTHangEmpty=frm.textIsEmtpy(txtMaHang, "Vui lòng nhập Mã Hàng");
        boolean tenTTHangEmpty=frm.textIsEmtpy(txtTenHang, "Vui lòng nhập tên hàng");
        boolean maLoaiHang=frm.comboBoxIsEmtpy(comboMaLoaiHang, "Vui lòng lựa chọn");
        boolean maNCC=frm.comboBoxIsEmtpy(comboMaNhaCungCap, "Vui lòng lựa chọn");
        boolean donViTinhEmpty=frm.textIsEmtpy(txtDonViTinh, "Vui lòng nhập đơn vị tính");
        boolean giaNhapEmpty=frm.textIsEmtpy(txtGiaNhap, "Vui lòng nhập giá nhập");
        boolean giaBanEmpty=frm.textIsEmtpy(txtGiaBan, "Vui lòng nhập giá bán");
        boolean ghiChuEmpty=frm.textIsEmtpy(txtGhiChu, "Vui lòng nhập ghi chu");
        
       
        if(!maTTHangEmpty && !tenTTHangEmpty && ! maLoaiHang && !maNCC && !donViTinhEmpty && !giaNhapEmpty && !giaBanEmpty && !ghiChuEmpty)
          return true;
        return false;
  //      return true;
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
             loadData();
             
            // Handle ListView selection changes.
             
            SimpleDateFormat oldFormat = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd"); 
        
            tbTTHang.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                try {
                int i=tbTTHang.getSelectionModel().getSelectedIndex();
                if(i>=0)
                {
                    txtMaHang.setText(newValue.getMaHang());
                    txtTenHang.setText(newValue.getTenHang());
                    comboMaLoaiHang.getSelectionModel().select(newValue.getMaLoaiHang());
                    comboMaNhaCungCap.getSelectionModel().select(newValue.getMaNhaCungCap());
                    txtDonViTinh.setText(newValue.getDonviTinh());
                    txtGiaNhap.setText(String.format("%.0f",newValue.getGiaNhap()));
                    txtGiaBan.setText(String.format("%.0f", newValue.getGiaBan()));
                     txtGhiChu.setText( newValue.getGhiChu());
                    ngayhsd.setValue(LocalDate.parse(newFormat.format(oldFormat.parse(newValue.getNgayHSD()))));
                   
                } }
                catch(ParseException ex){
                     Logger.getLogger(QuanLyThongTinHangController.class.getName()).log(Level.SEVERE, null, ex);
                }
     
   
    
});
        //Datepicker ngayHSD Format

        ngayhsd.setValue(LocalDate.now());

        String pattern = "dd-MM-yyyy";

         ngayhsd.setConverter(new StringConverter<LocalDate>() {
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
         
         
         //Data nha cung cap
        comboMaLoaiHang.getItems().clear();
        comboMaLoaiHang.setItems(daltthang.loadDataLoaiHang());
        
        comboMaLoaiHang.setOnAction((event) -> {
        dtottloaihang.setMaLoaiHang(comboMaLoaiHang.getSelectionModel().getSelectedItem().toString());
        txtMaLoaiHang.setText(daltthang.loadDataTenLoaiHang(dtottloaihang)); 
        } );
        
        comboMaNhaCungCap.getItems().clear();
        comboMaNhaCungCap.setItems(daltthang.loadDataMaNCC());
        comboMaNhaCungCap.setOnAction((event) -> {
        nccdto.setMaNcc(comboMaNhaCungCap.getSelectionModel().getSelectedItem().toString());
        txtMaNCC.setText(daltthang.loadDataTenNCC(nccdto)); 
        } ); 
         
      
    
    
                }
    
    @FXML
    private void handleButtonLuu(ActionEvent event) 
    {
        
        
 
          
        if(validate())
         {
             
              
               dtotthang.setMaHang(txtMaHang.getText());
               dtotthang.setTenHang(txtTenHang.getText());    
               dtotthang.setMaLoaiHang(comboMaLoaiHang.getSelectionModel().getSelectedItem().toString());
               dtotthang.setMaNhaCungCap(comboMaNhaCungCap.getSelectionModel().getSelectedItem().toString());
               dtotthang.setDonviTinh(txtDonViTinh.getText());
               dtotthang.setGiaNhap(Double.parseDouble(txtGiaNhap.getText()));
               dtotthang.setGiaBan(Double.parseDouble(txtGiaBan.getText()));
               dtotthang.setGhiChu(txtGhiChu.getText());
               dtotthang.setNgayHSD(ngayhsd.getValue().toString());
               int result=daltthang.saveData(dtotthang);
               
              if(result>0)
               {
                 loadData();
                 themmoi();
                 JOptionPane.showMessageDialog(null, "Luu thanh cong"); 
                 
               }
               else
                  JOptionPane.showMessageDialog(null, "Chua luu duoc."); 

         }
          
      
         
    }
    
    @FXML
    private void handleButtonXoa(ActionEvent event) 
    {
      int i=tbTTHang.getSelectionModel().getSelectedIndex();
      
      if(i>=0)
      {
         dtotthang.setMaHang(tbTTHang.getSelectionModel().getSelectedItem().getMaHang());
         if(daltthang.deleteData(dtotthang)>0)
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
    private void handleButtonUpdate(ActionEvent event) 
    {
      int i=tbTTHang.getSelectionModel().getSelectedIndex();
      
      if(i>=0)
      {
            if(validate())
            {
                dtotthang.setMaHang(txtMaHang.getText());
                dtotthang.setTenHang(txtTenHang.getText());
                dtotthang.setMaLoaiHang(comboMaLoaiHang.getSelectionModel().getSelectedItem().toString());
                dtotthang.setMaNhaCungCap(comboMaNhaCungCap.getSelectionModel().getSelectedItem().toString());
                dtotthang.setDonviTinh(txtDonViTinh.getText());
                dtotthang.setGiaNhap(Double.parseDouble(txtGiaNhap.getText()));
                dtotthang.setGiaBan(Double.parseDouble(txtGiaBan.getText()));
                dtotthang.setGhiChu(txtGhiChu.getText());
                dtotthang.setNgayHSD(ngayhsd.getValue().toString());
                
                
                
               String ma=tbTTHang.getSelectionModel().getSelectedItem().getMaHang();

               if(daltthang.updateData(dtotthang,ma)>0)
              {
                  loadData();
                  themmoi();
                  JOptionPane.showMessageDialog(null, "Update thành công");
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
    
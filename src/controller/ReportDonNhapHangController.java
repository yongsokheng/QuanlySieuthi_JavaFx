/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.util.StringConverter;

/**
 * FXML Controller class
 *
 * @author Chamnan
 */
public class ReportDonNhapHangController implements Initializable {
 
  @FXML
  DatePicker txtTo;
  @FXML
  DatePicker txtFrom;
  private ReportClass report=new ReportClass();
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
         //Datepicker txtTo Format
        
        txtTo.setValue(LocalDate.now());
        
        String pattern = "dd-MM-yyyy";

        txtTo.setConverter(new StringConverter<LocalDate>() {
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
        
        
        //Datepicker txtTo Format
        
        txtFrom.setValue(LocalDate.now());

        txtFrom.setConverter(new StringConverter<LocalDate>() {
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
    private void btnReportDonHang(ActionEvent event) 
    {
        Map para=new HashMap();
        para.put("paraTo",txtTo.getValue());
        para.put("paraFrom", txtFrom.getValue());
        report.print("DonNhapHangReport.jrxml", para);
    }
    
}

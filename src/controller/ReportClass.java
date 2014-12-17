/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.DatabaseManager;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author YONGSOKHENG
 */
public class ReportClass {
    
      public void print(String reportName, Map parameter)
    {
      
        try {
         
            DatabaseManager db=new DatabaseManager();
            String report="src/report/"+reportName;
            JasperReport jr=JasperCompileManager.compileReport(report);
            
            JasperPrint jp=JasperFillManager.fillReport(jr, parameter, db.connection);
           // JasperExportManager.exportReportToPdfFile(jp,"StudentInfo.pdf");
           // JasperExportManager.exportReportToHtmlFile(jp,"sample.html");
            JasperViewer.viewReport(jp, false);
            
        } catch (JRException ex) {
           System.out.println(ex);
        }

        
    }
    
}

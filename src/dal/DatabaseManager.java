
package dal;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author YONGSOKHENG
 */

public class DatabaseManager {
    
    public Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    
    private final String DRIVER="com.mysql.jdbc.Driver";
    private final String DATABASE= "jdbc:mysql://localhost/quanlysieuthi";
    
    public DatabaseManager()
    {
        try {
            Class.forName(DRIVER);
            connection=DriverManager.getConnection(DATABASE,"root","");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
    public ResultSet loadData(String sqlCode)
    {
        try {
            connection=DriverManager.getConnection(DATABASE,"root","");
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sqlCode);
          
          
        } catch (SQLException ex) {
         // JOptionPane.showMessageDialog(null,"Có lỗi xảy ra.");
          JOptionPane.showMessageDialog(null,ex);
        }
        
         return resultSet;
    }
    
    public int executeData(String sqlCode)
    {
        int result=0;
        try {
            connection=DriverManager.getConnection(DATABASE,"root","");
            statement=connection.createStatement();
            result=statement.executeUpdate(sqlCode);
            statement.close();
            connection.close();
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Có lỗi. Hãy kiểm tra lại.");
            JOptionPane.showMessageDialog(null,ex);
            
        }
       
        return result;
    }
    
   
    
}

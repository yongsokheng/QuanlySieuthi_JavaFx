
package dal;

import dto.LoginDto;
import dto.NccDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author YONGSOKHENG
 */
public class UserDal {
    
    DatabaseManager db=new DatabaseManager();
    ObservableList<LoginDto> data=FXCollections.observableArrayList();
    ResultSet resultSet;
    
    // Luu User
    public int themUser(LoginDto loginDto)
    {
       String sqlCode="INSERT INTO taikhoan VALUES('"+loginDto.getUsername()+"','"+loginDto.getPassword()+"','"+loginDto.getRole()+"')";
       return db.executeData(sqlCode);
    }
    
    public int xoaUser(LoginDto loginDto)
    {
        String sqlCode="DELETE FROM taikhoan WHERE username='"+loginDto.getUsername()+"'";
        return db.executeData(sqlCode);
        
    }
    
   public ObservableList<LoginDto> loadData()
   {
        try {
            resultSet=db.loadData("SELECT * FROM taikhoan");
            while(resultSet.next())
            {
                String username=resultSet.getString("username");
                String pwd=resultSet.getString("password");
                String role=resultSet.getString("role");
                data.add(new LoginDto(username,pwd,role));
                
            }
            
            resultSet.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDal.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        return data;
   }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dto.LoginDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YONGSOKHENG
 */
public class LoginDal {
    
    DatabaseManager db=new DatabaseManager();
    ResultSet resultSet;
    
    public int kiemTraLogin(LoginDto login)
    {
        try {
            
            String sqlCode="SELECT * FROM taikhoan WHERE username='"+login.getUsername()+"' AND password='"+login.getPassword()+"'";
            resultSet=db.loadData(sqlCode);
            if(resultSet.next())
                return 1;
           
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginDal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
}

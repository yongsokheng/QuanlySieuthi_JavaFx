
package dal;

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
public class NccDal {
    
    NccDto nccDto=new NccDto();
    DatabaseManager db=new DatabaseManager();
    ResultSet resultSet;
    private ObservableList<NccDto> data=FXCollections.observableArrayList();
    
    public ObservableList<NccDto> loadData()
    {
        try {
                String maNcc;
                String tenNcc;
                String soDt;
                String diaChi;
                resultSet=db.loadData("SELECT * FROM nhacungcap");
                while(resultSet.next())
                {
                    maNcc=resultSet.getString("maNCC");
                    tenNcc=resultSet.getString("tenNCC");
                    soDt=resultSet.getString("dienThoai");
                    diaChi=resultSet.getString("diaChi");
                    data.add(new NccDto(maNcc,tenNcc,soDt,diaChi));
                }
                
                resultSet.close();
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        return data;
    
    }
    
    public int saveData(NccDto nccDto)
    {
        String sql="INSERT INTO nhacungcap VALUES('"+nccDto.getMaNcc()+"','"+nccDto.getTenNcc()+"','"+nccDto.getDiaChi()+"','"+nccDto.getSoDt()+"')";
        int result=db.executeData(sql);
        return result;
    }
    
    public int deleteData(NccDto nccDto)
    {
      String sql="DELETE FROM nhacungcap WHERE maNCC='"+nccDto.getMaNcc()+"'";
      int result=db.executeData(sql);
      return result;
    }
    
   public int updateData(NccDto nccDto, String ma)
   {
      String sql="UPDATE nhacungcap SET maNCC='"+nccDto.getMaNcc()+"',tenNCC='"+nccDto.getTenNcc()+"', dienthoai='"+nccDto.getSoDt()+"',diaChi='"+nccDto.getDiaChi()+"' WHERE maNCC='"+ma+"'";
      int result=db.executeData(sql);
      return result;
   }
    
}

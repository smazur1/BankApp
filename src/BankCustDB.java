

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BankCustDB {                      
    private Statement stmt = null;
    private ResultSet rs = null;
    private String custId;
    private String lastName;
    private String firstName;       
    
    public BankCust getCust(String firstName, String lastName)
    {
        BankCust cust1 = new BankCust();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "select * from BankCust where firstName='"+firstName+" and lastName='"+lastName+"'";
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
        
                cust1.setCustId(rs.getString("custId"));               
cust1.setInDatabase(true);            }
        }catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                con.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return cust1;
    }
        public int insert(BankCust cust1){
        int cnt=0;
        try{
            connect();
            String insertProduct = "INSERT into BankCust "+
                    "(firstName, lastName)" + "VALUES (?, ?)";
            PreparedStatement ps= con.prepareStatement(insertProduct);
            
            ps.setString(1,cust1.getFirstName());
            ps.setString(2, cust1.getLastName());
            cnt = ps.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return cnt;
    }         public void connect(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
            stmt = con.createStatement();
        }catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try {
                //    rs.close();
                stmt.close();
                //    con.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }    public int updateBankCust(String custId, String firstName, String lastName){
        int cnt=0;
        try{
            connect();
            String sql="Update BankCust SET lastName= ?, firstName=? where custId=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,lastName);
            pstmt.setString(2, firstName);
            pstmt.setString(3,custId);
            cnt=pstmt.executeUpdate();
            con.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return cnt;
    }    
    public int delete(String custId){
        int cnt=0;
        try{
            connect();
            String deleteProduct = "DELETE FROM BankCust "+
                    "WHERE custId= ?";
            PreparedStatement ps= con.prepareStatement(deleteProduct);
            ps.setString(1,custId);
            cnt = ps.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return cnt;
    }
}

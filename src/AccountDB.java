
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDB {   
	
	static Connection con = null;
private Statement stmt = null;
private ResultSet rs = null;
private String accountNum;
private String accountType; 
//    private String book;    

public Account getAccount(String accountNum)
{
	Account account = new Account();
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	String sql = "select * from Account where accountNum='"+accountNum+"'";
	
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			account.setCustId(rs.getString("custId"));               
			account.setInDatabase(true);            }
	}
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
	catch (ClassNotFoundException e) 
	{
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
	return account;

}  


public void connect(){
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");
		stmt = con.createStatement();
	}
	
	catch (SQLException e) {
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
}  


public int insert(Account account)

{
	int cnt=0;
	try{
		connect();
		String insertProduct = "INSERT into Account "+
				"(accountNum, accountType)" + "VALUES (?, ?)";
		PreparedStatement ps= con.prepareStatement(insertProduct);
		ps.setString(1,account.getAccountNum());
		ps.setString(2,account.getAccountType());            
		cnt = ps.executeUpdate();
	} catch(SQLException e){
		e.printStackTrace();
	}
	return cnt;
} }


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransDB {

	// private Book b = new Book();

	private Connection con = null;

	private Connection connect() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// con = DriverManager.getConnection("jdbc:oracle:thin:sys as
			// sysdba/oracle@localhost:1521:orcl");
			con = DriverManager.getConnection("jdbc:oracle:thin:ora1/ora1@localhost:1521:orcl");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		}
		return con;
	}

	public Trans getTrans(long _transid) {

		Trans t = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from transaction where transid = ? ";

		try {
			connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, _transid);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				t = new Trans(rs.getLong("transid"), rs.getLong("accountid"), rs.getString("transtype"),
						rs.getDouble("amount"), rs.getInt("checknum"), rs.getDate("checkdate"),
						rs.getDate("transdate"));

				// System.out.println(rs.getString(1));
				// System.out.println(rs.getString(2));
				// System.out.println(rs.getString(3));
				// System.out.println(rs.getString(4));
				// System.out.println(rs.getDouble(5) + "\n");

			}
		} catch (SQLException e) {
			e.printStackTrace();
			// } catch (ClassNotFoundException e) {
			// e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return t;
	}

	public int processTrans(Long _transid) {

		PreparedStatement pstmt = null;
		int count = 0;

		String sql = "update transaction set transdate = ? where transid = ? ";

		try {

			connect();
			pstmt = con.prepareStatement(sql);
			Date dateobj = new Date();
			pstmt.setDate(1, dateobj);
			pstmt.setLong(2, _transid);

			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {

				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return count;
	}

	public int insertTrans(Long _accountid, String _transtype, Double _amount, int _checknum, Date _checkdate,
			Date _transdate) {

		PreparedStatement pstmt = null;
		int count = 0;

		String sql = "insert into transaction values (?, ?, ?, ?, ?, ?)";

		try {

			connect();
			pstmt = con.prepareStatement(sql);

			pstmt.setLong(1, _accountid);
			pstmt.setString(2, _transtype);
			pstmt.setDouble(3, _amount);
			pstmt.setInt(4, _checknum);
			pstmt.setDate(5, _checkdate);
			pstmt.setDate(6, _transdate);

			count = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {

				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return count;
	}

}

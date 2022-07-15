package Reevaluation;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;

public class Pending_cases {
	
		Connectivity o =new Connectivity();
		Connection con = o.Connective();
		String query="";
	public int add_into(int roll_no,String subject,int sem_no) throws SQLException
	{
		query="insert into pending_cases (roll_no,subject,sem)\n" + 
							"values("+roll_no+",'"+subject+"',"+sem_no+");";
		Statement stmt=con.createStatement();
		return stmt.executeUpdate(query);
	}
	public ResultSet display_pc() throws SQLException
	{
		String query="select * from pending_cases";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		/*System.out.println("Roll_no|\tSubject_ID|\tSemester");
		while(rs.next())
		{
			int roll_no=rs.getInt("roll_no");
			String subject=rs.getString("subject");
			int sem_no=rs.getInt("sem");
			System.out.println(roll_no+"     \t\t"+subject+"     \t\t"+sem_no);
		}*/
		return rs;
	}
	void delete_pc(int roll_no,int sem_no) throws SQLException
	{
		String query="delete from pending_cases where roll_no="+roll_no+" and sem="+sem_no;
		Statement stmt =con.createStatement();
		stmt.executeUpdate(query);
	}
}

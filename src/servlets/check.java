package servlets;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class check {
	Connectivity o =new Connectivity();
	Connection con = o.Connective();
	public int check_roll_no(int roll_no) throws SQLException
	{
		String query="select roll_no from student_details where roll_no="+roll_no+" ;";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs= stmt.executeQuery(query);
			
			if(rs.next())
			{
				roll_no=rs.getInt("roll_no");
				//System.out.println(roll_no);
				return roll_no;
			}
			else
			{
				return -1;
			}
		} 
		catch (SQLException e) {
			System.out.println(e);
		}
		
		return roll_no;
	}
	
	public String check_mailid(String mailid) throws SQLException
	{
		String s="";
		String query="select mailid from student_details where mailid= '"+mailid+"' ;";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs= stmt.executeQuery(query);
			if(rs.next())
			{
				mailid=rs.getString("mailid");
				//System.out.println(roll_no);
				return mailid;
			}
			else
			{
				return s;
			}
		} 
		catch (SQLException e) {
			System.out.println(e);
		}
		
		return s;
	}
}

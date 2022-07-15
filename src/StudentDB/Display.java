package StudentDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Display {

	Connectivity o =new Connectivity();
	Connection con=o.Connective();
	public ResultSet get_sgpa(int roll_no) throws SQLException
	{
		String query="select sem,sgpa from mark where roll_no="+roll_no+" order by sem asc;";
		Statement stmt= con.createStatement();
		ResultSet rsa =stmt.executeQuery(query);
		return rsa;
	}
	public ResultSet display_all(String choice,String order) throws SQLException
	{
		ResultSet rs= null;
		Statement stmt=null;
		String query="";
		if(choice.equals("name"))
		{
			if(order.equals("asc"))
			{
				query="select * from student_details order by name;";
				stmt=con.createStatement();
				rs= stmt.executeQuery(query);
				return rs;
			}
			else
			{
				query="select * from student_details order by name desc;";
				stmt=con.createStatement();
				rs= stmt.executeQuery(query);
				return rs;
			}
		}
		if(choice.equals("mailid"))
		{
			if(order.equals("asc"))
			{
				query="select * from student_details order by mailid;";
				stmt=con.createStatement();
				rs= stmt.executeQuery(query);
				return rs;
			}
			else
			{
				query="select * from student_details order by mailid desc;";
				stmt=con.createStatement();
				rs= stmt.executeQuery(query);
				return rs;
			}
		}
		if(choice.equals("dept"))
		{
			if(order.equals("asc"))
			{
				query="select * from student_details order by dept;";
				stmt=con.createStatement();
				rs= stmt.executeQuery(query);
				return rs;
			}
			else
			{
				query="select * from student_details order by dept desc;";
				stmt=con.createStatement();
				rs= stmt.executeQuery(query);
				return rs;
			}
		}
		if(choice.equals("year"))
		{
			if(order.equals("asc"))
			{
				query="select * from student_details order by yop;";
				stmt=con.createStatement();
				rs= stmt.executeQuery(query);
				return rs;
			}
			else
			{
				query="select * from student_details order by yop desc;";
				stmt=con.createStatement();
				rs= stmt.executeQuery(query);
				return rs;
			}
		}
		if(choice.equals("attper"))
		{
			if(order.equals("asc"))
			{
				query="select * from student_details order by attper;";
				stmt=con.createStatement();
				rs= stmt.executeQuery(query);
				return rs;
			}
			else
			{
				query="select * from student_details order by attper desc;";
				stmt=con.createStatement();
				rs= stmt.executeQuery(query);
				return rs;
			}
		}
		if(choice.equals("cgpa"))
		{
			if(order.equals("asc"))
			{
				query="select * from student_details order by cgpa;";
				stmt=con.createStatement();
				rs= stmt.executeQuery(query);
				return rs;
			}
			else
			{
				query="select * from student_details order by cgpa desc;";
				stmt=con.createStatement();
				rs= stmt.executeQuery(query);
				return rs;
			}
		}
		if(choice.equals("rollno"))
		{
			if(order.equals("asc"))
			{
				query="select * from student_details order by roll_no;";
				stmt=con.createStatement();
				rs= stmt.executeQuery(query);
				return rs;
			}
			else
			{
				query="select * from student_details order by roll_no desc;";
				stmt=con.createStatement();
				rs= stmt.executeQuery(query);
				return rs;
			}
		}
		else
		{
			return rs;
		}
	}
}

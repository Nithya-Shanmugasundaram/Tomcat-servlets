package StudentDB;

import java.util.*;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Read {
	
	Statement stmt;
	Connectivity o =new Connectivity();
	Connection con=o.Connective();
	public ResultSet read_name(String name1, String op) throws SQLException
	{
		String query="";
		ResultSet rs=null;
		switch(op)
		{
		case "equal"://equal
			query="select * from student_details where name= '"+name1+"' order by roll_no;";
			stmt=con.createStatement();
			rs= stmt.executeQuery(query);
			query="";
			break;
		case "notequal"://not equal
				 query="select * from student_details where name!= '"+name1+"' order by roll_no;";
				 stmt=con.createStatement();
					rs= stmt.executeQuery(query);
					query="";
					break;
		case "starts"://partial string
				query="select * from student_details where name like '"+name1+"%' order by roll_no;";
				stmt=con.createStatement();
				rs= stmt.executeQuery(query);
				query="";
				break;
		case "endscontains":
				 query= "select * from student_details where name similar to '%(_"+name1+"_|_"+name1+")%' order by roll_no;";
				 stmt=con.createStatement();
					rs= stmt.executeQuery(query);
					query="";
					break;
		default:
			System.out.println("Invalid Input");
			break;
		}
		return rs;
	}
	public ResultSet read_dept(String dept1,String op) throws SQLException
	{
		String query="";
		ResultSet rs=null;
		switch(op)
		{
		case "equal"://equal
				query="select * from student_details where dept= '"+dept1+"' order by roll_no;";
				stmt=con.createStatement();
				rs= stmt.executeQuery(query);
				query="";
			break;
		case "notequal"://not equal
			query="select * from student_details where dept!= '"+dept1+"' order by roll_no;";
			stmt=con.createStatement();
			rs= stmt.executeQuery(query);
			query="";
			break;
		case "starts"://partial string
				query="select * from student_details where dept like '"+dept1+"%' order by roll_no;";
				stmt=con.createStatement();
				rs= stmt.executeQuery(query);
				query="";
				break;
		case "endscontains":
				query= "select * from student_details where dept similar to '%(_"+dept1+"_|_"+dept1+")%' order by roll_no;";
				stmt=con.createStatement();
				rs= stmt.executeQuery(query);
				query="";
				break;
		}
		return rs;
	}
	public ResultSet read_mailid(String mailid1,String op) throws SQLException
	{
		String query="";
		ResultSet rs=null;
		switch(op)
		{
		case "equal"://equal
				query="select * from student_details where mailid= '"+mailid1+"' order by roll_no;";
				stmt=con.createStatement();
				rs= stmt.executeQuery(query);
				query="";
				break;
		case "notequal"://not equal
			 query="select * from student_details where mailid!= '"+mailid1+"' order by roll_no;";
			 stmt=con.createStatement();
				rs= stmt.executeQuery(query);
				query="";
				break;
		case "starts"://partial string
			query="select * from student_details where mailid like '"+mailid1+"%' order by roll_no;";
			stmt=con.createStatement();
			rs= stmt.executeQuery(query);
			query="";
			break;
		case "endscontains":
			query= "select * from student_details where mailid similar to '%(_"+mailid1+"_|_"+mailid1+")%' order by roll_no;";
			stmt=con.createStatement();
			rs= stmt.executeQuery(query);
			query="";
			break;
		default:
			System.out.println("invailid input");
		}
		return rs;
	}
}

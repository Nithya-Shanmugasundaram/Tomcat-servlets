package StudentDB;

import java.sql.*;
import java.util.*;

public class Read_numbers {

	Statement stmt;
	Connectivity o =new Connectivity();
	Connection con=o.Connective();
	public ResultSet read_roll_no(int rno, String op) throws SQLException
	{
		String query="";
		ResultSet rs=null;
		switch(op)
		{
		case "equal"://equal
			query="select * from student_details where roll_no ="+rno+" order by roll_no;";
			stmt=con.createStatement();
			rs= stmt.executeQuery(query);
			query="";
			break;
		case "notequal"://not equal
			query="select * from student_details where roll_no !="+rno+" order by roll_no;";
			stmt=con.createStatement();
			rs= stmt.executeQuery(query);
			query="";
			break;
		case "lesser"://less than
			query="select * from student_details where roll_no <"+rno+" order by roll_no;";
			stmt=con.createStatement();
			rs= stmt.executeQuery(query);
			query="";
			break;
		case "greater"://greater than
			query="select * from student_details where roll_no >"+rno+" order by roll_no;";
			stmt=con.createStatement();
			rs= stmt.executeQuery(query);
			query="";
			break;
		}
		return rs;
	}
	public ResultSet read_year(int yr, String op) throws SQLException
	{
		String query="";
		ResultSet rs=null;
		switch(op)
		{
		case "equal"://equal
			query="select * from student_details where yop ="+yr+" order by roll_no;";
			stmt=con.createStatement();
			rs= stmt.executeQuery(query);
			query="";
			break;
		case "notequal"://not equal
			query="select * from student_details where yop !="+yr+" order by roll_no;";
			stmt=con.createStatement();
			rs= stmt.executeQuery(query);
			query="";
			break;
		case "lesser"://less than
			query="select * from student_details where yop <"+yr+" order by roll_no;";
			stmt=con.createStatement();
			rs= stmt.executeQuery(query);
			query="";
			break;
		case "greater"://greater than
			query="select * from student_details where yop>"+yr+" order by roll_no;";
			stmt=con.createStatement();
			rs= stmt.executeQuery(query);
			query="";
			break;
		}
		return rs;
	}
	public ResultSet read_attper(double attper1, String op) throws SQLException
	{
		String query="";
		ResultSet rs=null;
		switch(op)
		{
		case "equal"://equal
			query="select * from student_details where attper ="+attper1+" order by roll_no;";
			stmt=con.createStatement();
			rs= stmt.executeQuery(query);
			query="";
			break;
		case "notequal"://not equal
			query="select * from student_details where attper !="+attper1+" order by roll_no;";
			stmt=con.createStatement();
			rs= stmt.executeQuery(query);
			query="";
			break;
		case "lesser"://less than
			query="select * from student_details where attper <"+attper1+" order by roll_no;";
			stmt=con.createStatement();
			rs= stmt.executeQuery(query);
			query="";
			break;
		case "greater"://greater than
			query="select * from student_details where attper >"+attper1+" order by roll_no;";
			stmt=con.createStatement();
			rs= stmt.executeQuery(query);
			query="";
			break;
		}
		return rs;
	}
	public ResultSet read_cgpa(double cgpa1, String op) throws SQLException
	{
		String query="";
		ResultSet rs=null;
		switch(op)
		{
		case "equal"://equal
			query="select * from student_details where cgpa ="+cgpa1+" order by roll_no;";
			stmt=con.createStatement();
			rs= stmt.executeQuery(query);
			query="";
			break;
		case "notequal"://not equal
			query="select * from student_details where cgpa !="+cgpa1+" order by roll_no;";
			stmt=con.createStatement();
			rs= stmt.executeQuery(query);
			query="";
			break;
		case "lesser"://less than
			query="select * from student_details where cgpa <"+cgpa1+" order by roll_no;";
			stmt=con.createStatement();
			rs= stmt.executeQuery(query);
			query="";
			break;
		case "greater"://greater than
			query="select * from student_details where cgpa >"+cgpa1+" order by roll_no;";
			stmt=con.createStatement();
			rs= stmt.executeQuery(query);
			query="";
			break;
		}
		return rs;
	}
	public ResultSet read_sgpa(int sem1,String op) throws SQLException
	{
		String query="";
		ResultSet rs=null;
		Statement stmt=null;
		if(op.equals("asc"))
		{
			query="select student_details.roll_no, name, dept,mailid, yop, attper,cgpa\n"
					+ "from student_details left join mark on mark.roll_no=student_details.roll_no where sem="+sem1+" order by sgpa;";
			stmt = con.createStatement();
			rs=stmt.executeQuery(query);
			//return rs;
		}
		if(op.equals("desc"))
		{
			query="select student_details.roll_no, name, dept,mailid, yop, attper, cgpa\n"
					+ "from student_details left join mark on mark.roll_no=student_details.roll_no where sem="+sem1+" order by sgpa desc;";
			stmt = con.createStatement();
			rs=stmt.executeQuery(query);
			//return rs;
		}
		return rs;
	}
}

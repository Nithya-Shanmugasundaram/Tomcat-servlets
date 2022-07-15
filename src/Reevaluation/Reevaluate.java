package Reevaluation;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

public class Reevaluate {

	Connectivity o =new Connectivity();
	Connection con=o.Connective();
	public int change_mark(int roll_no, int sem_no,String subject,double mark) throws SQLException
	{
		int u=0,u1=0;
		String query="update mark set "+subject+" ="+mark+" where roll_no="+roll_no+" and sem="+sem_no;
		Statement stmt =con.createStatement();
		u=stmt.executeUpdate(query);
		if(u>0)
		{
			Pending_cases obj = new Pending_cases();
			obj.delete_pc(roll_no, sem_no);
		}
		else
		{
			System.out.println("invalid input");
		}
		query="";
		query="select s1,s2,s3,s4,s5,s6 from mark where roll_no=? and sem=?";
		PreparedStatement ps1 = con.prepareStatement(query);
		ps1.setInt(1,roll_no);
		ps1.setInt(2,sem_no);
		ResultSet rs = ps1.executeQuery();		
		ArrayList <Double> marks= new ArrayList<Double>();
		double sgpa=0;
		rs.next();
			marks.add(rs.getDouble("s1"));
			marks.add(rs.getDouble("s2"));
			marks.add(rs.getDouble("s3"));
			marks.add(rs.getDouble("s4"));
			marks.add(rs.getDouble("s5"));
			marks.add(rs.getDouble("s6"));
		for(int i=0;i<marks.size();i++)
		{
			sgpa=marks.get(i)+sgpa;
		}
		sgpa=sgpa/marks.size();
		query="";
		query="update mark set sgpa=? where roll_no=? and sem=?";
		PreparedStatement ps2 = con.prepareStatement(query);
		ps2.setDouble(1,sgpa);
		ps2.setInt(2,roll_no);
		ps2.setInt(3,sem_no);
		int d=ps2.executeUpdate();
		query="";
		query="select sgpa from mark where roll_no=? ";
		PreparedStatement ps3 = con.prepareStatement(query);
		ps3.setInt(1,roll_no);
		ResultSet rs1 = ps3.executeQuery();
		ArrayList <Double> sgpa2= new ArrayList<Double>();
		double cgpa=0;
		while(rs1.next())
		{
			sgpa2.add(rs1.getDouble("sgpa"));
		}
		for(int i=0;i<sgpa2.size();i++)
		{
			cgpa=sgpa2.get(i)+cgpa;
		}
		cgpa=cgpa/sgpa2.size();
		query="";
		query="update student_details set cgpa=? where roll_no=?";
		PreparedStatement ps4 = con.prepareStatement(query);
		ps4.setDouble(1,cgpa);
		ps4.setInt(2,roll_no);
		u1=ps4.executeUpdate();
		/*if(u1>0)
		{
			System.out.println("The marks have been updated and the Cgpa and Sgpa have been calculated accordingly");
		}*/
		sgpa=0;
		cgpa=0;
		return d+u1;
	}
}

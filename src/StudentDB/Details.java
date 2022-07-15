package StudentDB;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

public class Details {

	void create_tables()
	{
		Connection con=null;
		Connectivity o =new Connectivity();
		con=o.Connective();
		Statement stmt = null;
		try {
			String query="create table Student_details (roll_no integer primary key,\n" + 
					" name varchar not null,\n" + 
					"dept varchar not null,\n" + 
					"mailid varchar unique not null,\n" + 
					"yop integer not null,\n" + 
					"attper numeric not null\n" + 
					"cgpa numeric"+
					")";
			stmt=con.createStatement();
			stmt.executeUpdate(query);
			query="";
			query=("create table mark (roll_no integer ,\n" + 
					"sem integer,s1 numeric,s2 numeric,s3 numeric,s4 numeric,s5 numeric,\n" + 
					"s6 numeric, sgpa numeric,\n" + 
					"foreign key(roll_no) references Student_details(roll_no));");
			stmt=con.createStatement();
			stmt.executeUpdate(query);
			query="";
			query="create table pending_cases (roll_no integer ,\n" + 
					"sem integer,subject varchar,\n" + 
					"foreign key(roll_no) references student_details(roll_no));";
			stmt=con.createStatement();
			stmt.executeUpdate(query);
			System.out.println("All tables necessary have been created now You can start entering values using 2 & 6");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public int basic_details(String name,String dept,int roll_no,String mailid,int year,double attper) throws SQLException
	{
		Connection con=null;
		Connectivity o =new Connectivity();
		con=o.Connective();
		String query="insert into student_details (roll_no,name,dept,mailid,yop,attper)\n" + 
				"values(?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1,roll_no);
		ps.setString(2,name);
		ps.setString(3, dept);
		ps.setString(4, mailid);
		ps.setInt(5,year);
		ps.setDouble(6,attper);
		return ps.executeUpdate();
	}
	public int mark_details(int roll_no,int sem_no,double [] marks) throws SQLException
	{
		Connection con=null;
		Connectivity o =new Connectivity();
		con=o.Connective();
		double a[]=new double [6];
		String query="";
			query="insert into mark (roll_no,sem)"
					+ "values (?,?);";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,roll_no);
			ps.setInt(2,sem_no);
			ps.execute();
			query="";
			for(int j=0;j<6;j++)
			{
				a[j]=marks[j];
				
			}
			query="";
			query="update mark set s1=?,s2=?,s3=?,s4=?,s5=?,s6=? where roll_no=? and sem=? ;";
				PreparedStatement psp = con.prepareStatement(query);
				psp.setDouble(1,a[0]);
				psp.setDouble(2,a[1]);
				psp.setDouble(3,a[2]);
				psp.setDouble(4,a[3]);
				psp.setDouble(5,a[4]);
				psp.setDouble(6,a[5]);
				psp.setInt(7,roll_no);
				psp.setInt(8,sem_no);
				psp.execute();
			query="";
			double sum=0;
			for(int k=0;k<6;k++)
			{
				sum+=a[k];
			}
			double sgpa =sum/6;
			query="update mark set sgpa=? where roll_no=? and sem=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setDouble(1,sgpa);
			pst.setDouble(2,roll_no);
			pst.setDouble(3,sem_no);
			pst.execute();
			sum=0;
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
			int u1=ps4.executeUpdate();
			return u1;
	}
}

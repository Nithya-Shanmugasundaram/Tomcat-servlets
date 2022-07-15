package StudentDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.*;

public class Update {

	public int update(int roll_no,String name,String dept,String mailid,int year,double attper)
	{
		Scanner sc= new Scanner(System.in);
		Connection con=null;
		Connectivity o =new Connectivity();
		con=o.Connective();
		int n=0;
		String query="";
		try
		{
			query="update student_details set roll_no=?,name=?,dept=?,mailid=?,yop=?,attper=? where roll_no=?";
			PreparedStatement ps= con.prepareStatement(query);
			ps.setInt(1,roll_no);
			ps.setString(2,name);
			ps.setString(3,dept);
			ps.setString(4,mailid);
			ps.setInt(5,year);
			ps.setDouble(6,attper);
			ps.setInt(7,roll_no);
			n =ps.executeUpdate();
			return n;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return n;
		}
	}
}

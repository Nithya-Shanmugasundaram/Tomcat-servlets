package StudentDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {

	public int delete(int rno) throws SQLException
	{
		Connection con=null;
		Connectivity o =new Connectivity();
		con=o.Connective();
		String query="";
		int st=0;
		try
		{
			query="delete from mark where roll_no=?";
			PreparedStatement psm= con.prepareStatement(query);
			psm.setInt(1,rno);
			st=st+psm.executeUpdate();
			//System.out.println("The data has been deleted");
			
			query="delete from pending_cases where roll_no=?";
			PreparedStatement psp= con.prepareStatement(query);
			psp.setInt(1,rno);
			st =st+ psp.executeUpdate();
			

			query="delete from student_details where roll_no=?";
			PreparedStatement ps= con.prepareStatement(query);
			ps.setInt(1,rno);
			st =st+ ps.executeUpdate();
			query="";
			return st;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return st;
		}
	}
}

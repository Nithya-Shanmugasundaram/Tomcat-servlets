package Reevaluation;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connectivity {

	public Connection Connective()
	{
		Connection con=null;
		try {
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/Student_DB","postgres","rootuser");
			if(con!=null)
			{
				//System.out.println("connected");
			}
			else 
			{
				System.out.println(" not connected");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
		return con;
	}
}

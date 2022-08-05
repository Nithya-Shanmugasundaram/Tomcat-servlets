package servlets;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class login extends HttpServlet
{
    private static String management_id="management";
    private static String management_pwd="management@123";
    private static String student_pwd="student@123";

    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
    {
	
	  try
	{
		String id  = req.getParameter("id");
        	String pwd = req.getParameter("pwd");
			
		try
		{
			//Integer.parseInt(id);
			int roll_no= Integer.parseInt(id);
			check obj =new check();
			int roll_no1= obj.check_roll_no(roll_no);
			if((roll_no==roll_no1)&&(pwd.equals(student_pwd)))
			{
				res.setStatus(200);
				System.out.println("vaild "+roll_no1);
				/**/HttpSession session = req.getSession(true);
				session.setAttribute("role", "student");
				res.getWriter().print("student");
			}
			else
			{
				res.setStatus(501);
				System.out.println("invaild "+roll_no);
			}
		}
		catch(NumberFormatException e)
		{
			if((id.equals(management_id))&&(pwd.equals(management_pwd)))
        		{
				res.setStatus(200);
				System.out.println("vaild "+id);
				/**/HttpSession session = req.getSession(true);
				session.setAttribute("role", "management");
				res.getWriter().print("management");
       	 	}
        		else
        		{
        			res.setStatus(501);
				System.out.println("invaild "+id);
        		}
		}

	}
	catch(Exception e)
	{
		System.out.println(e);
		res.setStatus(500);
	} 
    }
}
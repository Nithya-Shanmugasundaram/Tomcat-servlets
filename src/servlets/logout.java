package servlets;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class logout extends HttpServlet
{
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
    {
	
	  try
	{
        req.getSession().invalidate();
		res.setStatus(200);
        //res.sendRedirect(req.getContextPath() + "/welcome.jsp");
    }
	catch(Exception e)
	{
		System.out.println(e);
		res.setStatus(500);
		//res.sendRedirect(req.getContextPath() + "/error.jsp");
		//res.setStatus(500);
	} 
    }
}
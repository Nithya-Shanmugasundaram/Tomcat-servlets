package servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class verify_login extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
    {
        try
	{
        HttpSession session = req.getSession(false);
        res.getWriter().println(session.getAttribute("role"));
        System.out.println(session.getAttribute("role"));
	}
	catch(Exception e)
	{
		System.out.println(e);
		res.setStatus(500);
	} 
    }
}


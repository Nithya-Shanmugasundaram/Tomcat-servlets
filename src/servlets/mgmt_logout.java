package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class mgmt_logout extends  HttpServlet{

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
    {	
	  HttpSession session = req.getSession();
        if(session.getAttribute("mgmtname")!=null)
	   {
		session.removeAttribute("mgmtname");
		session.invalidate();
		res.setStatus(200);
	  }
	  else
	  {
		res.setStatus(500);
	  }
    }
}

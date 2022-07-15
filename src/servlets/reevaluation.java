package servlets;

import java.io.*;
import StudentDB.*;
import Reevaluation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class reevaluation extends HttpServlet {
    
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
    {
HttpSession session = req.getSession(false);
	if(session.getAttribute("mgmtname")==null)
	{
		res.setStatus(500);
		return;
	}
	else
	{
		try {
		int sem_no=Integer.parseInt(req.getParameter("sem_no"));
		int roll_no=Integer.parseInt(req.getParameter("roll_no"));
		
		String subject=req.getParameter("sub");
	double mark =Double.parseDouble(req.getParameter("mark"));
		int flag=0;
		
		Reevaluate obj = new Reevaluate();
		flag=obj.change_mark(roll_no,sem_no,subject,mark);
		
			if(flag>0)
			{
				System.out.println(flag);
				res.setStatus(200);				
			}
			else
			{
				res.setStatus(500);
			}
		 } 
		catch (Exception e) {
			System.out.println(e);
			res.setStatus(500);
		}
}
	
    }
}

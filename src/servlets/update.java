package servlets;

import java.io.*;
import StudentDB.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class update extends HttpServlet {
    
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
    {
	HttpSession session = req.getSession(false);
	String sess= (String)session.getAttribute("mgmtname");
	System.out.println("the session is: "+sess);
	if(sess==null)
	{
		res.setStatus(400);
		return;
	}
	else
	{
		try 
		{
		String name=req.getParameter("name");
		String dept=req.getParameter("dept");
		String mailid=req.getParameter("mailid");
		int roll_no=Integer.parseInt(req.getParameter("roll_no"));
		int year=Integer.parseInt(req.getParameter("year"));
		double attper = Double.parseDouble(req.getParameter("attper"));
		Update obj=new Update();
		int flag=0;
		flag=obj.update(roll_no,name,dept,mailid,year,attper);
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

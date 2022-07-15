package servlets;

import java.io.*;
import StudentDB.*;
import Reevaluation.Pending_cases;
//import javax.mail.*;
//import Mail_notify.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class reeval_app extends HttpServlet {
    
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
    {
	HttpSession session = req.getSession(false);
	if(session.getAttribute("roll_no")==null)
	{
		res.setStatus(500);
		return;
	}
	else
	{
		try {
		String sub=req.getParameter("sub");
		int sem_no=Integer.parseInt(req.getParameter("sem_no"));
		int roll_no=Integer.parseInt(req.getParameter("roll_no"));
		String mailid=req.getParameter("mailid");

		Pending_cases obj= new Pending_cases();
		int n=obj.add_into(roll_no,sub,sem_no);
			if(n>0)
			{
				System.out.println(n);
				res.setStatus(200);				
			}
			else
			{
				res.setStatus(500);
			}
		 } 
		catch (Exception e) {
			res.setStatus(500);
		}
}

    }
}

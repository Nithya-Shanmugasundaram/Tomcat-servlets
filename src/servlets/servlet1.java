package servlets;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class servlet1 extends HttpServlet
{
    private static String management_id="management";
    private static String management_pwd="management@123";

    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
    {
	  try
	{
		String mid  = req.getParameter("mgmt_id");
        	String mpwd = req.getParameter("mgmt_pwd");
      
        	if((mid.equals(management_id))&&(mpwd.equals(management_pwd)))
        	{
        	HttpSession session = req.getSession(true);
		session.setAttribute("mgmtname",mid);
		System.out.println(session.getId());
		res.setStatus(200);
		System.out.println("vaild "+mid);
		//System.out.println(session.getId());
		//System.out.println("valid credentials successful");
       	 }
        	else
        	{
        	res.setStatus(500);
		System.out.println("invaild "+mid);
        	}

	}
	catch(Exception e)
	{
		System.out.println(e);
		res.setStatus(500);
	} 
    }
}
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
public class delete extends HttpServlet {
    
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
    {
	try {
		int roll_no=Integer.parseInt(req.getParameter("roll_no"));
		Delete obj= new Delete();
		int flag=0;
		flag=obj.delete(roll_no);
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

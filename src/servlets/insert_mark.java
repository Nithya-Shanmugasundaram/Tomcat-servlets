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
public class insert_mark extends HttpServlet {
    
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
    {
	
		try {
		int sem_no=Integer.parseInt(req.getParameter("sem_no"));
		int roll_no=Integer.parseInt(req.getParameter("roll_no"));
		double a[]=new double [6];
		
	
		for(int i=1;i<=6;i++)
		{
			a[i-1]=Double.parseDouble(req.getParameter("s"+i));
		}		
		int flag=0;
		
		System.out.println(a[2]);
		Details obj=new Details();
		flag=obj.mark_details(roll_no,sem_no,a);
			if(flag>0)
			{
				System.out.println(flag);
				res.setStatus(200);				
			}
			else
			{
				res.setStatus(500);
			}
			return;
		 } 
		catch (Exception e) {
			System.out.println(e);
			res.setStatus(500);
		}
	
	
    }
}

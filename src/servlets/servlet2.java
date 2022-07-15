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
public class servlet2 extends HttpServlet {

    private static String student_pwd="student@123";
    
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
    {

    	try {
        check obj =new check();

           String  password = req.getParameter("stu_pwd");
           int   roll_no = Integer.parseInt(req.getParameter("stu_id"));
		int roll_no1= obj.check_roll_no(roll_no);

			if((roll_no==roll_no1)&&(password.equals(student_pwd)))
			{
				HttpSession session = req.getSession(true);
				session.setAttribute("roll_no",roll_no);
				res.setStatus(200);
				System.out.println("vaild "+roll_no1);
			}
			else
			{
				res.setStatus(500);
				System.out.println("invaild "+roll_no);
			}
		 } 
		catch (Exception e) {
			System.out.println(e);
			res.setStatus(500);
		}
    }
}

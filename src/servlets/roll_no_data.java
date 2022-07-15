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
import java.sql.*;

public class roll_no_data extends HttpServlet {
    
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
		JSONArray jarr = new JSONArray();
		int roll_no=Integer.parseInt(req.getParameter("roll_no"));
		String rollno_choice=req.getParameter("rollno_choice");
		
		Read_numbers robj= new Read_numbers();
		ResultSet rs= robj.read_roll_no(roll_no,rollno_choice);
		while(rs.next())
		{
			JSONObject jobj = new JSONObject();
                jobj.put("roll_no", rs.getInt("roll_no"));
                jobj.put("name", rs.getString("name"));
		    jobj.put("dept", rs.getString("dept"));
		    jobj.put("mailid", rs.getString("mailid"));
		    jobj.put("year", rs.getInt("yop"));
		    jobj.put("attper", rs.getDouble("attper"));
		    jobj.put("cgpa", rs.getDouble("cgpa"));
                jarr.put(jobj);
		}
            res.setStatus(200);
		 res.getWriter().print(jarr.toString());
            return;
		 } 
		catch (Exception e) {
			System.out.println(e);
			res.setStatus(500);
		}
}
	
    }
}

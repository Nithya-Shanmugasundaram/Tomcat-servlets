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

public class year_data extends HttpServlet {
    
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
    {
		try {
		JSONArray jarr = new JSONArray();
		int year=Integer.parseInt(req.getParameter("year"));
		String year_choice=req.getParameter("year_choice");
		Read_numbers robj= new Read_numbers();
		ResultSet rs= robj.read_year(year,year_choice);
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

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

import java.sql.*;

public class reeval_table extends HttpServlet {
    
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
    {
		try
		{ 
			JSONArray jarr = new JSONArray();
			Pending_cases pobj= new Pending_cases();
			ResultSet rs= pobj.display_pc();
			while(rs.next())
		{
			JSONObject jobj = new JSONObject();
                jobj.put("roll_no", rs.getInt("roll_no"));
                jobj.put("sem_no", rs.getInt("sem"));
                jobj.put("sub", rs.getString("subject"));
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

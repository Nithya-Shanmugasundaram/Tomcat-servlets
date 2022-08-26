package servlets;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import auth.AuthCallbackHandler;
import auth.*;
import java.security.Principal;
import javax.security.auth.Subject;

public class user_role_check extends HttpServlet
{
    private static String management_id="management";
    private static String management_pwd="management@123";
    private static String student_pwd="student@123";

    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
    {
	
	  try
	{
		/*AuthCallbackHandler ac = new AuthCallbackHandler(id, password);
            LoginContext lc = new LoginContext("test_auth", ac);
            lc.login();
            System.out.println("Login Successfull...");
			Subject s = lc.getSubject();
            for(Principal p:s.getPrincipals()){
                res.getWriter().println(p);
            }/*if((req.getUserPrincipal()!=null)&&(req.getRemoteUser()!=null))
			{}*/
            String m_role="management";
			String s_role="student";
			/*res.getWriter().println(req.getUserPrincipal());
			res.getWriter().println(req.getRemoteUser());
			res.getWriter().println(req.isUserInRole(m_role));*/
		System.out.println(req.getUserPrincipal());
		System.out.println(req.getRemoteUser());
           // System.out.println(req.isUserInRole(m_role));
			if(req.getRemoteUser().equals(m_role))
			{
				System.out.println(req.isUserInRole(m_role));
				res.setStatus(200);
				res.getWriter().print(m_role);
				//res.sendRedirect(req.getContextPath() + "/management/management.jsp");
			}
			else
			{
				System.out.println(req.isUserInRole(s_role));
				res.setStatus(200);
				res.getWriter().print(s_role);
				//res.sendRedirect(req.getContextPath() + "/student/student.jsp");
			}
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		res.setStatus(500);
		//res.sendRedirect(req.getContextPath() + "/error.jsp");
		//res.setStatus(500);
	} 
    }
}
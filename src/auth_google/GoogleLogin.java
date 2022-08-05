package auth_google;

import java.util.Collections;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import servlets.check;


public class GoogleLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        String inp;
        StringBuilder sb = new StringBuilder();
        while((inp=reader.readLine())!=null){
            sb.append(inp);
        }
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), GsonFactory.getDefaultInstance())
            .setAudience(Collections.singletonList("169207051925-hjheef65ld8mcc3braqg24ecrsi0ddjr.apps.googleusercontent.com"))
            .build();
        PrintWriter out = resp.getWriter();
        GoogleIdToken idToken;
        
        try {
            String role="";
            JSONObject jobj = new JSONObject(sb.toString());
            String code = jobj.getString("code");
            idToken = verifier.verify(code);
            if (idToken != null) 
            {
                Payload payload = idToken.getPayload();
                String email = payload.getEmail();
                boolean emailVerified = payload.getEmailVerified();
                if(emailVerified){
                    check obj = new check();
                    System.out.println(email);
                    String s_mailid = obj.check_mailid(email);
                    
                    String m_mailid ="manageautomail@gmail.com";
                    HttpSession session = req.getSession(true);
                    if(email.equals(m_mailid))
                    {
                         role ="management";
                    }
                    else if(email.equals(s_mailid))
                    {
                         role = "student";
                    }                


                    if(role.equals("management"))
                    {
                        if(email!=null)
                        {
                            //session.setAttribute("m_mailid", email);
                            session.setAttribute("role", "management");
                            out.println(role);
                            resp.setStatus(200);
                            return;
                        }
                     /*  else
                        {
                            resp.setContentType("text/plain");
                            resp.setStatus(400);
                            out.println("Invalid Login");
                            return;
                        } */ 
                    }
                    else if(role.equals("student"))
                    {
                        if(email!=null)
                        {
                            //session.setAttribute("s_mailid", email);
                            session.setAttribute("role", "student");
                            resp.setStatus(200);
                            out.println(role);
                            return;
                        }
                      /*   else
                        {
                            resp.setContentType("text/plain");
                            resp.setStatus(400);
                            out.println("Invalid Login");
                            return;
                        }*/
                    }
                }
            } 
            else 
            {
                resp.setContentType("text/plain");
                resp.setStatus(400);
                out.println("Authentication Failed...Try Again.");
                return;
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            resp.setContentType("text/plain");
            resp.setStatus(400);
            out.println("Something went wrong");
            return;
        }
    }
}
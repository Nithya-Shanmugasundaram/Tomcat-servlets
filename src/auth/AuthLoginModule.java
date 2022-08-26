package auth;

import servlets.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class AuthLoginModule implements LoginModule {
    private CallbackHandler handler;
    private Subject subject;
    private UserPrincipal userPrincipal;
    private RolePrincipal rolePrincipal;
    private String login;
    private List<String> userGroup;
    private static String management_id="management";
    private static String management_pwd="management@123";
    private static String student_pwd="student@123";

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState,
            Map<String, ?> options) {
        handler = callbackHandler;
        this.subject=subject;
    }
    private static int validate(String name,String password){
	  int flag=0;
	try
	{
        if(password.equals("null"))
        {
            if(name.equals("management"))
            {
                System.out.println("vaild "+name);
                return flag+2;
            }
            if(name.equals("student"))
            {
                System.out.println("vaild "+name);
                return flag+2;
            }
            else
            {
                return flag+3;
            }
        }
        else
        {
            try
		{
			int roll_no= Integer.parseInt(name);
			
			check obj =new check();
			int roll_no1= obj.check_roll_no(roll_no);
			if((roll_no==roll_no1)&&(password.equals(student_pwd)))
			{
				System.out.println("vaild "+roll_no1);
				return flag+=1;
			}
			else
			{
				System.out.println("invaild "+roll_no);
				return flag+=3;
			}
		}
	catch(NumberFormatException e)
		{
			if((name.equals(management_id))&&(password.equals(management_pwd)))
        		{
				System.out.println("vaild "+name);
				return flag+2;
       	 	}
        		else
        		{
				System.out.println("invaild "+name);
				return flag+3;
        		}
		}
        }
	   
	}
	catch(Exception e)
	{
		System.out.println("Exception caught\n"+e);
		return flag+3;
	}
	 
    }
    @Override
    public boolean login() throws LoginException {

        System.out.println("hello login module");
        Callback[] callback = new Callback[2];
        callback[0] = new NameCallback("login");
        callback[1] = new PasswordCallback("password", true);
        try{
            handler.handle(callback);
            String name = ((NameCallback)callback[0]).getName();
            String password = String.valueOf(((PasswordCallback)callback[1]).getPassword());
            System.out.println(name);
            System.out.println(password);
            System.out.println(validate(name, password));
		int n = validate(name, password);
        if(n==1||n==2)
		{
                login=name;
		    if(n==1)
			{
               userGroup = new ArrayList<String>();
			   userGroup.add("student");
               return true;
			}
		    else if(n==2)
			{
			    System.out.println("adding user");
                 userGroup = new ArrayList<String>();
                userGroup.add("management");
                return true;
			}
        }
		else
		{
                throw new LoginException("Authentication Failed...");
                //return false;
        }
        }
	catch(Exception ex)
	  {
            throw new LoginException(ex.getMessage());
           // System.out.println(ex);
           // System.out.println("This is the exception from login module");
            //return false;
        }
        return false;
    }
    @Override
    public boolean abort() throws LoginException {
        return false;
    }

    @Override
    public boolean commit() throws LoginException {
        userPrincipal = new UserPrincipal(login);
        subject.getPrincipals().add(userPrincipal);
        if(
            userGroup != null &&
            userGroup.size()>0
        ){
            for(String groupName:userGroup){
                rolePrincipal = new RolePrincipal(groupName);
                subject.getPrincipals().add(rolePrincipal);
                System.out.println("commit underway: "+groupName);
                //return true;
            }
        }
        return true;
    }
    @Override
    public boolean logout() throws LoginException {
        subject.getPrincipals().remove(userPrincipal);
        subject.getPrincipals().remove(rolePrincipal);
        return true;
    }
    
}
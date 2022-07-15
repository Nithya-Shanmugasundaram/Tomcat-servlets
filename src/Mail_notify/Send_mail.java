package Mail_notify;

import javax.mail.Session; 
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import javax.mail.*;

public class Send_mail {

	public boolean send_mail(int roll_no,String subject,int sem_no,String mailid)
	{
		String sender_mail="manageautomail@gmail.com";
		String pwd="12345678@mgmtclg";
		Properties props = new Properties();
		props.put("mail.smpt.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
		Session session = Session.getInstance(props,new javax.mail.Authenticator()
		{
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(sender_mail, pwd);
			}
		});
		try
		{
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(sender_mail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(mailid));//sending mail to student mail id
			msg.setSubject("Revaluation Acknowledgement");
			msg.setText("Thank you for applying for Reevaluation. Your marks will be updated shortly. You have applied reevaluation"
					+" for the subject Id: "+subject+" on the semester :"+sem_no+"\nSuccessfully Applied revaluvation for the above said details \nThank you,\nManagement.");
			Transport.send(msg);
			
			MimeMessage msg1 = new MimeMessage(session);
			msg1.setFrom(new InternetAddress(sender_mail));
			msg1.addRecipient(Message.RecipientType.TO, new InternetAddress("mgmtclg2013@gmail.com"));//sending mail to management mail id
			msg1.setSubject("Revaluation Details");
			msg1.setText("The Student of roll no."+roll_no+" has applied for reevaluation"
					+"for the subject Id: "+subject+" on the semester: "+sem_no+"\n So, you are kindly requested to reevaluate the said subject of the mentioned student and update the marks in the databse accordingly\nThank you,\nManagement.");
			Transport.send(msg1);
		}
		catch(MessagingException e){
			System.out.println(e);
			return false;
		}
		return true;
	}
}

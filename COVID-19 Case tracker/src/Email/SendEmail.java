package Email;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;
import javax.mail.Authenticator;
import javax.mail.Message;

public class SendEmail {

		public static void sendMail(String recepient) throws Exception {
			System.out.println("Preparing to send Email");
			Properties properties = new Properties();
			
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.port", "587");
			properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
			//Here Insert your Email Address
			String myAccountEmail = "manousakismanou@gmail.com";
			//Here Insert your password
			String password = "manos2001";
			
			Session session = Session.getInstance(properties, new Authenticator(){
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(myAccountEmail, password);
				}
			});
			
			Message message = prepareMessage(session, myAccountEmail, recepient);
			
			Transport.send(message);
			System.out.println("Message sent succesfully");
		}

		private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
			try {
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(myAccountEmail));
				message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
				//Here insert Subject
				message.setSubject("TO email erxetai apo java");
				//Here insert the Email text
				message.setText("helloooo");
				return message;
			} catch (Exception ex) {
				Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
			}
			return null;
		}
		
		
}

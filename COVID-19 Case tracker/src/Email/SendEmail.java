package Email;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import loginscreen.RegisterController;

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
				message.setSubject("Covid-19 Case Tracking System");
				//Here insert the Email text
				message.setText("We want to inform you that a friend of your's, who states that met you in the last 14 days, has tested positive today for Covid-19.\r\n"
						+ "We recommend for your own and global good to get tested for Covid-19.\r\n"
						+ "						The Covid-19 Tracker \r\n"
						+ "						 Development team.");
				return message;
			} catch (Exception ex) {
				Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
			}
			return null;
		}
		
		
}

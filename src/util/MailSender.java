package util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import util.logger.NetworkLogger;

public class MailSender implements IMail{
	public static final String MAIL = "mail.smpt.host";
	private String myFromAddress;
	private String[] myToAddress;
	private String myServerAddress;
	private String mySubject = "No Subject";
	private String myMessage;
	
	public MailSender(String from, String[] to,
			String server, String subject, String message) {
		setProperties(from,to,server,subject,message);
	}
	
	@Override
	public void setProperties(String from, String[] to,
			String server, String subject, String message) {
		myFromAddress = from;
		myToAddress = to;
		myServerAddress = server;
		mySubject = subject;
		myMessage = message;
	}
	
	public void sendMail(String from, String[] to,
			String server, String subject, String message) {
		setProperties(from,to,server,subject,message);
		sendMail();
	}

	public void sendMail() {
		try {
			Properties properties = new Properties();
			properties.put(MAIL, myServerAddress);
			Session session = 
					Session.getDefaultInstance(properties, null);
			session.setDebug(true);
			Message mimeMsg = new MimeMessage(session);
			Address from = new InternetAddress(myFromAddress);
			mimeMsg.setFrom(from);
			Address[] to = new InternetAddress[myToAddress.length];
			for(int i = 0; i < myToAddress.length; i++)
		        to[i] = new InternetAddress(myToAddress[i]);
			mimeMsg.setRecipients(Message.RecipientType.TO,to);
			mimeMsg.setSubject(mySubject);
			mimeMsg.setText(myMessage);
			Transport.send(mimeMsg);

		} catch (AddressException e) {
			NetworkLogger.logMessage("Error in choosing e-mail address\n"+e.toString());
		} catch (MessagingException e) {
			NetworkLogger.logMessage("Error in creating e-mail message\n"+e.toString());
		}
	}
}

package util.logger;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

import util.IMail;
import util.MailSender;

public class MailingHandler extends Handler implements IMail{
	private String myFromAddress;
	private String[] myToAddress;
	private String myServerAddress;
	private String mySubject = "No Subject";
	private String myMessage;
	
	@Override
	public void publish(LogRecord record) {
		MailSender mail = new MailSender(myFromAddress,myToAddress, 
				myServerAddress, mySubject, myMessage);
		mail.sendMail();
	}

	@Override
	public void close() throws SecurityException {
		
	}

	@Override
	public void flush() {
		
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
}

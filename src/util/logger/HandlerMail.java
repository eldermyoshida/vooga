package util.logger;

import java.util.logging.Handler;

import util.IMail;

public class HandlerMail implements IVoogaHandler, IMail{
	private MailingHandler myHandler;
	
	public HandlerMail() {
		myHandler = new MailingHandler();
	}
	
	
	public HandlerMail(String from, String[] to, String server,
			String subject, String message) {
		this();
		myHandler.setProperties(from, to, server, subject, message);
	}
	
	@Override
	public Handler getHandler() {
		return myHandler;
	}

	@Override
	public void setProperties(String from, String[] to, String server,
			String subject, String message) {
		myHandler.setProperties(from, to, server, subject, message);		
	}

}

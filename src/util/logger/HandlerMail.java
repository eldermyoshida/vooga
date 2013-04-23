package util.logger;

import java.util.logging.Handler;

import util.IMail;

/**
 * Class that sets a mail handler to the logger that sends records 
 * vie e-mail
 * 
 * @author Henrique Moraes
 * 
 */
public class HandlerMail implements IVoogaHandler, IMail{
	private MailingHandler myHandler;
	
	/**
	 * Constructor
	 */
	public HandlerMail() {
		myHandler = new MailingHandler();
	}
	
	/**
	 * Constructor
	 * @param from Address from which the e-mail is sent
	 * @param to String array with recipients to send e-mail to
	 * @param server Server address
	 * @param subject Subject of e-mail
	 * @param message Text in e-mail
	 */
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

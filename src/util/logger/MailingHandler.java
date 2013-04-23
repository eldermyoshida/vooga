package util.logger;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class MailingHandler extends Handler {
	
	@Override
	public void publish(LogRecord record) {
		new MailSender()
	}

	@Override
	public void close() throws SecurityException {
		
	}

	@Override
	public void flush() {
		
	}
}

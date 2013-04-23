package util.logger;

import java.util.logging.Handler;

public class HandlerMail implements IVoogaHandler{
	private String myFrom;
	private String[] myTo;
	
	public void setFrom(String from) {
		myFrom = from;
	}
	
	public void setTo(String[] to){
		myTo = to;
	}
	
	@Override
	public Handler getHandler() {
		// TODO Auto-generated method stub
		return null;
	}

}

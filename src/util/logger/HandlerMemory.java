package util.logger;

import java.util.logging.Handler;
import java.util.logging.Level;

public class HandlerMemory implements IVoogaHandler{
	private static final Level DEFAULT_LEVEL = Level.INFO;
	private static final int DEFAULT_LIMIT = 100;
	
	private Level myLevel;
	private int mySize;
	private IVoogaHandler myHandler;
	
	public HandlerMemory(IVoogaHandler hand, int size, Level pushLevel) {
		myLevel = pushLevel;
		myHandler = hand;
		mySize = size;
	}
	
	public HandlerMemory() {
		myLevel = DEFAULT_LEVEL;
		mySize = DEFAULT_LIMIT;
	}
	
	public void setHandler(IVoogaHandler hand) {
		myHandler = hand;
	}
	
	public void setSize(int size) {
		mySize = size;
	}
	
	public void setPushLevel(Level level) {
		myLevel = level;
	}
	@Override
	public Handler getHandler() {
		// TODO Auto-generated method stub
		return null;
	}

}

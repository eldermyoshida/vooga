package util.logger;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.MemoryHandler;
import java.util.logging.SocketHandler;

public class HandlerMemory implements IVoogaHandler{
	private static final Level DEFAULT_PUSH_LEVEL = Level.SEVERE;
	private static final Level DEFAULT_HANDLER_LEVEL = Level.INFO;
	private static final int DEFAULT_LIMIT = 100;
	private static final String ERROR_MESSAGE =
            "Error in creating memory format handler";
	
	private Level myPushLevel;
	private Level myHandlerLevel = DEFAULT_HANDLER_LEVEL;
	private int mySize;
	private IVoogaHandler myHandler;
	
	public HandlerMemory(IVoogaHandler hand, int size, Level pushLevel) {
		myPushLevel = pushLevel;
		myHandler = hand;
		mySize = size;
	}
	
	public HandlerMemory() {
		myPushLevel = DEFAULT_PUSH_LEVEL;
		mySize = DEFAULT_LIMIT;
	}
	
	public void setHandler(IVoogaHandler hand) {
		myHandler = hand;
	}
	
	public void setHandlerLevel(Level level) {
		myHandlerLevel = level;
	}
	
	public void setSize(int size) {
		mySize = size;
	}
	
	public void setPushLevel(Level level) {
		myPushLevel = level;
	}
	
	public void setProperties(IVoogaHandler hand, int size, Level level) {
		setHandler(hand);
		setSize(size);
		setPushLevel(level);
	}
	
	@Override
	public Handler getHandler() {
		 Handler memHandler = null;
	        try {
	        	Handler handler = myHandler.getHandler();
	        	handler.setLevel(myHandlerLevel);
	            memHandler = new MemoryHandler(handler,mySize,myPushLevel);
	        }
	        catch (Exception e) {
	            NetworkLogger.LOGGER.severe(ERROR_MESSAGE);
	        }
	        return memHandler;
	}

}

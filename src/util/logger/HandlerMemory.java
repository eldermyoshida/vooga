package util.logger;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.MemoryHandler;
import java.util.logging.SocketHandler;

public class HandlerMemory implements IVoogaHandler{
	private static final Level DEFAULT_LEVEL = Level.INFO;
	private static final int DEFAULT_LIMIT = 100;
	private static final String ERROR_MESSAGE =
            "Error in creating memory format handler";
	
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
	
	public void setProperties(IVoogaHandler hand, int size, Level level) {
		setHandler(hand);
		setSize(size);
		setPushLevel(level);
	}
	
	@Override
	public Handler getHandler() {
		 Handler handler = null;
	        try {
	            handler = new MemoryHandler(myHandler.getHandler(),mySize,myLevel);
	        }
	        catch (Exception e) {
	            NetworkLogger.LOGGER.severe(ERROR_MESSAGE);
	        }
	        return handler;
	}

}

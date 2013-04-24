package vooga.rts.networking.examplechat;

import vooga.rts.networking.communications.GameMessage;
import vooga.rts.networking.communications.UserTimeStamp;

public class ChatMessage extends GameMessage {
    
    private static final long serialVersionUID = -3728664209235141886L;
    private String myMessage;
    
    public ChatMessage (UserTimeStamp stamp, String message) {
        super(stamp);
        myMessage = message;
    }
    
    public String getMessage () {
        return myMessage;
    }

}

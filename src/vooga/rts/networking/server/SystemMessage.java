package vooga.rts.networking.server;

public class SystemMessage extends Message {

    private static final long serialVersionUID = 405038499514244311L;
    private String myMessage;
    
    public SystemMessage (TimeStamp timeStamp, String message) {
        super(timeStamp);
    }
    
    public SystemMessage (String message) {
        myMessage = message;
    }

}

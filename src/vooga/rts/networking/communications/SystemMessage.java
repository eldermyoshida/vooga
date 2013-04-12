package vooga.rts.networking.communications;

import vooga.rts.networking.server.TimeStamp;

/**
 * A SystemLevel Message is used to communicate manegrial information
 * between clients and the server.  This is a subclass of Message that any developers
 * likely will not need to worry about.  It is, however, extensible if they have need of
 * additional system communications.
 * @author srwareham
 *
 */
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

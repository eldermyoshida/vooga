<<<<<<< HEAD:src/vooga/fighter/util/Sound.java
package vooga.fighter.util;
=======
package vooga.rts.util;
>>>>>>> 7362f1f68e473e33a6b1ac1ac75b1d10ad4db368:src/vooga/rts/util/Sound.java

import java.applet.Applet;
import java.applet.AudioClip;


/**
 * This class handles playing sounds and 
 * adds some utility functions to the AudioClip class.
 * 
 * Note, Java only supports the formats: wav, aiff, au, mid, rmf.
 * 
 * @author Robert C. Duvall
 */
public class Sound {
    // OS-independent relative resource locations (like URLs)
    private static final String RESOURCE_LOCATION = "/vooga/rts/sounds/";
    // underlying implementation
    private AudioClip myClip;


    /**
     * Construct a sound with the data referred to by the given filename.
     */
    public Sound (String filename) {
        setSound(filename);
    }

    /**
     * Set this sound to the data referred to by the given filename.
     */
    public void setSound (String filename) {
        myClip = Applet.newAudioClip(getClass().getResource(RESOURCE_LOCATION + filename));
    }

    /**
     * Play the given sound.
     */
    public void play () {
        myClip.play();
    }

    /**
     * Stop playing the given sound.
     */
    public void stop () {
        myClip.stop();
    }
}

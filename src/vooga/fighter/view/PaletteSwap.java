package vooga.fighter.view;

import vooga.fighter.util.Pixmap;

public class PaletteSwap {
    // palette swapping is a common practice in fighting games
    // palette swapping can be used to create new character models by recycling old ones
    // palette swapping can also be used to help players distinguish each other when they both
    // select the same character
    private Pixmap ObjectImage;

    public PaletteSwap () {

    }

    public Color originalColor () {

    }

    public Color newColor (Color c) {

    }

    public void applyNewColor () {
        ObjectImage.invertColor();
    }

}
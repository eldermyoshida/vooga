package vooga.scroller.sprites.animation;

import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;


/**
 * Factory that creates animations based on the various images to be used in a standard
 * left-right movement animation of a sprite.
 * 
 * 
 * @author Scott Valentine
 * 
 */
public class MovingSpriteAnimationFactory {

    private static final String STAND_LEFT_ENDING = "_stand_left";
    private static final String MOVE_LEFT_ENDING = "_move_left";
    private static final String STAND_RIGHT_ENDING = "_stand_right";
    private static final String MOVE_RIGHT_ENDING = "_move_right";
    private static final String DEFAULT_ENDING = "";

    private static final String DEFAULT_SEPARATOR = "[.]";
    private static final String FILE_EXTENSION_SEPARATOR = ".";

    private Pixmap myDefaultView;
    private Pixmap myStandLeft;
    private Pixmap myMoveLeft;
    private Pixmap myStandRight;
    private Pixmap myMoveRight;

    /**
     * Ugly, but at the same time, not that bad. This lets us define generic sprite animations
     * by the views that the sprite uses. One cool thing we could do would be to take in just a
     * string of a package path. From that, we could load in the images based on the default values
     * for sprite image file names.
     * 
     * @param defaultView is the default view of the sprite.
     * @param moveLeft is the view of the sprite moving left.
     * @param standLeft is the view of the sprite standing left.
     * @param moveRight is the view of the sprite moving right.
     * @param standRight is the view of the sprite standing right.
     */
    public MovingSpriteAnimationFactory (Pixmap defaultView, Pixmap moveLeft,
                                         Pixmap standLeft, Pixmap moveRight,
                                         Pixmap standRight) {
        myDefaultView = defaultView;
        myMoveLeft = moveLeft;
        myStandLeft = standLeft;
        myStandRight = standRight;
        myMoveRight = moveRight;
    }

    private String getBaseName (String spriteFilePath) {
        StringBuilder sb = new StringBuilder();
        String[] fileNameParts = spriteFilePath.split(DEFAULT_SEPARATOR);
        for (int i = 0; i < fileNameParts.length - 1; ++i) {
            sb.append(fileNameParts[i]);
        }
        return sb.toString();
    }

    private String getFileFormat (String spriteFilePath) {
        String[] fileNameParts = spriteFilePath.split(DEFAULT_SEPARATOR);
        return FILE_EXTENSION_SEPARATOR + fileNameParts[fileNameParts.length - 1];
    }

    /**
     * Generates an animation that represents a side moving sprite.
     * 
     * This uses the default view to calculate the file paths of all of the other images. Currently
     * these follow the format specified in this file by <code>
     * <ul>
     * <li>DEFAULT_ENDING
     * <li>STAND_RIGHT_ENDING
     * <li>MOVE_RIGHT_ENDING
     * <li>STAND_LEFT_ENDING
     * <li>MOVE_LEFT_ENDING
     * </ul>
     * </code>
     * 
     * @param spriteFilePath is the base filepath for this animation (i.e. "llama.gif")
     * @param sprite is the sprite which uses this animation to display itself.
     * @return The animation that the sprite can use to display.
     */
    public Animation generateAnimation (Sprite sprite, String spriteFilePath) {

        setPixmaps(spriteFilePath);

        Animation result = new Animation(sprite);

        AnimationState left = new MoveLeft(myMoveLeft, myStandLeft);
        AnimationState right = new MoveRight(myMoveRight, myStandRight);

        result.addAnimationState(right);
        result.addAnimationState(left);

        result.setDefaultView(myDefaultView);

        return result;
    }

    private void setPixmaps (String spriteFilePath) {
        String fileFormat = getFileFormat(spriteFilePath);
        String baseName = getBaseName(spriteFilePath);
        myDefaultView = new Pixmap(baseName + DEFAULT_ENDING + fileFormat);
        myStandRight = new Pixmap(baseName + STAND_RIGHT_ENDING + fileFormat);
        myMoveRight = new Pixmap(baseName + MOVE_RIGHT_ENDING + fileFormat);
        myStandLeft = new Pixmap(baseName + STAND_LEFT_ENDING + fileFormat);
        myMoveLeft = new Pixmap(baseName + MOVE_LEFT_ENDING + fileFormat);
    }

}

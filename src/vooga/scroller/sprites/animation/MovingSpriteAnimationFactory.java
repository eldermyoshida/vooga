package vooga.scroller.sprites.animation;

import vooga.scroller.util.Pixmap;
import vooga.scroller.util.Sprite;

public class MovingSpriteAnimationFactory {//implements AnimationFactory{

    private static final String STAND_LEFT_ENDING = "_stand_left";
    private static final String MOVE_LEFT_ENDING = "_move_left";
    private static final String STAND_RIGHT_ENDING = "_stand_right";
    private static final String MOVE_RIGHT_ENDING = "_move_right";
    private static final String DEFAULT_ENDING = "";
    
    
    
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
     * @param defaultView
     * @param moveLeft
     * @param standLeft
     * @param moveRight
     * @param standRight
     */
    public MovingSpriteAnimationFactory(Pixmap defaultView, Pixmap moveLeft, 
                                        Pixmap standLeft, Pixmap moveRight, 
                                        Pixmap standRight){
        myDefaultView = defaultView;
        myMoveLeft = moveLeft;
        myStandLeft = standLeft;
        myStandRight = standRight;
        myMoveRight = moveRight;
    }
    
    public MovingSpriteAnimationFactory(String spriteFilePath) {
        String fileFormat = getFileFormat(spriteFilePath);
        String baseName = getBaseName(spriteFilePath);
        myDefaultView = new Pixmap(baseName + DEFAULT_ENDING + fileFormat);
        myStandRight = new Pixmap(baseName + STAND_RIGHT_ENDING + fileFormat);
        myMoveRight = new Pixmap(baseName + MOVE_RIGHT_ENDING + fileFormat);
        myStandLeft = new Pixmap(baseName + STAND_LEFT_ENDING + fileFormat);
        myMoveLeft = new Pixmap(baseName + MOVE_LEFT_ENDING + fileFormat);       
    }
    
    private String getBaseName (String spriteFilePath) {
        StringBuilder sb = new StringBuilder();
        String[] fileNameParts = spriteFilePath.split("[.]");
        for(int i =0 ; i< fileNameParts.length-1; ++i) {
            sb.append(fileNameParts[i]);
        }
        return sb.toString();
    }

    private String getFileFormat (String spriteFilePath) {
        String[] fileNameParts = spriteFilePath.split("[.]");
        return '.'+fileNameParts[fileNameParts.length-1];
    }

    
    public Animation generateAnimation (Sprite sprite) {
        
        Animation result = new Animation(sprite);
        
        
        AnimationState left = new MoveLeft(myMoveLeft, myStandLeft);
        AnimationState right = new MoveRight(myMoveRight, myStandRight);


        result.addAnimationState(right);
        result.addAnimationState(left);
        
        result.setDefaultView(myDefaultView);
        
        return result;
    }

    
    
    
}

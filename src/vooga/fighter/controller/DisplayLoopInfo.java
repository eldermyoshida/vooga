package vooga.fighter.controller;

import java.util.List;

import vooga.fighter.model.Mode;
import vooga.fighter.model.utils.ImageDataObject;
import vooga.fighter.util.HUDFactory;

import vooga.fighter.view.HUDElement;

public class DisplayLoopInfo extends DisplayInfo implements ViewDataSource{
    private Mode myMode;
    private List<ImageDataObject> myImageData;

    public DisplayLoopInfo(Mode mode) {
        super();
        myMode = mode;
    	myImageData = mode.getImageData();
        updateInfo();
    }

    protected void addHUDElements () {
        try {
            for (HUDElement e : HUDFactory.getHUDElements(this)) {
                addHUDDisplay(e);
            }
        }
        catch (InstantiationException e) {
            throw new NullPointerException("Could not instantiate HUDElement: " + e.getMessage());
        }
        catch (IllegalAccessException e) {
            throw new NullPointerException("Could not access member variable: " + e.getMessage());
        }
        catch (ClassNotFoundException e) {
            throw new NullPointerException("Could not find class: " + e.getMessage());
        }
    }

    public void updateInfo(){
    	getLocations().clear();
    	getGameObjects().clear();
    	getImageSizes().clear();
    	myImageData = myMode.getImageData();
    	for(ImageDataObject data : myImageData){
    		getGameObjects().add(data.getMyImage());
    		getLocations().add(data.getMyLocation());
    		getImageSizes().add(data.getMySize());
    	}
    }
    
    public void update() {
        updateInfo();
    }
    
    public void clear(){
    	super.clear();
        myImageData.clear();
    }

    public Mode getMode() {
        return myMode;
    }

}

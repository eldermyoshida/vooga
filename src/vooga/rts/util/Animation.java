package vooga.rts.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import vooga.rts.resourcemanager.ResourceManager;


/**
 * This class handles with the animation of images either through a sprite sheet or some other file format
 * 
 * @author Junho oh
 *
 */
public class Animation {
    private Pixmap mySheet;
    private String myFileName;
    public Animation (String fileName) {
        myFileName = fileName;
        //loadFile(myFileName);
    }
    public String getFileName() {
    	return myFileName;
    }
    private void loadFile(String fileName) {
        mySheet = new Pixmap(ResourceManager.getInstance()
                            .<BufferedImage> getFile("fileName", BufferedImage.class));
        //mySheet.pa
    }
    public void listFilesForFolder(File folder) {
        for (File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                System.out.println(fileEntry.getName());
            }
        }
    }
    
    public static void main (String args []) {
    	Animation a = new Animation("animation/crocy");
    	
    	File directory = new File(System.getProperty("user.dir") + "\\bin\\vooga\\rts\\resources\\animation\\crocy\\");
    	File[] files = directory.listFiles();
    	for(File f : files) {
    		System.out.println(f.getName());
    	}
    	//System.out.println(files);
    	//a.listFilesForFolder(b);
    }
}

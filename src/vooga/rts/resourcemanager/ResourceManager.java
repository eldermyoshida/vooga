/**
 * 
 */
package vooga.rts.resourcemanager;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 
 * 
 * @author Jonathan Schmidt
 *
 */
public class ResourceManager {
    
    private Map<String, Object> myResources;
    
    private Queue<File> myLoadQueue;
    
    private Thread loadThread;
    
    private static ResourceManager myInstance;

    /**
     * 
     */
    private ResourceManager () {
        myResources = new HashMap<String, Object>();
        myLoadQueue = new LinkedList<File>();
    }
    
    
    int count = 0;
    public boolean isLoading() {
        count++;
        return count < 100;
        /*
         return loadThread.isBusy();         
         */
    }
    
    public void loadFile(String filename) {
        queueFile(filename);
        load();
    }
    
    public void queueFile(String filename) {
        File newFile = new File(filename);
        if (newFile.exists()) {
            myLoadQueue.add(newFile);
        }
        else {
            System.out.println("No such file");
        }            
    }
    
    public void load() {
        if (!isLoading()) {
            loadThread = new Thread(new Runnable() {
                @Override
                public void run () {
                    loadFiles();
                }
            });
        }
    }
    
    private synchronized void loadFiles() {
        while (!myLoadQueue.isEmpty()) {
            File f = myLoadQueue.poll();
            //if (f.get)
            //myResources.put(f.getPath(), )
        }
    }
    
    public static ResourceManager instance() {
        if (myInstance == null) {
            myInstance = new ResourceManager();
        }
        synchronized (myInstance) {            
            return myInstance;
        }
    }

}

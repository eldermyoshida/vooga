package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Secretary Class that manages file saving and loading
 * Also has other functionality such as writing to a file, counting lines in a file, removing lines from a file
 * Functions:
 * write(String value) --> allows you to write value to a session file
 * count(String fileName, String patternToMatch) --> allows you to count how many lines match a given regex pattern
 * remove(String fileName, String remove) --> allows you to remove String remove from a file
 * saveSession(String fileName) --> allows you to save a session file onto your disk
 * loadSession(String filename, Method method, Object object) --> allows you to load a file from your disk into your machine and perform 
 * whatever method you want on it (that method must take a String as parameter). 
 * 
 * @author Jay Wang
 */

public class Secretary {

    private FileWriter myFileWriter;
    private FileChannel sourceChannel;
    private FileChannel targetChannel;
     /* YOU NEED TO CHANGE THESE THREE ENTITIES ESPESIALLY THE PATH
     */
    private static String FILE_PATH;
    private static String SESSION_FILE;
    private static final String TMP_FILE = "tmp.txt";

    /**
     * To instantiate a Secretary, you need to feed the constructor two strings
     * String directory - the path of the directory where you want the generated file to be saved
     * String fileName - the name you want your file to be
     * @param directory
     * @param fileName
     */
    public Secretary (String directory, String fileName) {
        
        FILE_PATH = directory;
        SESSION_FILE = fileName;
        
        try {
            myFileWriter = new FileWriter(FILE_PATH + SESSION_FILE);
        }
        catch (IOException e) {
            System.err.println("IOException: " + e.getMessage() + " in secretary() constructor");
        }
    }
    
    /*
     * PUBLIC METHODS
     */

    /**
     * This will save the session.txt file into a file called fileName and save
     * that file in src/Files. 
     * 
     * @param String fileName - name of the file (i.e. Example1.txt)
     */
    public void saveSession (String fileName) {
        save(SESSION_FILE, fileName);
    }

    /**
     * This will load the File fileName and iterate through each line of the file
     * allowing the user to do whatever operation he/she chooses based on what 
     * method he/she sends over. 
     * 
     * NOTE - this method must take a String as a parameter 
     * 
     * The user can decide what to do which each line of the file: 
     * parse it, print it to console, etc... 
     * 
     * @param String fileName - name of the file (i.e. Example1.txt)
     * @param String methodName - the name of the method you want to invoke on the line 
     * @param Object object - the class that has the method you want to invoke 
     * @throws NoSuchMethodException 
     * @throws SecurityException 
     * @throws InvocationTargetException 
     * @throws IllegalAccessException 
     * @throws IOException 
     * @throws IllegalArgumentException 
     */
    public void loadSession (String fileName, String methodName, Object object)
                                                                               throws SecurityException,
                                                                               NoSuchMethodException,
                                                                               IllegalArgumentException,
                                                                               IOException,
                                                                               IllegalAccessException,
                                                                               InvocationTargetException {

        BufferedReader reader = getReader(fileName);
        String line;
        @SuppressWarnings("rawtypes")
        Class[] parameterTypes = { String.class };
        Method method = object.getClass().getMethod(methodName, parameterTypes);

        while ((line = reader.readLine()) != null) {
            method.invoke(object, line);

        }
        reader.close();
    }
    
    /**
     * This will write the string parameter to the session.txt file. 
     * 
     * @param String string - the string that is going to be written to the file 
     */
    public void write (String string) {
        write(myFileWriter, string);
    }
    
    /**
     * This method will count of the number of occurrences of a given line pattern
     * in a file. The user needs to send a patternToMatch (regular expression). This method 
     * will return the number of occurrences of lines in the file that match the given 
     * pattern. 
     * 
     * @param String fileName - name of the file (i.e. Example1.txt)
     * @param String patternToMatch - the pattern that you want a line to match to
     * @return An integer of the number of occurrences of search in the file. 
     */
    public int count (String fileName, String patternToMatch) {
        String line;
        int count = 0;
        BufferedReader reader = getReader(fileName);
        Pattern pattern = Pattern.compile(patternToMatch);
        
        try {
            while ((line = reader.readLine()) != null) {
                Matcher match = pattern.matcher(line); 
                if (match.find()) count++;
            }
            reader.close();
        }
        catch (IOException e) {
            System.err.println("IOException: " + e.getMessage() + " in count()");
        }
        return count;
    }
    
    /**
     * The method will remove all occurrences of a given line from a file. May 
     * be useful if the user is trying to filter results. 
     * 
     * @param String fileName - name of the file (i.e. Example1.txt)
     * @param String remove - the line that is to be removed from a file
     */
    public void remove (String fileName, String remove) {
        BufferedReader reader = getReader(fileName);

        String line;
        try {
            FileWriter writer = new FileWriter(FILE_PATH + TMP_FILE);
            while ((line = reader.readLine()) != null) {
                if (!line.equals(remove)) write(writer, line);
            }
            reader.close();
            save(TMP_FILE, fileName);
            new File(FILE_PATH + TMP_FILE).delete();
        }
        catch (IOException e) {
            System.err.println("IOException: " + e.getMessage() + " in remove()");
        }
    }
    

    /*
     * PRIVATE METHODS
     */

    private void save (String fileToCopy, String fileToSave) {

        File copy = new File(FILE_PATH + fileToCopy);
        File save = new File(FILE_PATH + fileToSave);
        try {
            sourceChannel = new FileInputStream(copy).getChannel();
            targetChannel = new FileOutputStream(save).getChannel();
            targetChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
        }
        catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException: " + e.getMessage());
        }
        catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
        finally {
            try {
                if (sourceChannel != null) {
                    sourceChannel.close();
                }
                if (targetChannel != null) {
                    targetChannel.close();
                }
            }
            catch (IOException e) {
                System.err.println("IOException: " + e.getMessage() + " in save()");
            }
        }
    }
    
    private void write (FileWriter writer, String string) {
        try {
            writer.write(string + System.getProperty("line.separator"));
            writer.flush();
        }

        catch (IOException e) {
            System.err.println("IOException: " + e.getMessage() + " in write()");
        }
    }

    private BufferedReader getReader (String fileName) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(FILE_PATH + fileName));
        }
        catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException: " + e.getMessage() + " in getReader()");
        }
        return reader;
    }
}
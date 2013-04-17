package vooga.rts.networking.factory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandFactory {

    private static final String RESOURCES_LOCATION = "/vooga/rts/networking/resources/";
    private static final String CLASS_LOCATION = "vooga.rts.networking.factory";
    private Map<String, Command> myCommands = new HashMap<String, Command>();
    
    public CommandFactory () {
        loadCommands();
    }
    
    private void loadCommands () {
        Scanner scanner = getScanner("classes.properties");
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] arguments = line.split("=");
            addCommand(arguments);
        }
    }

    private void addCommand (String[] arguments) {
        try {
            Class<?> newClass = Class.forName(CLASS_LOCATION + arguments[1]);
            myCommands.put(arguments[0], (Command) newClass.newInstance());
        }
        catch (InstantiationException e) {
            // TODO logger
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            // TODO logger
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            // TODO logger
            e.printStackTrace();
        }
    }
    
    private Scanner getScanner (String fileName) {
        File file = new File(RESOURCES_LOCATION + fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            return new Scanner(reader);
        }
        catch (FileNotFoundException e) {
            // TODO logger
            e.printStackTrace();
        }
        return null;
    }
    
    public Command getCommand(String commandName) {
        return myCommands.get(commandName);
    }
}

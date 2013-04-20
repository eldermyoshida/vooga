package tests;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import util.Secretary;


public class SecretaryTestOne {

    private Secretary mySecretary;
    
    public SecretaryTestOne () throws IOException {
        new Secretary("src/tests/", "Example1.txt");

    }

    public void permutation (String str) throws IOException {
        permutation("", str);
    }

    private void permutation (String prefix, String str) throws IOException {
        int n = str.length();

        if (n == 0) {
            mySecretary.write(prefix);
        }

        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
        }
    }

    private void saveSession () throws IOException {
        mySecretary.saveSession("Example1.txt");
    }

    private void loadSession () throws IllegalArgumentException, IOException, IllegalAccessException, InvocationTargetException {
        try {
            mySecretary.loadSession("Example1.txt", "printLine", this);
        }
        catch (SecurityException e) {
            e.printStackTrace();
        }
        catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    
    
    public void printLine (String string) {
        System.out.println(string);
    }
    
    

    public static void main (String[] args) throws IllegalArgumentException, IOException, IllegalAccessException, InvocationTargetException {
        SecretaryTestOne test = new SecretaryTestOne();
        test.permutation("hello");
//        test.saveSession();
        test.loadSession();
    }
}

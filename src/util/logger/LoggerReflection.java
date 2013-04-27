package util.logger;

public class LoggerReflection {

    private LoggerReflection(){
    }
    
    public static String getCallerClassName() {
        return getElement().getClassName();
    }
    
    public static String getCallerMethodName() {
        return getElement().getMethodName();
    }
    
    private static StackTraceElement getElement() {
        StackTraceElement[] element = Thread.currentThread().getStackTrace();
        return element[4];
    }
}

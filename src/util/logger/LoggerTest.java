package util.logger;

import java.util.logging.Level;

public class LoggerTest {
    public static void main(String[] args) {
        LoggerManager log = new LoggerManager();
        log.log(Level.INFO, "Logger Name is " + log.getLogger().getName());
        log.addLogHandler("NewLoggerTest");
        logEachType(log);
        log.log(Level.SEVERE, "Severe Test Message");
        log.log(Level.INFO, "Finer Test Message");
        log.log(level, message)
    }
    private void logEachType(LoggerManager log) {
        
    }
}

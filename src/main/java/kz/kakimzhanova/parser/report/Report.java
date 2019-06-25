package kz.kakimzhanova.parser.report;

import kz.kakimzhanova.parser.entity.Component;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Report {
    private static Logger logger = LogManager.getLogger();
    public void printComponentReport(Component component){
        logger.log(Level.INFO, component);
    }
}

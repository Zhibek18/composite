package kz.kakimzhanova.task.parser;

import kz.kakimzhanova.task.entity.composite.ComponentType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class TextParser extends AbstractParser {
    private static Logger logger = LogManager.getLogger();
    private static final String REGEX = "[.!?]+\n";  
    public TextParser(AbstractParser successor) {
        super(successor, ComponentType.TEXT);
    }

    public String[] parse (String s){
        s = s.trim().replaceAll("[ ]+"," ");
        String[] strs = s.split(REGEX);
        for (String str : strs){
            logger.log(Level.DEBUG, str);
        }
        return strs;
    }
}

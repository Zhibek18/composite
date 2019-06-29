package kz.kakimzhanova.composite.parser;

import kz.kakimzhanova.composite.entity.CompositeType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class TextParser extends AbstractParser {
    private static Logger logger = LogManager.getLogger();
    public TextParser(AbstractParser successor) {
        super(successor, CompositeType.TEXT);
    }

    public String[] parse (String s){
        String[] strs = s.split("[.!?]+\n");
        for (String str : strs){
            logger.log(Level.DEBUG, str);
        }
        return strs;
    }
}

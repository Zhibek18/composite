package kz.kakimzhanova.task.parser;

import kz.kakimzhanova.task.entity.composite.CompositeType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SentenceParser extends AbstractParser {
    Logger logger = LogManager.getLogger();
    private static final String REGEX = "\\s";
    public SentenceParser(AbstractParser successor){
        super(successor, CompositeType.SENTENCE);
    }

    public String[] parse (String s){
        s = s.trim().replaceAll("[ ]+"," ");
        logger.log(Level.DEBUG, s);
        return s.split(REGEX);
    }

}

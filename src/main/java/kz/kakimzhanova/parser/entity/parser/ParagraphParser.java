package kz.kakimzhanova.parser.entity.parser;

import kz.kakimzhanova.parser.entity.Component;
import kz.kakimzhanova.parser.entity.Composite;
import kz.kakimzhanova.parser.entity.CompositeType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ParagraphParser extends AbstractParser {
    private static Logger logger = LogManager.getLogger();
    public ParagraphParser (AbstractParser successor){
        super(successor, CompositeType.PARAGRAPH);
    }
    public String[] parse (String s){
        return s.split("\\.");
    }

}

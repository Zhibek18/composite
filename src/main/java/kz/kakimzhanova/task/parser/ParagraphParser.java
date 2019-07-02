package kz.kakimzhanova.task.parser;

import kz.kakimzhanova.task.entity.composite.Component;
import kz.kakimzhanova.task.entity.composite.ComponentType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends AbstractParser {
    Logger logger = LogManager.getLogger();
    private static final String REGEX = ".+[.!?]";
    public ParagraphParser (AbstractParser successor){
        super(successor, ComponentType.PARAGRAPH);
    }
    @Override
    public String[] parse (String s){
        s = s.trim().replaceAll("(\n|[  ])"," ");
        logger.log(Level.DEBUG, s);
        StringBuilder stringBuilder = new StringBuilder();
        String result;
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            stringBuilder.append(matcher.group());
            logger.log(Level.DEBUG, stringBuilder.toString());
            stringBuilder.append("\n");
        }
        result = stringBuilder.toString();
        //logger.log(Level.DEBUG, result);
        return result.split("\n");
        //return s.split(REGEX);
    }

}

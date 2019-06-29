package kz.kakimzhanova.task.parser;

import kz.kakimzhanova.task.entity.composite.CompositeType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LexemeParser extends AbstractParser {
    Logger logger = LogManager.getLogger();
    private static final String REGEX = "([\\W&&[^\\s-.?!]]|(\\w+-)+\\w+|\\w+|(-))";
    public LexemeParser(AbstractParser successor){
        super(successor, CompositeType.LEXEME);
    }
    @Override
    public String[] parse (String s) {
        s = s.trim().replaceAll("[ ]+","");
       StringBuilder stringBuilder = new StringBuilder();
       String result;
       Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            stringBuilder.append(matcher.group());
            stringBuilder.append(" ");
        }
        result = stringBuilder.toString();
        logger.log(Level.DEBUG, result);
        return result.split(" ");
    }

}

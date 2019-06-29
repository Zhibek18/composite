package kz.kakimzhanova.composite.parser;

import kz.kakimzhanova.composite.entity.CompositeType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LexemeParser extends AbstractParser {
    Logger logger = LogManager.getLogger();
    public LexemeParser(AbstractParser successor){
        super(successor, CompositeType.LEXEME);
    }
    @Override
    public String[] parse (String s) {
       StringBuilder stringBuilder = new StringBuilder();
       String result;
       Pattern pattern = Pattern.compile("([\\W&&[^\\s-.?!]]| - |\\w+)");
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

package kz.kakimzhanova.task.parser;

import kz.kakimzhanova.task.entity.composite.ComponentType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TextParser extends AbstractParser {
    private static Logger logger = LogManager.getLogger();
    private static final String REGEX = "\n\n";
    public TextParser(AbstractParser successor) {
        super(successor, ComponentType.TEXT);
    }

    public String[] parse (String s){
        s = s.trim().replaceAll("[ ]+"," ");
        logger.log(Level.DEBUG, s);
//        StringBuilder stringBuilder = new StringBuilder();
        String[] result;
//        Pattern pattern = Pattern.compile(REGEX, Pattern.MULTILINE);
//        Matcher matcher = pattern.matcher(s);
//        while (matcher.find()){
//            stringBuilder.append(matcher.group());
//            logger.log(Level.DEBUG, stringBuilder.toString());
//            stringBuilder.append("!ParagraphEnd!");
//        }
//        result = stringBuilder.toString();
//        //logger.log(Level.DEBUG, result);
//        return result.split("!ParagraphEnd!");

        result = s.split(REGEX);

        logger.log(Level.DEBUG, result);
        return result;
    }
}

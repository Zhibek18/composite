package kz.kakimzhanova.task.parser;

import kz.kakimzhanova.task.entity.composite.ComponentType;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends AbstractParser {
    private static final String REGEX = ".+?[.!?]";
    public ParagraphParser (AbstractParser successor){
        super(successor, ComponentType.PARAGRAPH);
    }
    @Override
    public String[] parse (String s){
        s = s.replaceAll("[ ]+"," ");
        StringBuilder stringBuilder = new StringBuilder();
        String result;
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            stringBuilder.append(matcher.group());
            stringBuilder.append("#sentenceEnd#");
        }
        result = stringBuilder.toString();
        return result.split("#sentenceEnd#");
    }

}

package kz.kakimzhanova.task.parser;

import kz.kakimzhanova.task.entity.composite.ComponentType;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser extends AbstractParser {
    private static final String REGEX = "([(\\W&&[^-]]|(\\w+-)+\\w+|\\w+|(-))";
    public LexemeParser(AbstractParser successor) {
        super(successor, ComponentType.LEXEME);
    }
    @Override
    public String[] parse (String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String result;
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            stringBuilder.append(matcher.group());
            stringBuilder.append("#LexemeEnd#");
        }
        result = stringBuilder.toString();
        return result.split("#LexemeEnd#");
    }
}

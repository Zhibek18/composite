package kz.kakimzhanova.task.parser;

import kz.kakimzhanova.task.entity.composite.ComponentType;

public class TextParser extends AbstractParser {
    private static final String REGEX = "\n\n";
    public TextParser(AbstractParser successor) {
        super(successor, ComponentType.TEXT);
    }

    public String[] parse (String s){
        s = s.trim().replaceAll("[ ]+"," ");
        String[] result;
        result = s.split(REGEX);
        return result;
    }
}

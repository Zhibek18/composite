package kz.kakimzhanova.task.parser;

import kz.kakimzhanova.task.entity.composite.ComponentType;

public class TextParser extends AbstractParser {
    private static final String REGEX = "\n";
    public TextParser(AbstractParser successor) {
        super(successor, ComponentType.TEXT);
    }

    @Override
    public String[] parse (String s){
        s = s.replaceAll("[ ]+"," ");
        return s.split(REGEX);
    }
}

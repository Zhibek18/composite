package kz.kakimzhanova.task.parser;

import kz.kakimzhanova.task.entity.composite.ComponentType;

public class SentenceParser extends AbstractParser {
    private static final String REGEX = "\\s";
    public SentenceParser(AbstractParser successor){
        super(successor, ComponentType.SENTENCE);
    }

    public String[] parse (String s){
        s = s.replaceAll("[ ]+"," ");
        return s.split(REGEX);
    }

}

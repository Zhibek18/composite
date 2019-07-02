package kz.kakimzhanova.task.parser;

import kz.kakimzhanova.task.entity.composite.ComponentType;

public class ParagraphParser extends AbstractParser {
    private static final String REGEX = "[.!?]";
    public ParagraphParser (AbstractParser successor){
        super(successor, ComponentType.PARAGRAPH);
    }
    public String[] parse (String s){
        s = s.trim().replaceAll("[ ]+"," ");
        return s.split(REGEX);
    }

}

package kz.kakimzhanova.task.parser;

import kz.kakimzhanova.task.entity.composite.CompositeType;

public class ParagraphParser extends AbstractParser {
    private static final String REGEX = "[.!?]";
    public ParagraphParser (AbstractParser successor){
        super(successor, CompositeType.PARAGRAPH);
    }
    public String[] parse (String s){
        s = s.trim().replaceAll("[ ]+"," ");
        return s.split(REGEX);
    }

}

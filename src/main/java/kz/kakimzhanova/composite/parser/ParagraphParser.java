package kz.kakimzhanova.composite.parser;

import kz.kakimzhanova.composite.entity.CompositeType;

public class ParagraphParser extends AbstractParser {
    public ParagraphParser (AbstractParser successor){
        super(successor, CompositeType.PARAGRAPH);
    }
    public String[] parse (String s){
        return s.split("[.!?]");
    }

}
